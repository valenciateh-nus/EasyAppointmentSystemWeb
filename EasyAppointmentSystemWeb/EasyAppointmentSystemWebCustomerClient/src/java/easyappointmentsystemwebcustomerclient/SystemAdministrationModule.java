/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyappointmentsystemwebcustomerclient;

import ejb.session.stateful.BookingSessionBeanRemote;
import ejb.session.stateless.AppointmentEntitySessionBeanRemote;
import ejb.session.stateless.BusinessCategoryEntitySessionBeanRemote;
import ejb.session.stateless.CustomerEntitySessionBeanRemote;
import ejb.session.stateless.EmailSessionBeanRemote;
import ejb.session.stateless.ServiceProviderEntitySessionBeanRemote;
import entity.AdminEntity;
import entity.AppointmentEntity;
import entity.BusinessCategoryEntity;
import entity.CustomerEntity;
import entity.ServiceProviderEntity;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import util.exception.AppointmentNotFoundException;
import util.exception.AppointmentNumberExistsException;
import util.exception.BusinessCategoryNotFoundException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidAddAppointmentException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.UnknownPersistenceException;

/**
 *
 * @author adele
 */
public class SystemAdministrationModule {

    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    private CustomerEntity currentCustomerEntity;
    private CustomerEntitySessionBeanRemote customerEntitySessionBeanRemote;
    private ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote;
    private BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote;
    private EmailSessionBeanRemote emailSessionBeanRemote;
    private AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote;
    private BookingSessionBeanRemote bookingSessionBeanRemote;

    private AdminEntity currentAdminEntity;

    private Queue queueCheckoutNotification;
    private ConnectionFactory queueCheckoutNotificationFactory;

    public SystemAdministrationModule() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public SystemAdministrationModule(CustomerEntity customerEntity, AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote, BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote, CustomerEntitySessionBeanRemote customerEntitySessionBeanRemote, ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote, BookingSessionBeanRemote bookingSessionBeanRemote, CustomerEntity currentCustomerEntity, Queue queueCheckoutNotification, ConnectionFactory queueCheckoutNotificationFactory) {
        this();
        this.currentCustomerEntity = customerEntity;
        this.customerEntitySessionBeanRemote = customerEntitySessionBeanRemote;
        this.serviceProviderEntitySessionBeanRemote = serviceProviderEntitySessionBeanRemote;
        this.appointmentEntitySessionBeanRemote = appointmentEntitySessionBeanRemote;
        this.businessCategoryEntitySessionBeanRemote = businessCategoryEntitySessionBeanRemote;
        this.bookingSessionBeanRemote = bookingSessionBeanRemote;

        this.currentAdminEntity = currentAdminEntity;

        this.queueCheckoutNotification = queueCheckoutNotification;
        this.queueCheckoutNotificationFactory = queueCheckoutNotificationFactory;
    }

    public void searchOperation() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.println("*** Customer terminal :: Search Operation ***\n");
        String response = "";
        String firstAvailableTime = "";

        List<BusinessCategoryEntity> businessCategoryEntities = businessCategoryEntitySessionBeanRemote.retrieveAllBusinessCategories();
        for (BusinessCategoryEntity businessCategory : businessCategoryEntities) {
            System.out.printf("%-3s%-10s", businessCategory.getBusinessCategoryId(), businessCategory.getCategory() + " |");
        }
        
        System.out.println("\n");

        do {
            try {
                System.out.print("Enter Business category> ");
                String input = sc.nextLine();
                Long businessCategoryId = Long.parseLong(input);
                System.out.print("Enter City> ");
                String city = sc.nextLine().trim();

                System.out.print("Enter Date (YYYY-MM-DD)> ");
                String currentDate = sc.nextLine().trim();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(currentDate, formatter);
                
                System.out.println();

                System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", "Service Provider Id", "| Name", "| First available Time", "| Address", "| Overall rating\n");

                BusinessCategoryEntity businessCategory = businessCategoryEntitySessionBeanRemote.retrieveBusinessCategoriesById(businessCategoryId);

                List<ServiceProviderEntity> serviceProviders = serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityBySearch(businessCategory.getCategory(), city);

                for (ServiceProviderEntity s : serviceProviders) {
                  
                    List<AppointmentEntity> appointmentEntities = appointmentEntitySessionBeanRemote.retrieveSortedAppointmentsByDate(date.toString(), s.getServiceProviderId());
                    if (appointmentEntities.size() == 11) { 
                        continue;
                    } else {
                        if (appointmentEntities.size() == 0) {
                            firstAvailableTime = "08:30";

                        } else {
                            List<String> times = Arrays.asList("08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17.30", "18.30");
                            List<String> timeSlots = new ArrayList<String>();
                            timeSlots.addAll(times);

                            for (AppointmentEntity appointment : appointmentEntities) {
                                if (timeSlots.contains(appointment.getScheduledTime())) {
                                    timeSlots.remove(appointment.getScheduledTime());
                                }
                            }

                            firstAvailableTime = timeSlots.get(0);
                           
                        }

                        System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", s.getServiceProviderId() , "| " + s.getName() , "| " + firstAvailableTime , "| " + s.getBusinessAddress() , "| " + s.getRating());
                    }
                    
                    System.out.println("\n");

                }
            } catch (ServiceProviderNotFoundException ex) {
                System.out.println("Service Provider cannot be found!\n");
            } catch (BusinessCategoryNotFoundException ex) {
                System.out.println("Business Cateogry cannot be found!\n");
            } catch (DateTimeParseException ex) {
                System.out.println("Please input a valid date in YYYY-MM-DD.\n");
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Please input a valid Business Category Id!\n");
            } catch (AppointmentNotFoundException ex) {
                System.out.println("There are no appointments on this date!\n");
            }

            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print("Exit> ");
            response = sc.nextLine().trim();
        } while (!response.equals("0"));
    }

    public void addAppointment() throws UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException, ServiceProviderNotFoundException {

        Scanner sc = new Scanner(System.in);
        List<String> times = Arrays.asList("08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17:30", "18:30");
        System.out.println("*** Customer terminal :: Add Appointment ***\n");
        List<BusinessCategoryEntity> businessCategoryEntities = businessCategoryEntitySessionBeanRemote.retrieveAllBusinessCategories();
        for (BusinessCategoryEntity businessCategory : businessCategoryEntities) {
            System.out.printf("%-3s%-10s", businessCategory.getBusinessCategoryId(), businessCategory.getCategory() + " |");
        }
        System.out.println("\n");
        String response = "";
        String firstAvailableTime = "";

        do {
            try {
                System.out.print("Enter Business category> ");
                Long input = sc.nextLong(); 
                sc.nextLine();
                System.out.print("Enter City> ");
                String city = sc.nextLine().trim();

                System.out.print("Enter Date (YYYY-MM-DD)> ");
                String currentDate = sc.nextLine().trim();
                
                System.out.println();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(currentDate, formatter);
                String day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);

                System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", "Service Provider Id", "| Name", "| First available Time", "| Address", "| Overall rating\n");
                
                if (!day.equals("Sunday") && LocalDate.now().isBefore(date)) { //insert invalid add appt

                    BusinessCategoryEntity businessCategory = businessCategoryEntitySessionBeanRemote.retrieveBusinessCategoriesById(input);

                    List<ServiceProviderEntity> serviceProviders = serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityBySearch(businessCategory.getCategory(), city);

                    for (ServiceProviderEntity s : serviceProviders) {
                        List<AppointmentEntity> appointmentEntities = appointmentEntitySessionBeanRemote.retrieveSortedAppointmentsByDate(date.toString(), s.getServiceProviderId());
                        if (appointmentEntities.size() == 11) {
                            continue;
                        } else {
                            if (appointmentEntities.size() == 0) {
                                firstAvailableTime = "08:30";
                            } else {
                                List<String> timings = Arrays.asList("08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17.30", "18.30");
                                List<String> timeSlots = new ArrayList<String>();
                                timeSlots.addAll(timings);

                                for (AppointmentEntity appointment : appointmentEntities) {
                                    if (timeSlots.contains(appointment.getScheduledTime().toString())) {
                                        timeSlots.remove(appointment.getScheduledTime().toString());
                                    }
                                }

                                firstAvailableTime = timeSlots.get(0);
                            }
                        }
                        
                        System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", s.getServiceProviderId() , "| " + s.getName() , "| " + firstAvailableTime , "| " + s.getBusinessAddress() , "| " + s.getRating());
                        }
                    
                    System.out.println();
                    
                    }

                    System.out.println("Enter 0 to go back to the previous menu.");
                    System.out.print("Service provider Id> ");
                    response = sc.nextLine().trim();

                    System.out.println();
                    
                    if (!response.equals("0")) {
                        Long serviceProviderId = Long.parseLong(response);

                        List<AppointmentEntity> appointmentEntities = appointmentEntitySessionBeanRemote.retrieveSortedAppointmentsByDate(date.toString(), serviceProviderId);
                        List<String> availableTimings = new ArrayList<String>();

                        //want to find out when he is not available
                        //for each appointment, get the scheduled time. he is not available
                        List<String> timeslots2 = new ArrayList<String>();
                        timeslots2.addAll(times);

                        int index = 0;
                        for (AppointmentEntity a : appointmentEntities) {
                            String scheduledTime = a.getScheduledTime().toString();
                            if (timeslots2.contains(scheduledTime) && !timeslots2.isEmpty()) {
                                index = timeslots2.indexOf(scheduledTime);
                                timeslots2.remove(index);
                            }
                        }

                        System.out.println("Available Appointment Slots:");
                        System.out.println();

                        for (String timings : timeslots2) {
                            System.out.print(timings + " | ");
                        }

                        System.out.println("\n");

                        System.out.println("Enter 0 to go back to the previous menu.");
                        System.out.print("Enter Time> ");
                        response = sc.nextLine().trim();
                        System.out.println();


                        if (!response.equals("0")) {
                            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime time = LocalTime.parse(response, fmt);

                            String currDate = LocalDate.now().toString();
                            LocalDate todayDate = LocalDate.parse(currDate, formatter);
                            LocalDate appointmentDate = date;  

                            String currentTime = LocalTime.now().format(fmt);
                            LocalTime todayTime = LocalTime.parse(currentTime, fmt);
                            LocalTime appointmentTime = time; 

                            int comparison = appointmentDate.compareTo(todayDate);
                            int compare = appointmentTime.compareTo(todayTime);

                            if (comparison == 0) {
                                if (compare < 2) {
                                    System.out.println("Appointment cannot be made!\n");
                                    return;
                                }
                            }

                            if (comparison < 0) {
                                System.out.println("Appointment cannot be made!\n");
                                return;
                            }
                            
                            boolean hasAnotherAppt = false;
                            
                            List<AppointmentEntity> apptList = customerEntitySessionBeanRemote.retrieveCustomerEntityByCustomerId(currentCustomerEntity.getCustomerId()).getAppointmentEntities();
                            apptList.size(); 
                            
                            for (AppointmentEntity a: apptList)
                            {
                                if (a.getScheduledDate().toString().equals(appointmentDate.toString())) 
                                {
                                 
                                    if (a.getScheduledTime().toString().equals(appointmentTime.toString()))
                                    {
                                        System.out.println("You have another appointment scheduled at " + appointmentDate + " on " + appointmentTime + "!\n");
                                        hasAnotherAppt = true;
                                        break;
                                    }
                                }
                            }
                                    
                            
                            if (hasAnotherAppt == false)
                            {
                                boolean validTime = true;
 
                                if (!timeslots2.contains(time.toString())) { 
                                    System.out.println("Time slot is already full!");
                                    validTime = false;
                                }


                                if (validTime == Boolean.TRUE) {

                                    try {
                                        AppointmentEntity appointmentEntity = new AppointmentEntity();
                                        String serviceProviderUIN = serviceProviderId.toString();
                                        String chosenDate = appointmentDate.toString();
                                        String appointmentNumber = serviceProviderUIN + chosenDate.substring(5, 7) + chosenDate.substring(8, 10);
                                        appointmentNumber += appointmentTime.toString().substring(0, 2) + appointmentTime.toString().substring(3, 5);
                                        bookingSessionBeanRemote.addAppointment(appointmentNumber, appointmentTime.toString(), appointmentDate.toString(), currentCustomerEntity, serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityById(serviceProviderId), businessCategoryEntitySessionBeanRemote.retrieveBusinessCategoriesById(input));

                                        Long newAppointmentEntityId = bookingSessionBeanRemote.doBooking(currentCustomerEntity.getCustomerId(), serviceProviderId);
                                        appointmentEntity = appointmentEntitySessionBeanRemote.retrieveAppointmentByAppointmentId(newAppointmentEntityId);
 
                                        System.out.println("Appointment " + appointmentEntity.getAppointmentNo() + " added successfully!\n");

                                    } catch (CustomerNotFoundException ex) {
                                        System.out.println("Customer with customer id " + currentCustomerEntity.getCustomerId() + " not found!\n");
                                    } catch (ServiceProviderNotFoundException ex) {
                                        System.out.println("Service with service provider id " + serviceProviderId + " not found!\n");
                                    } catch (ServiceProviderBlockedException ex) {
                                        System.out.println("Service with service provider id " + serviceProviderId + " is blocked!\n");
                                    } catch (AppointmentNotFoundException ex) {
                                        System.out.println("Appointment cannot be not found!\n");
                                    }

                                    bookingSessionBeanRemote.clearAppointmentCart();
                                }

                                System.out.println("Enter 0 to go back to the previous menu.");
                                System.out.print("Exit> ");
                                response = sc.nextLine().trim();
                            }
                        }
                    
                } else {
                    if (day.equals("Sunday"))
                    {
                        System.out.println();
                        System.out.println("There are Service Provider available on Sunday!");
                    } 
                    else
                    {
                        System.out.println();
                        System.out.println("The date chosen has already passed, please choose another date!");
                    }
                }
            } catch (ServiceProviderNotFoundException ex) {
                System.out.println("Service Provider cannot be found!");
            } catch (BusinessCategoryNotFoundException ex) {
                System.out.println("BusinessCategory cannot be found!");
            } catch (DateTimeParseException ex) {
                System.out.println("Please input a valid date in YYYY-MM-DD, and a valid time in HH-MM.\n");
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Please input a valid Business Category Id!\n");
                sc.next();
            } catch (AppointmentNotFoundException ex) {
                System.out.println("Appointment cannot be found!\n");
            } catch (CustomerNotFoundException ex) {
                System.out.println("Customer cannot be found!\n");
            }
        } while (!response.equals("0"));
        
        System.out.println();
    }

    public void viewAppointments() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Customer terminal :: View Appointments ***\n");
        String response = "";

        try {
            List<AppointmentEntity> appointments = customerEntitySessionBeanRemote.retrieveCustomerEntityByCustomerId(currentCustomerEntity.getCustomerId()).getAppointmentEntities();
            appointments.size();

            System.out.println("Appointments: ");
            System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.");

            for (AppointmentEntity appointment : appointments) {
                System.out.printf("%-15s%-13s%-8s%-15s\n", currentCustomerEntity.getFullName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
            }

            while (!response.equals("0")) {
                System.out.println("Enter 0 to go back to the previous menu.");
                System.out.print(">");
                response = sc.nextLine().trim();
            }
        } catch (CustomerNotFoundException ex) {
            System.out.println("Customer not found!");
        }
    }

    public void cancelAppointment() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("*** Customer terminal :: Cancel Appointment ***\n");
            String response;

            List<AppointmentEntity> appointmentEntities = customerEntitySessionBeanRemote.retrieveCustomerEntityByCustomerId(currentCustomerEntity.getCustomerId()).getAppointmentEntities();
            System.out.println("Appointments: ");
            System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.");

            for (AppointmentEntity appointment : appointmentEntities) {
                System.out.printf("%-15s%-13s%-8s%-15s\n", currentCustomerEntity.getFullName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
            }

            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print("Enter Appointment Id to cancel> ");
            response = sc.nextLine().trim();
            System.out.println();
            String appointmentNo = "";

            while (!response.equals("0")) {
                try {
                    appointmentNo = response;
                    AppointmentEntity appointmentEntity = appointmentEntitySessionBeanRemote.retrieveAppointmentByAppointmentNumber(appointmentNo);

                    
                    LocalDate todayDate = LocalDate.now();
                    
                    String date = appointmentEntity.getScheduledDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate appointmentDate = LocalDate.parse(date, formatter);
            
                    String time = appointmentEntity.getScheduledTime();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime appointmentTime = LocalTime.parse(time, fmt);

                    String currentTime = LocalTime.now().format(fmt);
                    LocalTime todayTime = LocalTime.parse(currentTime, fmt);

                    int comparison = appointmentDate.compareTo(todayDate);
                    int compare = appointmentTime.compareTo(todayTime);

                    if (comparison >= 1) { 
                        int apptYear = appointmentDate.getYear();
                        int currYear = todayDate.getYear();
                        int apptMonth = appointmentDate.getMonthValue();
                        int currMonth = todayDate.getMonthValue();
                        int apptDay = appointmentDate.getDayOfMonth();
                        int currDay = todayDate.getDayOfMonth();

                        if (apptYear > currYear || apptMonth > currMonth || apptDay - currDay > 1) {
                            AppointmentEntity toCancelAppointmentEntity = appointmentEntitySessionBeanRemote.retrieveAppointmentByAppointmentNumber(appointmentNo);
                            appointmentEntitySessionBeanRemote.deleteAppointment(appointmentNo);
                            System.out.println("Appointment successfully cancelled!\n");
                        } else if (apptDay - currDay == 1) {
                            if (compare >= 0) {
                                AppointmentEntity toCancelAppointmentEntity = appointmentEntitySessionBeanRemote.retrieveAppointmentByAppointmentNumber(appointmentNo);
                                appointmentEntitySessionBeanRemote.deleteAppointment(appointmentNo);
                                System.out.println("Appointment successfully cancelled!\n");
                            } else {
                                System.out.println("Appointment cannot be cancelled!\n");
                            }
                        } else {
                            System.out.println("Appointment cannot be cancelled!\n");
                        }
                    } else {
 
                        System.out.println("Appointment cannot be cancelled!\n");

                    }

                } catch (AppointmentNotFoundException ex) {
                    System.out.println("Appointment with id: " + appointmentNo + " does not exist!\n");
                }

                System.out.println("Enter 0 to go back to the previous menu.");
                System.out.print("Enter Appointment Id to cancel> ");
                response = sc.nextLine().trim();
            }
        } catch (CustomerNotFoundException ex) {
            Logger.getLogger(SystemAdministrationModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rateServiceProvider() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Customer terminal :: Rate Service Provider ***\n");
        String response = "";

        do {

            System.out.print("Enter Service Provider Id> ");
            String input = sc.nextLine().trim();

            try {
                Long serviceProviderId = Long.parseLong(input);
                ServiceProviderEntity serviceProvider = serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityById(serviceProviderId);
                System.out.println("You are rating " + serviceProvider.getName() + ".\n");
                List<AppointmentEntity> apptList = appointmentEntitySessionBeanRemote.retrieveAppointmentByCustomer(currentCustomerEntity.getCustomerId(), serviceProvider.getServiceProviderId());
                
                boolean hasUnratedAppt = false;
                Long ratedApptId = 0l;
                
                for (AppointmentEntity a : apptList)
                {
                    String date = a.getScheduledDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate appointmentDate = LocalDate.parse(date, formatter);
            
                    String time = a.getScheduledTime();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime appointmentTime = LocalTime.parse(time, fmt);
                    
                    if (appointmentDate.compareTo(LocalDate.now()) <= 0) 
                    {
                        if (appointmentTime.compareTo(LocalTime.now()) <= 0)
                        {
                            if (a.getHasRating() == false && a.getServiceProviderEntity().getServiceProviderId().equals(serviceProviderId))
                            {
                                hasUnratedAppt = true;
                                ratedApptId = a.getAppointmentId();
                                break;
                            }
                        }
                    }
                }

                if (apptList.isEmpty()) {
                    System.out.println("You do not have any appointment under " + serviceProvider.getName() + "\n");
                } else if (hasUnratedAppt == false) {
                    System.out.println("You do not have any completed appointments under " + serviceProvider.getName() + " that has not been rated!\n");
                } else {
                    System.out.println("Enter 0 to go back to the previous menu.");
                    if (!response.equals("0")) {
                        System.out.print("Enter rating> ");
                        double rating = sc.nextDouble();
                        sc.nextLine();
                        if (rating != 0.0) {
                            if (rating > 5.0 | rating < 0.0) {
                                System.out.println("Please enter a number between 0.0 to 5.0!\n");
                            } else {
                                serviceProviderEntitySessionBeanRemote.updateRating(rating, serviceProvider.getServiceProviderId());
                                appointmentEntitySessionBeanRemote.updateAppointmentEntityRating(ratedApptId);
                                System.out.println("Rating successfully submitted!\n");
                            }
                        }
                    } else {
                        break;
                    }
                }
            } catch (ServiceProviderNotFoundException ex) {
                System.out.println("Service Provider does not exist!\n");
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Please enter a number between 0.0 to 5.0!\n");
            } catch (ServiceProviderBlockedException ex) {
                System.out.println("Service Provider is blocked!\n");
            } catch (AppointmentNotFoundException ex) {
                System.out.println("Appointment not found!\n");;
            }
 
            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print(">");
            response = sc.nextLine().trim();
        } while (!response.equals("0"));

    }

}
