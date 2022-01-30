package easyappointmentsystemwebserviceproviderclient;

import ejb.session.stateless.AppointmentEntitySessionBeanRemote;
import ejb.session.stateless.BusinessCategoryEntitySessionBeanRemote;
import ejb.session.stateless.ServiceProviderEntitySessionBeanRemote;
import entity.AppointmentEntity;
import entity.ServiceProviderEntity;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import util.exception.AppointmentNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.ServiceProviderBlockedException;
import util.exception.ServiceProviderNotFoundException;
import util.exception.ServiceProviderNotUniqueException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateServiceProviderException;

public class MainMenu {

    private final ValidatorFactory validatorFactory;
    private final Validator validator;

    private ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote;

    private BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote;

    private ServiceProviderEntity currentServiceProviderEntity;

    private AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote;

    public MainMenu() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public MainMenu(ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote, ServiceProviderEntity serviceProviderEntity, AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote) {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        this.serviceProviderEntitySessionBeanRemote = serviceProviderEntitySessionBeanRemote;
        this.currentServiceProviderEntity = serviceProviderEntity;
        this.appointmentEntitySessionBeanRemote = appointmentEntitySessionBeanRemote;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Service provider terminal :: Main ***\n");
            System.out.println("You are login as " + currentServiceProviderEntity.getName() + "\n");
            System.out.println("1: View Profile");
            System.out.println("2: Edit Profile");
            System.out.println("3: View Appointments");
            System.out.println("4: Cancel Appointment");
            System.out.println("5: Logout\n");
            response = 0;

            try {

                while (response < 1 || response > 5) {

                    System.out.print("> ");
                    response = sc.nextInt();
                    System.out.println();

                    if (response == 1) {
                        viewProfile();
                    } else if (response == 2) {
                        editProfile();
                    } else if (response == 3) {
                        viewAppointment();
                    } else if (response == 4) {
                        cancelAppointment();
                    } else {
                        System.out.println("Invalid option, please try again!\n");
                    }

                }

                if (response == 5) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number!\n");
                sc.next();
            }

        }
    }

    public void viewProfile() {

        Scanner sc = new Scanner(System.in);
        String response = "";

        System.out.println("*** Service provider terminal :: View Profile ***\n");
        System.out.println("Profile: \n");
        System.out.printf("%-15s%-20s%-30s%-15s%-30s%-15s%-20s%-20s%-15s\n", "Name", "| Business category", "| Business Registration Number", "| City", "| Address", "| Email", "| Phone Number", "| Overall Rating", "| Status\n");
        System.out.printf("%-15s%-20s%-30s%-15s%-30s%-15s%-20s%-20s%-15s\n", currentServiceProviderEntity.getName(), "| " + currentServiceProviderEntity.getBusinessCategory(), "| " + currentServiceProviderEntity.getBusinessRegistrationNumber(), "| " + currentServiceProviderEntity.getCity(), "| " + currentServiceProviderEntity.getBusinessAddress(), "| " + currentServiceProviderEntity.getEmailAddress(), "| " + currentServiceProviderEntity.getPhoneNumber(), "| " + currentServiceProviderEntity.getRating(), "| " + currentServiceProviderEntity.getStatusEnum());

        while (!response.equals("0")) {
            System.out.println();
            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print(">");
            response = sc.nextLine().trim();
        }
    }

    public void editProfile() {
        Scanner sc = new Scanner(System.in);
        String response = "";

        System.out.println("*** Service provider terminal :: Edit Profile ***\n");

        System.out.print("Enter City (blank if no change)> ");
        String city = sc.nextLine().trim();
        if (city.length() > 0) {
            currentServiceProviderEntity.setCity(city);

        }
        System.out.print("Enter Business address (blank if no change)> ");
        String businessAddr = sc.nextLine().trim();
        if (businessAddr.length() > 0) {
            currentServiceProviderEntity.setBusinessAddress(businessAddr);

        }
        System.out.print("Enter Email address (blank if no change)> ");
        String emailAddr = sc.nextLine().trim();
        if (emailAddr.length() > 0) {
            currentServiceProviderEntity.setEmailAddress(emailAddr);

        }
        System.out.print("Enter Phone number (blank if no change)> ");
        String phoneNumber = sc.nextLine().trim();
        if (phoneNumber.length() > 0) {
            currentServiceProviderEntity.setPhoneNumber(phoneNumber);

        }
        System.out.print("Enter Password (blank if no change)> ");
        String password = sc.nextLine().trim();
        if (password.length() > 0) {
            currentServiceProviderEntity.setPassword(password);

        }

        System.out.println();

        Set<ConstraintViolation<ServiceProviderEntity>> constraintViolations = validator.validate(currentServiceProviderEntity);

        if (constraintViolations.isEmpty()) {
            try {
                serviceProviderEntitySessionBeanRemote.updateServiceProvider(currentServiceProviderEntity);
                System.out.print("Update successful!\n");
            } catch (UpdateServiceProviderException | ServiceProviderNotFoundException ex) {
                System.out.print("Profile has NOT been updated!\n");
            } catch (InputDataValidationException ex) {
                System.out.print(ex.getMessage() + "\n");
            } catch (ServiceProviderNotUniqueException ex) {
                System.out.print("This email is already in use!\n");
            } catch (UnknownPersistenceException ex) {
                System.out.print(ex.getMessage() + "\n");
            } catch (ServiceProviderBlockedException ex) {
                System.out.print("Service Provider is blocked!\n");
            }
        } else {
            showInputDataValidationErrorsForServiceProviderEntity(constraintViolations);
        }

        while (!response.equals("0")) {
            System.out.println();
            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print(">");
            response = sc.nextLine().trim();
        }

        System.out.println();
    }

    public void viewAppointment() {
        Scanner sc = new Scanner(System.in);
        String response = "";

        System.out.println("*** Service provider terminal :: View Appointments ***\n");
        System.out.println("Appointments: \n");
        System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.\n");

        try {
//            List<AppointmentEntity> appointments = appointmentEntitySessionBeanRemote.retrieveAppointmentsByServiceProviderId(currentServiceProviderEntity.getServiceProviderId());

            List<AppointmentEntity> appointments = serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityById(currentServiceProviderEntity.getServiceProviderId()).getAppointmentEntities();
            appointments.size();
            
            for (AppointmentEntity appointment : appointments) {
                System.out.printf("%-15s%-13s%-8s%-15s\n", appointment.getCustomerEntity().getFullName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
            }

            System.out.println();

            while (!response.equals("0")) {
                System.out.println();
                System.out.println("Enter 0 to go back to the previous menu.");
                System.out.print(">");
                response = sc.nextLine().trim();
            }
        } catch (ServiceProviderNotFoundException ex) {
            System.out.println("Service Provider Id " + currentServiceProviderEntity.getServiceProviderId() + " does not exists!\n");
        } catch (ServiceProviderBlockedException ex) {
            System.out.println("Service Provider Id " + currentServiceProviderEntity.getServiceProviderId() + " is blocked!\n");
        }
    }

    public void cancelAppointment() {
        Scanner sc = new Scanner(System.in);
        String response = "";
        
        try 
        {

//        List<AppointmentEntity> appointments = appointmentEntitySessionBeanRemote.retrieveAppointmentsByServiceProviderId(currentServiceProviderEntity.getServiceProviderId());
        List<AppointmentEntity> appointments = serviceProviderEntitySessionBeanRemote.retrieveServiceProviderEntityById(currentServiceProviderEntity.getServiceProviderId()).getAppointmentEntities();

        System.out.println("*** Service provider terminal :: Delete Appointments ***\n");
        System.out.println("Appointments: \n");
        System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.\n");

        for (AppointmentEntity appointment : appointments) {
            System.out.printf("%-15s%-13s%-8s%-15s\n", appointment.getCustomerEntity().getFullName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
        }

        System.out.println();

        while (!response.equals("0")) {
            System.out.println();
            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print("Enter Appointment Id> ");
            response = sc.nextLine().trim();
            String appointmentNo;
            appointmentNo = response;

            System.out.println();

            if (!response.equals("0")) {

                try {
                    appointmentNo = response;
                    AppointmentEntity appointmentEntity = appointmentEntitySessionBeanRemote.retrieveAppointmentByAppointmentNumber(appointmentNo);

                    
                    LocalDate todayDate = LocalDate.now();
                    System.out.println("Today's date is " + todayDate.toString());
                    
                    String date = appointmentEntity.getScheduledDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate appointmentDate = LocalDate.parse(date, formatter);
                        
                    
                    System.out.println("Appointment date is " + appointmentDate.toString());
                    
                    String apptTime = appointmentEntity.getScheduledTime();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime appointmentTime = LocalTime.parse(apptTime, fmt);

                    String currentTime = LocalTime.now().format(fmt);
                    LocalTime todayTime = LocalTime.parse(currentTime, fmt);
                    System.out.println("Today time is " + todayTime.toString());
                    System.out.println("Appointment time is " + appointmentTime.toString());

                    int comparison = appointmentDate.compareTo(todayDate);
                    int compare = appointmentTime.compareTo(todayTime);
                    System.out.println("comparison: " + comparison);
                    if (comparison >= 1) { //different days for sure
                        int apptYear = appointmentDate.getYear();
                        int currYear = todayDate.getYear();
                        int apptMonth = appointmentDate.getMonthValue();
                        int currMonth = todayDate.getMonthValue();
                        int apptDay = appointmentDate.getDayOfMonth();
                        int currDay = todayDate.getDayOfMonth();

                        //check whether it is one day from today, if it is check time, else no need do anything
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
                    }

                } catch (AppointmentNotFoundException ex) {
                    System.out.println("Appointment with id: " + appointmentNo + " does not exist!\n");
                }

            } else {
                break;
            }
        }
        } catch (ServiceProviderNotFoundException ex) {
            System.out.println("Service Provider Id : " + currentServiceProviderEntity.getServiceProviderId() + " not found");
        } catch (ServiceProviderBlockedException ex) {
            System.out.println("Service Provider Id : " + currentServiceProviderEntity.getServiceProviderId() + " is blocked!");
        }
        System.out.println();
    }

    private void showInputDataValidationErrorsForServiceProviderEntity(Set<ConstraintViolation<ServiceProviderEntity>> constraintViolations) {
        System.out.println("\nInput data validation error!:");

        for (ConstraintViolation constraintViolation : constraintViolations) {
            System.out.println("\t" + constraintViolation.getPropertyPath() + " - " + constraintViolation.getInvalidValue() + "; " + constraintViolation.getMessage());
        }

        System.out.println("\nPlease try again......\n");
    }

}
