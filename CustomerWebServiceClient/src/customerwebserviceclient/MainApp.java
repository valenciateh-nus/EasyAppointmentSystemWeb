package customerwebserviceclient;

import ws.client.BusinessCategoryExistException_Exception;
import ws.client.BusinessCategoryNotFoundException_Exception;
import ws.client.DeleteBusinessCategoryException_Exception;
import ws.client.InputDataValidationException_Exception;
import ws.client.InvalidLoginCredentialException_Exception;
import ws.client.ServiceProviderNotFoundException_Exception;
import ws.client.UnknownPersistenceException_Exception;
import java.text.ParseException;
import ws.client.LocalDate;
import ws.client.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import ws.client.AppointmentEntity;
import ws.client.AppointmentNotFoundException;
import ws.client.AppointmentNotFoundException_Exception;
import ws.client.AppointmentNumberExistsException;
import ws.client.AppointmentNumberExistsException_Exception;
import ws.client.BusinessCategoryEntity;
import ws.client.BusinessCategoryNotFoundException_Exception;
import ws.client.CustomerDeletionException_Exception;
import ws.client.CustomerNotUniqueException_Exception;
import ws.client.CustomerEntity;
import ws.client.CustomerNotFoundException;
import ws.client.CustomerNotFoundException_Exception;
import ws.client.DeleteBusinessCategoryException_Exception;
import ws.client.InputDataValidationException;
import ws.client.InputDataValidationException_Exception;
import ws.client.InputInvalidValuesException;
import ws.client.InputInvalidValuesException_Exception;
import ws.client.InvalidLoginCredentialException;
import ws.client.InvalidLoginCredentialException_Exception;
import ws.client.ServiceProviderBlockedException;
import ws.client.ServiceProviderBlockedException_Exception;
import ws.client.ServiceProviderEntity;
import ws.client.ServiceProviderNotFoundException;
import ws.client.ServiceProviderNotFoundException_Exception;
import ws.client.UnknownPersistenceException;
import ws.client.UnknownPersistenceException_Exception;
import ws.client.UpdateCustomerException_Exception;

public class MainApp {

    CustomerEntity loggedInCustomer;

    public MainApp() {
    }

    private void logCustomerIn(CustomerEntity customerEntity) {
        loggedInCustomer = customerEntity;
    }
    
    public void runApp()
    {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        while (true) {
            System.out.println("*** Welcome to Customer terminal ***\n");
            System.out.println("1: Registration");
            System.out.println("2: Login");
            System.out.println("3: Exit\n");
            response = 0;

            try
            {
                while (response < 1 || response > 3) {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if (response == 1) {
                        doRegister();

                    } else if (response == 2) {
                        mainApp();
                    } else if (response == 3) {
                        break;
                    } else {
                        System.out.println("Invalid option, please try again!\n");
                    }
                }

                if (response == 3) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid option, please try again!\n");
                scanner.next();
            }
        }
    }

    public void mainApp() {
        try {
            Scanner sc = new Scanner(System.in);
            Integer response;

            System.out.println("*** Welcome to Customer terminal ***\n");
            System.out.print("Enter username> ");
            String email = sc.nextLine().trim();
            System.out.print("Enter password> ");
            String password = sc.nextLine().trim();
            System.out.println();

            CustomerEntity customerEntity = retrieveCustomerByEmail(email, password, email);
            logCustomerIn(customerEntity);

            while (true) {
                System.out.println("*** Customer terminal :: Main ***\n");
                System.out.print("You are login as ");
                System.out.println(customerEntity.getFirstName() + " " + customerEntity.getLastName());
                System.out.println("1: Search Operation");
                System.out.println("2: Add Appointment");
                System.out.println("3: View Appointment");
                System.out.println("4: Cancel Appointment");
                System.out.println("5: Rate Service Provider");
                System.out.println("6: Logout\n");
                response = 0;

                while (response < 1 || response > 6) {
                    System.out.print("> ");

                    response = sc.nextInt();
                    if (response == 1) {
                        searchOperation();
                    } else if (response == 2) {
                        addAppointment();
                    } else if (response == 3) {
                        viewAppointments();
                    } else if (response == 4) {
                        cancelAppointment();
                    } else if (response == 5) {
                        rateServiceProvider();
                    } else if (response == 6) {
                        break;
                    } else {
                        System.out.println("Invalid option, please try again!\n");
                    }
                }

                if (response == 6) {
                    break;
                }
            }

        } catch (InvalidLoginCredentialException_Exception ex) {
            System.out.println("Invalid Login Credential!\n");
        } catch (CustomerNotFoundException_Exception ex) {
            System.out.println("Customer not found!\n");
        }

    }
    
    private void doRegister() {

        Scanner scanner = new Scanner(System.in);
        CustomerEntity customerEntity = new CustomerEntity();

        try {
            System.out.print("Enter Identity Number(NRIC or Passport)> ");
            String identityNumber = scanner.nextLine().trim();

            System.out.print("Enter Password> ");
            String password = scanner.nextLine().trim();

            System.out.print("Enter First Name> ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Enter Last Name> ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Enter Gender> ");
            String gender = scanner.nextLine().trim();
            String input = gender.substring(0,1);

            while (!gender.toLowerCase().equals("F") && !gender.toLowerCase().equals("m") && !gender.toLowerCase().equals("male") && !gender.toLowerCase().equals("female")) 
            {
                System.out.print("Enter Gender> ");
                gender = scanner.nextLine().trim();
                input = gender.substring(0,1);
            }

            System.out.print("Enter Age> ");
            Integer age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Phone number> ");
            String phoneNumber = scanner.nextLine().trim();

            System.out.print("Enter Address> ");
            String address = scanner.nextLine().trim();

            System.out.print("Enter City> ");
            String city = scanner.nextLine().trim();

            System.out.print("Enter Email address> ");
            String email = scanner.nextLine().trim();

            customerEntity.setIdentityNumber(identityNumber);
            customerEntity.setPassword(password);
            customerEntity.setFirstName(firstName);
            customerEntity.setLastName(lastName);
            customerEntity.setGender(input.toUpperCase());
            customerEntity.setAge(age);
            customerEntity.setPhoneNumber(phoneNumber);
            customerEntity.setAddress(address);
            customerEntity.setCity(city);
            customerEntity.setEmailAddress(email);


            Long newCustomerId = createNewCustomer(customerEntity);
            System.out.println("New customer created successfully!: " + newCustomerId + "\n");
            
        } catch (CustomerNotUniqueException_Exception ex) {
            System.out.println("An error has occurred while creating the new customer!: Email or Identification number already registered!\n");
        } catch (UnknownPersistenceException_Exception ex) {
            System.out.println("An unknown error has occurred while creating the new customer!: " + ex.getMessage() + "\n");
        } catch (InputDataValidationException_Exception ex) {
            System.out.println(ex.getMessage() + "\n");
        } catch (InputMismatchException ex) {
            System.out.println("Please enter a valid age value!\n");
        }

        System.out.println();
    }

    public void searchOperation() {

        Scanner sc = new Scanner(System.in);
        System.out.println("*** Customer terminal :: Search Operation ***\n");
        String response = "";
        String firstAvailableTime = "";

        System.out.print("Enter username> ");
        String email = sc.nextLine().trim();
        System.out.print("Enter password> ");
        String password = sc.nextLine().trim();
        System.out.println();

        try {
            CustomerEntity currentCustomerEntity = retrieveCustomerByEmail(email, password, email);
            if (currentCustomerEntity.getCustomerId().equals(loggedInCustomer.getCustomerId())) {

                do {
                    try {

                        List<BusinessCategoryEntity> businessCategoryEntities = retrieveAllBusinessCategories(email, password);
                        for (BusinessCategoryEntity businessCategory : businessCategoryEntities) {
                            System.out.printf("%-3s%-10s", businessCategory.getBusinessCategoryId(), businessCategory.getCategory() + " |");
                        }

                        System.out.println("\n");

                        System.out.print("Enter Business category> ");
                        String input = sc.nextLine();
                        Long businessCategoryId = Long.parseLong(input);
                        System.out.print("Enter City> ");
                        String city = sc.nextLine().trim();

                        System.out.print("Enter Date (YYYY-MM-DD)> ");
                        String currentDate = sc.nextLine().trim();

                        String day = calculateDayOfTheWeek(email, password, currentDate);

                        System.out.println();

                        System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", "Service Provider Id", "| Name", "| First available Time", "| Address", "| Overall rating\n");

                        if (!day.equals("Sunday") && ifDateHasNotPassed(email, password, currentDate)) {
                            BusinessCategoryEntity businessCategory = retrieveBusinessCategoriesById(email, password, businessCategoryId);

                            List<ServiceProviderEntity> serviceProviders = retrieveServiceProviderEntityBySearch(email, password, businessCategory.getCategory(), city);

                            for (ServiceProviderEntity s : serviceProviders) {
                                //each service provider, retrieve their appointment entities for a particular date, sorted by time
                                List<AppointmentEntity> appointmentEntities = retrieveSortedAppointmentsByDate(email, password, currentDate, s.getServiceProviderId());
                                if (appointmentEntities.size() == 11) { //full slots
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

                                    System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", s.getServiceProviderId(), "| " + s.getName(), "| " + firstAvailableTime, "| " + s.getBusinessAddress(), "| " + s.getRating());
                                }

                                System.out.println("\n");

                            }

                        } else {
                            if (day.equals("Sunday")) {
                                System.out.println("There are no Service Providers available on Sunday!");
                            } else {
                                System.out.println("The date you are searching for has passed!");
                            }
                        }

                    } catch (ServiceProviderNotFoundException_Exception ex) {
                        System.out.println("Service Provider cannot be found!\n");
                    } catch (BusinessCategoryNotFoundException_Exception ex) {
                        System.out.println("Business Cateogry cannot be found!\n");
                    } catch (InputInvalidValuesException_Exception ex) {
                        System.out.println("Please input a valid date in YYYY-MM-DD.\n");
                    } catch (InputMismatchException | NumberFormatException ex) {
                        System.out.println("Please input a valid Business Category Id!\n");
                    } catch (AppointmentNotFoundException_Exception ex) {
                        System.out.println("There are no appointments on this date!\n");
                    } catch (InvalidLoginCredentialException_Exception ex) {
                        System.out.println("Invalid Login Credentials!\n");
                    }

                    System.out.println("Enter 0 to go back to the previous menu.");
                    System.out.print("Exit> ");
                    response = sc.nextLine().trim();
                    System.out.println();

                } while (!response.equals("0"));
            } else {
                System.out.println("Invalid email and password!\n");
            }
        } catch (CustomerNotFoundException_Exception ex) {
            System.out.println("Customer not found!");
        } catch (InvalidLoginCredentialException_Exception ex) {
            System.out.println("Invalid Login Credentials!\n");
        }

        System.out.println();
    }

    public void addAppointment() {

        try {
            Scanner sc = new Scanner(System.in);
            List<String> times = Arrays.asList("08:30", "09:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30", "16:30", "17:30", "18:30");
            System.out.println("*** Customer terminal :: Add Appointment ***\n");

            System.out.print("Enter username> ");
            String email = sc.nextLine().trim();
            System.out.print("Enter password> ");
            String password = sc.nextLine().trim();
            System.out.println();

            CustomerEntity currentCustomerEntity = retrieveCustomerByEmail(email, password, email);
            if (currentCustomerEntity.getCustomerId().equals(loggedInCustomer.getCustomerId())) {

                List<BusinessCategoryEntity> businessCategoryEntities = retrieveAllBusinessCategories(email, password);
                for (BusinessCategoryEntity businessCategory : businessCategoryEntities) {
                    System.out.printf("%-3s%-10s", businessCategory.getBusinessCategoryId(), businessCategory.getCategory() + " |");
                }
                System.out.println("\n");
                String response = "";
                String firstAvailableTime = "";

                do {
                    try {
                        System.out.print("Enter Business category> ");
                        Long input = sc.nextLong(); //catch inputmismatch
                        sc.nextLine();
                        System.out.print("Enter City> ");
                        String city = sc.nextLine().trim();

                        System.out.print("Enter Date (YYYY-MM-DD)> ");
                        String currentDate = sc.nextLine().trim();

                        System.out.println();

                        String day = calculateDayOfTheWeek(email, password, currentDate);

                        System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", "Service Provider Id", "| Name", "| First available Time", "| Address", "| Overall rating\n");

                        if (!day.equals("Sunday") && ifDateHasNotPassed(email, password, currentDate)) { //insert invalid add appt

                            BusinessCategoryEntity businessCategory = retrieveBusinessCategoriesById(email, password, input);

                            List<ServiceProviderEntity> serviceProviders = retrieveServiceProviderEntityBySearch(email, password, businessCategory.getCategory(), city);

                            for (ServiceProviderEntity s : serviceProviders) {
                                List<AppointmentEntity> appointmentEntities = retrieveSortedAppointmentsByDate(email, password, currentDate, s.getServiceProviderId());
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

                                System.out.printf("%-19s%-18s%-24s%-23s%-16s\n", s.getServiceProviderId(), "| " + s.getName(), "| " + firstAvailableTime, "| " + s.getBusinessAddress(), "| " + s.getRating());
                            }

                            System.out.println();

                            System.out.println("Enter 0 to go back to the previous menu.");
                            System.out.print("Service provider Id> ");
                            response = sc.nextLine().trim();

                            System.out.println();

                            if (!response.equals("0")) {
                                Long serviceProviderId = Long.parseLong(response);

                                List<AppointmentEntity> appointmentEntities = retrieveSortedAppointmentsByDate(email, password, currentDate, serviceProviderId);
                                List<String> availableTimings = new ArrayList<String>();

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
                                String appointmentTime = response;
                                LocalTime checkTime = convertTime(email, password, appointmentTime);
                                System.out.println();

                                if (!response.equals("0")) {

                                    if (ifAppointmentCanAdd(email, password, appointmentTime, currentDate)) {
                                        boolean hasAnotherAppt = false;
                                        List<AppointmentEntity> apptList = retrieveCustomerEntityByCustomerId(email, password, currentCustomerEntity.getCustomerId()).getAppointmentEntities();
                                        apptList.size();

                                        for (AppointmentEntity a : apptList) {
                                            if (a.getScheduledDate().toString().equals(currentDate)) {

                                                if (a.getScheduledTime().toString().equals(appointmentTime)) {
                                                    System.out.println("You have another appointment scheduled at " + currentDate + " on " + appointmentTime + "!\n");
                                                    hasAnotherAppt = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (hasAnotherAppt == false) {
                                            boolean validTime = true;

                                            if (!timeslots2.contains(appointmentTime)) {
                                                System.out.println("Time slot not available!");
                                                validTime = false;
                                            }

                                            if (validTime == Boolean.TRUE) {

                                                try {
                                                    AppointmentEntity appointmentEntity = new AppointmentEntity();
                                                    String serviceProviderUIN = serviceProviderId.toString();
                                                    String appointmentNumber = serviceProviderUIN + currentDate.substring(5, 7) + currentDate.substring(8, 10);
                                                    appointmentNumber += appointmentTime.toString().substring(0, 2) + appointmentTime.toString().substring(3, 5);

                                                    addAppointment(email, password, appointmentNumber, appointmentTime, currentDate, currentCustomerEntity, retrieveServiceProviderEntityById(email, password, serviceProviderId), retrieveBusinessCategoriesById(email, password, input));

                                                    Long newAppointmentEntityId = doBooking(email, password, currentCustomerEntity.getCustomerId(), serviceProviderId);
                                                    appointmentEntity = retrieveAppointmentByAppointmentId(email, password, newAppointmentEntityId);
                                                    System.out.println("Appointment " + appointmentEntity.getAppointmentNo() + " added successfully!\n");

                                                } catch (CustomerNotFoundException_Exception ex) {
                                                    System.out.println("Customer with customer id " + currentCustomerEntity.getCustomerId() + " not found!\n");
                                                } catch (ServiceProviderNotFoundException_Exception ex) {
                                                    System.out.println("Service with service provider id " + serviceProviderId + " not found!\n");
                                                } catch (ServiceProviderBlockedException_Exception ex) {
                                                    System.out.println("Service with service provider id " + serviceProviderId + " is blocked!\n");
                                                } catch (AppointmentNotFoundException_Exception ex) {
                                                    System.out.println("Appointment cannot be not found!\n");
                                                } catch (AppointmentNumberExistsException_Exception ex) {
                                                    System.out.println("Appointment Number already exists!\n");
                                                } catch (UnknownPersistenceException_Exception | InputDataValidationException_Exception ex) {
                                                    System.out.println(ex.getMessage() + "\n");
                                                }

                                                clearAppointmentCart(email, password);
                                            }

                                            System.out.println("Enter 0 to go back to the previous menu.");
                                            System.out.print("Exit> ");
                                            response = sc.nextLine().trim();
                                        }
                                    }
                                }
                            }

                        } else {
                            if (day.equals("Sunday")) {
                                System.out.println();
                                System.out.println("There are Service Provider available on Sunday!");
                            } else {
                                System.out.println();
                                System.out.println("The date chosen has already passed, please choose another date!");
                            }
                        }

                    } catch (ServiceProviderNotFoundException_Exception ex) {
                        System.out.println("Service Provider cannot be found!\n");
                    } catch (BusinessCategoryNotFoundException_Exception ex) {
                        System.out.println("BusinessCategory cannot be found!\n");
                    } catch (InputInvalidValuesException_Exception ex) {
                        System.out.println("Please input a valid date in YYYY-MM-DD, and a valid time in HH-MM!\n");
                    } catch (InputMismatchException | NumberFormatException ex) {
                        System.out.println("Please input a valid Business Category Id!\n");
                        sc.next();
                    } catch (AppointmentNotFoundException_Exception ex) {
                        System.out.println("Appointment cannot be found!\n");
                    } catch (CustomerNotFoundException_Exception ex) {
                        System.out.println("Customer cannot be found!\n");
                    }
                } while (!response.equals("0"));
            } else {
                System.out.println("Invalid email and password!\n");
            }
        } catch (InvalidLoginCredentialException_Exception ex) {
            System.out.println("Invalid Login Credentials!\n");
        } catch (CustomerNotFoundException_Exception ex) {
            System.out.println("Invalid Login Credentials!\n");
        }

        System.out.println();

    }

    public void viewAppointments() {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username> ");
            String email = sc.nextLine().trim();
            System.out.print("Enter password> ");
            String password = sc.nextLine().trim();
            System.out.println();
            String response = "";
            CustomerEntity currentCustomerEntity = retrieveCustomerByEmail(email, password, email);
            if (currentCustomerEntity.getCustomerId().equals(loggedInCustomer.getCustomerId())) {

                List<AppointmentEntity> appointments = retrieveCustomerEntityByCustomerId(email, password, currentCustomerEntity.getCustomerId()).getAppointmentEntities();
                appointments.size();

                System.out.println("Appointments: ");
                System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.");

                for (AppointmentEntity appointment : appointments) {
                    System.out.printf("%-15s%-13s%-8s%-15s\n", currentCustomerEntity.getFirstName() + " " + currentCustomerEntity.getLastName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
                }

                while (!response.equals("0")) {
                    System.out.println("Enter 0 to go back to the previous menu.");
                    System.out.print(">");
                    response = sc.nextLine().trim();
                }
            } else {
                System.out.println("Invalid email and password!\n");
            }
        } catch (CustomerNotFoundException_Exception ex) {
            System.out.println("Customer not found!");
        } catch (InvalidLoginCredentialException_Exception ex) {
            System.out.println("Invalid Login Credentials!");
        }
        System.out.println();
    }

    public void cancelAppointment() throws InvalidLoginCredentialException_Exception {

        System.out.println("*** Customer terminal :: Cancel Appointment ***\n");

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username> ");
            String email = sc.nextLine().trim();
            System.out.print("Enter password> ");
            String password = sc.nextLine().trim();
            String response = "";
            System.out.println();
            CustomerEntity currentCustomerEntity = retrieveCustomerByEmail(email, password, email);
            if (currentCustomerEntity.getCustomerId().equals(loggedInCustomer.getCustomerId())) {

                List<AppointmentEntity> appointmentEntities = retrieveCustomerEntityByCustomerId(email, password, currentCustomerEntity.getCustomerId()).getAppointmentEntities();
                System.out.println("Appointments: ");
                System.out.printf("%-15s%-13s%-8s%-15s\n", "Name", "| Date", "| Time", "| Appointment No.");

                for (AppointmentEntity appointment : appointmentEntities) {
                    System.out.printf("%-15s%-13s%-8s%-15s\n", currentCustomerEntity.getFirstName() + " " + currentCustomerEntity.getLastName(), "| " + appointment.getScheduledDate(), "| " + appointment.getScheduledTime(), "| " + appointment.getAppointmentNo());
                }

                System.out.println("Enter 0 to go back to the previous menu.");
                System.out.print("Enter Appointment Id to cancel> ");
                response = sc.nextLine().trim();
                System.out.println();
                String appointmentNo = "";

                while (!response.equals("0")) {
                    try {
                        appointmentNo = response;
                        AppointmentEntity appointmentEntity = retrieveAppointmentByAppointmentNumber(email, password, appointmentNo);

                        if (ifAppointmentCanCancel(email, password, appointmentNo)) {
                            System.out.println("Appointment " + appointmentNo + " successfully cancelled!\n");
                        } else {
                            System.out.println("Appointment " + appointmentNo + " cannot be cancelled!\n");
                        }

                    } catch (AppointmentNotFoundException_Exception ex) {
                        System.out.println("Appointment with id: " + appointmentNo + " does not exist!\n");
                    } catch (InputInvalidValuesException_Exception ex) {
                        System.out.println("Please input a valid date in YYYY-MM-DD!\n");
                    }

                    System.out.println("Enter 0 to go back to the previous menu.");
                    System.out.print("Enter Appointment Id to cancel> ");
                    response = sc.nextLine().trim();
                }
            } else {
                System.out.println("Invalid email and password!\n");
            }
        } catch (CustomerNotFoundException_Exception ex) {
            System.out.println("Customer cannot be found!\n");
        } catch (InvalidLoginCredentialException_Exception ex) {
            System.out.println("Invalid Login Credentials\n");;
        }
        System.out.println();
    }

    public void rateServiceProvider() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Customer terminal :: Rate Service Provider ***\n");
        String response = "";
        System.out.print("Enter username> ");
        String email = sc.nextLine().trim();
        System.out.print("Enter password> ");
        String password = sc.nextLine().trim();
        System.out.println();

        do {
            try {
                CustomerEntity currentCustomerEntity = retrieveCustomerByEmail(email, password, email);
                if (currentCustomerEntity.getCustomerId().equals(loggedInCustomer.getCustomerId())) {

                    System.out.print("Enter Service Provider Id> ");
                    String input = sc.nextLine().trim();

                    Long serviceProviderId = Long.parseLong(input);
                    ServiceProviderEntity serviceProvider = retrieveServiceProviderEntityById(email, password, serviceProviderId);
                    System.out.println("You are rating " + serviceProvider.getName() + ".\n");
                    List<AppointmentEntity> apptList = retrieveAppointmentByCustomer(email, password, currentCustomerEntity.getCustomerId(), serviceProvider.getServiceProviderId());

                    Long ratedApptId = ifCanRate(email, password, apptList, serviceProvider.getServiceProviderId());

                    if (apptList.isEmpty()) {
                        System.out.println("You do not have any appointment under " + serviceProvider.getName() + "\n");
                    } else if (ratedApptId.equals(0l)) {
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
                                    updateRating(email, password, rating, serviceProvider.getServiceProviderId());
                                    updateAppointmentEntityRating(email, password, ratedApptId);
                                    System.out.println("Rating successfully submitted!\n");
                                }
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid email and password!\n");
                }
            } catch (ServiceProviderNotFoundException_Exception ex) {
                System.out.println("Service Provider does not exist!\n");
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number between 0.0 to 5.0!\n");
            } catch (ServiceProviderBlockedException_Exception ex) {
                System.out.println("Service Provider is blocked!\n");
            } catch (AppointmentNotFoundException_Exception ex) {
                System.out.println("Appointment not found!\n");
            } catch (InvalidLoginCredentialException_Exception ex) {
                System.out.println("Invalid Login Credentials\n");;
            } catch (CustomerNotFoundException_Exception ex) {
                System.out.println("Customer cannot be found!\n");;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid Service Provider Id!\n");
            }

            System.out.println("Enter 0 to go back to the previous menu.");
            System.out.print(">");
            response = sc.nextLine().trim();
        } while (!response.equals("0"));

        System.out.println();
    }

    private static void deleteBusinessCategory(java.lang.String email, java.lang.String password, java.lang.Long businessCategoryId) throws BusinessCategoryNotFoundException_Exception, InvalidLoginCredentialException_Exception, DeleteBusinessCategoryException_Exception {
        ws.client.BusinessCategoryEntityWebService_Service service = new ws.client.BusinessCategoryEntityWebService_Service();
        ws.client.BusinessCategoryEntityWebService port = service.getBusinessCategoryEntityWebServicePort();
        port.deleteBusinessCategory(email, password, businessCategoryId);
    }

    private static java.util.List<ws.client.BusinessCategoryEntity> retrieveAllBusinessCategories(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BusinessCategoryEntityWebService_Service service = new ws.client.BusinessCategoryEntityWebService_Service();
        ws.client.BusinessCategoryEntityWebService port = service.getBusinessCategoryEntityWebServicePort();
        return port.retrieveAllBusinessCategories(email, password);
    }

    private static BusinessCategoryEntity retrieveBusinessCategoriesById(java.lang.String email, java.lang.String password, java.lang.Long businessCategoryId) throws BusinessCategoryNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.BusinessCategoryEntityWebService_Service service = new ws.client.BusinessCategoryEntityWebService_Service();
        ws.client.BusinessCategoryEntityWebService port = service.getBusinessCategoryEntityWebServicePort();
        return port.retrieveBusinessCategoriesById(email, password, businessCategoryId);
    }

    private static BusinessCategoryEntity retrieveBusinessCategoriesByName(java.lang.String email, java.lang.String password, java.lang.String businessCategoryName) throws InvalidLoginCredentialException_Exception, BusinessCategoryNotFoundException_Exception {
        ws.client.BusinessCategoryEntityWebService_Service service = new ws.client.BusinessCategoryEntityWebService_Service();
        ws.client.BusinessCategoryEntityWebService port = service.getBusinessCategoryEntityWebServicePort();
        return port.retrieveBusinessCategoriesByName(email, password, businessCategoryName);
    }

    private static Boolean emailCheckoutNotificationSync(java.lang.String email, java.lang.String password, ws.client.AppointmentEntity appointmentEntity, java.lang.String fromEmailAddress, java.lang.String toEmailAddress) throws InvalidLoginCredentialException_Exception {
        ws.client.EmailWebService_Service service = new ws.client.EmailWebService_Service();
        ws.client.EmailWebService port = service.getEmailWebServicePort();
        return port.emailCheckoutNotificationSync(email, password, appointmentEntity, fromEmailAddress, toEmailAddress);
    }

    private static Long createNewAppointment(java.lang.String email, java.lang.String password, java.lang.Long customerId, java.lang.Long serviceProviderId, ws.client.AppointmentEntity newAppointmentEntity) throws InputDataValidationException_Exception, InvalidLoginCredentialException_Exception, CustomerNotFoundException_Exception, ServiceProviderBlockedException_Exception, AppointmentNumberExistsException_Exception, UnknownPersistenceException_Exception, ServiceProviderNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.createNewAppointment(email, password, customerId, serviceProviderId, newAppointmentEntity);
    }

    private static void deleteAppointment(java.lang.String email, java.lang.String password, java.lang.String appointmentNumber) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        port.deleteAppointment(email, password, appointmentNumber);
    }

    private static AppointmentEntity retrieveAppointmentByAppointmentId(java.lang.String email, java.lang.String password, java.lang.Long appointmentId) throws AppointmentNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveAppointmentByAppointmentId(email, password, appointmentId);
    }

    private static AppointmentEntity retrieveAppointmentByAppointmentNumber(java.lang.String email, java.lang.String password, java.lang.String appointmentNumber) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveAppointmentByAppointmentNumber(email, password, appointmentNumber);
    }

    private static java.util.List<ws.client.AppointmentEntity> retrieveAppointmentByCustomer(java.lang.String email, java.lang.String password, java.lang.Long customerId, java.lang.Long serviceProviderId) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveAppointmentByCustomer(email, password, customerId, serviceProviderId);
    }

    private static java.util.List<ws.client.AppointmentEntity> retrieveAppointmentsByServiceProviderId(java.lang.String email, java.lang.String password, java.lang.Long serviceProviderId) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveAppointmentsByServiceProviderId(email, password, serviceProviderId);
    }

    private static void updateAppointmentEntity(java.lang.String email, java.lang.String password, ws.client.AppointmentEntity appointmentEntity) throws InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        port.updateAppointmentEntity(email, password, appointmentEntity);
    }

    private static java.util.List<ws.client.ServiceProviderEntity> retrieveAllServiceProviderEntity(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        return port.retrieveAllServiceProviderEntity(email, password);
    }

    private static ServiceProviderEntity retrieveServiceProviderEntityByEmail(java.lang.String email, java.lang.String password, java.lang.String serviceProviderEmail) throws InvalidLoginCredentialException_Exception, ServiceProviderNotFoundException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        return port.retrieveServiceProviderEntityByEmail(email, password, serviceProviderEmail);
    }

    private static ServiceProviderEntity retrieveServiceProviderEntityById(java.lang.String email, java.lang.String password, java.lang.Long serviceProviderId) throws ServiceProviderBlockedException_Exception, ServiceProviderNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        return port.retrieveServiceProviderEntityById(email, password, serviceProviderId);
    }

    private static ServiceProviderEntity retrieveServiceProviderEntityByName(java.lang.String email, java.lang.String password, java.lang.String name) throws InvalidLoginCredentialException_Exception, ServiceProviderNotFoundException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        return port.retrieveServiceProviderEntityByName(email, password, name);
    }

    private static java.util.List<ws.client.ServiceProviderEntity> retrieveServiceProviderEntityBySearch(java.lang.String email, java.lang.String password, java.lang.String businessCategory, java.lang.String city) throws InvalidLoginCredentialException_Exception, ServiceProviderNotFoundException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        return port.retrieveServiceProviderEntityBySearch(email, password, businessCategory, city);
    }

    private static void clearAppointmentCart(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.clearAppointmentCart(email, password);
    }

    private static Long doBooking(java.lang.String email, java.lang.String password, java.lang.Long customerId, java.lang.Long serviceProviderId) throws ServiceProviderNotFoundException_Exception, AppointmentNumberExistsException_Exception, CustomerNotFoundException_Exception, ServiceProviderBlockedException_Exception, UnknownPersistenceException_Exception, InputDataValidationException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.doBooking(email, password, customerId, serviceProviderId);
    }

    private static String getAppointmentNo(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getAppointmentNo(email, password);
    }

    private static BusinessCategoryEntity getBusinessCategoryEntity(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getBusinessCategoryEntity(email, password);
    }

    private static CustomerEntity getCustomerEntity(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getCustomerEntity(email, password);
    }

    private static ServiceProviderEntity getServiceProviderEntity(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getServiceProviderEntity(email, password);
    }

    private static void setAppointmentNo(java.lang.String email, java.lang.String password, java.lang.String appointmentNo) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setAppointmentNo(email, password, appointmentNo);
    }

    private static void setBusinessCategoryEntity(java.lang.String email, java.lang.String password, ws.client.BusinessCategoryEntity businessCategoryEntity) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setBusinessCategoryEntity(email, password, businessCategoryEntity);
    }

    private static void setCustomerEntity(java.lang.String email, java.lang.String password, ws.client.CustomerEntity newCustomerEntity) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setCustomerEntity(email, password, newCustomerEntity);
    }

    private static void setServiceProviderEntity(java.lang.String email, java.lang.String password, ws.client.ServiceProviderEntity serviceProviderEntity) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setServiceProviderEntity(email, password, serviceProviderEntity);
    }

    private static CustomerEntity customerLogin(java.lang.String email, java.lang.String password, java.lang.String loginEmail, java.lang.String loginPassword) throws InvalidLoginCredentialException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        return port.customerLogin(email, password, loginEmail, loginPassword);
    }

    private static void deleteCustomer(java.lang.String email, java.lang.String password, java.lang.Long customerId) throws CustomerDeletionException_Exception, CustomerNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        port.deleteCustomer(email, password, customerId);
    }

    private static java.util.List<ws.client.CustomerEntity> retrieveAllCustomers(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        return port.retrieveAllCustomers(email, password);
    }

    private static CustomerEntity retrieveCustomerByEmail(java.lang.String email, java.lang.String password, java.lang.String emailAddress) throws InvalidLoginCredentialException_Exception, CustomerNotFoundException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        return port.retrieveCustomerByEmail(email, password, emailAddress);
    }

    private static CustomerEntity retrieveCustomerEntityByCustomerId(java.lang.String email, java.lang.String password, java.lang.Long customerId) throws CustomerNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        return port.retrieveCustomerEntityByCustomerId(email, password, customerId);
    }

    private static void updateCustomer(java.lang.String email, java.lang.String password, ws.client.CustomerEntity customerEntity) throws InvalidLoginCredentialException_Exception, UpdateCustomerException_Exception, CustomerNotFoundException_Exception, InputDataValidationException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        port.updateCustomer(email, password, customerEntity);
    }

    private static void updateRating(java.lang.String email, java.lang.String password, java.lang.Double rating, java.lang.Long serviceProviderId) throws InvalidLoginCredentialException_Exception, ServiceProviderNotFoundException_Exception, ServiceProviderBlockedException_Exception {
        ws.client.ServiceProviderWebService_Service service = new ws.client.ServiceProviderWebService_Service();
        ws.client.ServiceProviderWebService port = service.getServiceProviderWebServicePort();
        port.updateRating(email, password, rating, serviceProviderId);
    }

    private static void updateAppointmentEntityRating(java.lang.String email, java.lang.String password, java.lang.Long appointmentId) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        port.updateAppointmentEntityRating(email, password, appointmentId);
    }

    private static java.util.List<ws.client.AppointmentEntity> retrieveSortedAppointmentsByDate(java.lang.String email, java.lang.String password, java.lang.String date, java.lang.Long serviceProviderId) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveSortedAppointmentsByDate(email, password, date, serviceProviderId);
    }

    private static java.util.List<ws.client.AppointmentEntity> retrieveAppointmentsByDate(java.lang.String email, java.lang.String password, java.lang.String date, java.lang.String serviceProviderName) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.retrieveAppointmentsByDate(email, password, date, serviceProviderName);
    }

    private static String findFirstAvailableTime(java.lang.String email, java.lang.String password, java.util.List<ws.client.AppointmentEntity> appointmentList, java.util.List<java.lang.String> timeSlots) throws InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.findFirstAvailableTime(email, password, appointmentList, timeSlots);
    }

    private static java.util.List<java.lang.String> findAvailableTimeSlot(java.lang.String email, java.lang.String password, java.util.List<ws.client.AppointmentEntity> appointmentList, java.util.List<java.lang.String> timeSlots) throws InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.findAvailableTimeSlot(email, password, appointmentList, timeSlots);
    }

    private static void addAppointment(java.lang.String email, java.lang.String password, java.lang.String appointmentNo, java.lang.String scheduledTime, java.lang.String scheduledDate, ws.client.CustomerEntity customerEntity, ws.client.ServiceProviderEntity serviceProviderEntity, ws.client.BusinessCategoryEntity businessCategoryEntity) throws ServiceProviderNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.addAppointment(email, password, appointmentNo, scheduledTime, scheduledDate, customerEntity, serviceProviderEntity, businessCategoryEntity);
    }

    private static String calculateDayOfTheWeek(java.lang.String email, java.lang.String password, java.lang.String date) throws InputInvalidValuesException_Exception, AppointmentNotFoundException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.calculateDayOfTheWeek(email, password, date);
    }

    private static Long ifCanRate(java.lang.String email, java.lang.String password, java.util.List<ws.client.AppointmentEntity> apptList, java.lang.Long serviceProviderId) throws InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.ifCanRate(email, password, apptList, serviceProviderId);
    }

    private static void setScheduledDate(java.lang.String email, java.lang.String password, java.lang.String setScheduledDate) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setScheduledDate(email, password, setScheduledDate);
    }

    private static String getScheduledTime(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getScheduledTime(email, password);
    }

    private static void setScheduledTime(java.lang.String email, java.lang.String password, java.lang.String scheduledTime) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        port.setScheduledTime(email, password, scheduledTime);
    }

    private static String getScheduledDate(java.lang.String email, java.lang.String password) throws InvalidLoginCredentialException_Exception {
        ws.client.BookingWebService_Service service = new ws.client.BookingWebService_Service();
        ws.client.BookingWebService port = service.getBookingWebServicePort();
        return port.getScheduledDate(email, password);
    }

    private static boolean ifDateHasNotPassed(java.lang.String email, java.lang.String password, java.lang.String date) throws InputInvalidValuesException_Exception, InvalidLoginCredentialException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.ifDateHasNotPassed(email, password, date);
    }

    private static LocalTime convertTime(java.lang.String email, java.lang.String password, java.lang.String appointmentTime) throws InputInvalidValuesException_Exception, InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.convertTime(email, password, appointmentTime);
    }

    private static boolean ifAppointmentCanCancel(java.lang.String email, java.lang.String password, java.lang.String appointmentNo) throws InputInvalidValuesException_Exception, InvalidLoginCredentialException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.ifAppointmentCanCancel(email, password, appointmentNo);
    }

    private static boolean ifAppointmentCanAdd(java.lang.String email, java.lang.String password, java.lang.String date, java.lang.String time) throws InvalidLoginCredentialException_Exception, InputInvalidValuesException_Exception, AppointmentNotFoundException_Exception {
        ws.client.AppointmentEntityWebService_Service service = new ws.client.AppointmentEntityWebService_Service();
        ws.client.AppointmentEntityWebService port = service.getAppointmentEntityWebServicePort();
        return port.ifAppointmentCanAdd(email, password, date, time);
    }

    private static Long createNewCustomer(ws.client.CustomerEntity customerEntity) throws CustomerNotUniqueException_Exception, UnknownPersistenceException_Exception, InputDataValidationException_Exception {
        ws.client.CustomerWebService_Service service = new ws.client.CustomerWebService_Service();
        ws.client.CustomerWebService port = service.getCustomerWebServicePort();
        return port.createNewCustomer(customerEntity);
    }


}
