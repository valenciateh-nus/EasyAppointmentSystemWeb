package easyappointmentsystemwebadminclient;

import ejb.session.stateless.AdminEntitySessionBeanRemote;
import ejb.session.stateless.AppointmentEntitySessionBeanRemote;
import ejb.session.stateless.BusinessCategoryEntitySessionBeanRemote;
import ejb.session.stateless.CustomerEntitySessionBeanRemote;
import ejb.session.stateless.ServiceProviderEntitySessionBeanRemote;
import ejb.session.stateless.EmailSessionBeanRemote;
import entity.AdminEntity;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import util.exception.InvalidLoginCredentialException;

public class MainApp {

    private AdminEntitySessionBeanRemote adminEntitySessionBeanRemote;
    private AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote;
    private BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote;
    private CustomerEntitySessionBeanRemote customerEntitySessionBeanRemote;
    private ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote;
    private EmailSessionBeanRemote emailSessionBeanRemote;

    private Queue queueCheckoutNotification;
    private ConnectionFactory queueCheckoutNotificationFactory;

    private AdminEntity currentAdminEntity;

    private SystemAdministrationModule systemAdministrationModule;

    public MainApp() {
    }

    public MainApp(AdminEntitySessionBeanRemote adminEntitySessionBeanRemote, AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote, BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote, CustomerEntitySessionBeanRemote customerEntitySessionBeanRemote, ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote, EmailSessionBeanRemote emailSessionBeanRemote, Queue queueCheckoutNotification, ConnectionFactory queueCheckoutNotificationFactory) {
        this.adminEntitySessionBeanRemote = adminEntitySessionBeanRemote;
        this.appointmentEntitySessionBeanRemote = appointmentEntitySessionBeanRemote;
        this.businessCategoryEntitySessionBeanRemote = businessCategoryEntitySessionBeanRemote;
        this.customerEntitySessionBeanRemote = customerEntitySessionBeanRemote;
        this.serviceProviderEntitySessionBeanRemote = serviceProviderEntitySessionBeanRemote;
        this.emailSessionBeanRemote = emailSessionBeanRemote;

        this.queueCheckoutNotification = queueCheckoutNotification;
        this.queueCheckoutNotificationFactory = queueCheckoutNotificationFactory;
    }

    public void runApp() {
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Welcome to Admin terminal ***\n");
            System.out.println("1: Login");
            System.out.println("2: Exit\n");
            response = 0;

            while (response < 1 || response > 2) {
                    System.out.print("> ");

                    try {
                        response = scanner.nextInt();

                        if (response == 1) {
                            try {
                                doLogin();
                                System.out.println("Login successful!\n");
                                systemAdministrationModule = new SystemAdministrationModule(appointmentEntitySessionBeanRemote, businessCategoryEntitySessionBeanRemote, customerEntitySessionBeanRemote, serviceProviderEntitySessionBeanRemote, currentAdminEntity, emailSessionBeanRemote, queueCheckoutNotification, queueCheckoutNotificationFactory);
                                menuMain();
                            } catch (InvalidLoginCredentialException ex) {
                                System.out.println("Invalid login credential: " + ex.getMessage() + "\n");
                            }
                        } else if (response == 2) {
                            break;
                        } else {
                            System.out.println("Invalid option, please try again!\n");
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("Please enter a valid number!");
                        scanner.next();
                    }
            }

            if (response == 2) {
                break;
            }

        }
    }

    private void doLogin() throws InvalidLoginCredentialException {
        Scanner scanner = new Scanner(System.in);
        String email = "";
        String password = "";

        System.out.println("*** Admin terminal :: Login ***\n");
        System.out.print("Enter Email Address> ");
        email = scanner.nextLine().trim();
        System.out.print("Enter Password> ");
        password = scanner.nextLine().trim();

        if (email.length() > 0 && password.length() > 0) {
            currentAdminEntity = adminEntitySessionBeanRemote.adminLogin(email, password);
        } else {
            throw new InvalidLoginCredentialException("Missing login credential!");
        }
    }

    private void menuMain() {

        Scanner scanner = new Scanner(System.in);
        Integer response = 0;

        while (true) {
            System.out.println("*** Admin terminal :: Main ***\n");
            System.out.println("You are login as " + currentAdminEntity.getName() + "\n");
            System.out.println("1: View Appointments for customers");
            System.out.println("2: View Appointments for service providers");
            System.out.println("3: View service providers");
            System.out.println("4: Approve service providers");
            System.out.println("5: Block service provider");
            System.out.println("6: Add Business category");
            System.out.println("7: Remove Business category");
            System.out.println("8: Send reminder email");
            System.out.println("9: Logout\n");
            response = 0;

            try {
                while (response < 1 || response > 9) {
                    System.out.print("> ");

                    response = scanner.nextInt();

                    if (response == 1) {
                        systemAdministrationModule.viewCustomerAppointments();
                    } else if (response == 2) {
                        systemAdministrationModule.viewServiceProviderAppointments();
                    } else if (response == 3) {
                        systemAdministrationModule.viewServiceProviders();
                    } else if (response == 4) {
                        systemAdministrationModule.approveServiceProviders();
                    } else if (response == 5) {
                        systemAdministrationModule.blockServiceProviders();
                    } else if (response == 6) {
                        systemAdministrationModule.addBusinessCategory();
                    } else if (response == 7) {
                        systemAdministrationModule.removeBusinessCategory();
                    } else if (response == 8) {
                        systemAdministrationModule.sendReminderEmail();
                    } else if (response == 9) {
                        break;
                    } else {
                        System.out.println("Invalid option, please try again!\n");
                    }
                }

                if (response == 9) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid values!");
                scanner.next();
            }
        }
    }

}
