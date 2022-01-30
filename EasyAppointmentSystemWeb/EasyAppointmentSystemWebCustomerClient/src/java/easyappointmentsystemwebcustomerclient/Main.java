package easyappointmentsystemwebcustomerclient;

import ejb.session.stateful.BookingSessionBeanRemote;
import ejb.session.stateless.AdminEntitySessionBeanRemote;
import ejb.session.stateless.AppointmentEntitySessionBeanRemote;
import ejb.session.stateless.BusinessCategoryEntitySessionBeanRemote;
import ejb.session.stateless.CustomerEntitySessionBeanRemote;
import ejb.session.stateless.EmailSessionBeanRemote;
import ejb.session.stateless.ServiceProviderEntitySessionBeanRemote;
import java.text.ParseException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import util.exception.AppointmentNumberExistsException;
import util.exception.InputDataValidationException;
import util.exception.UnknownPersistenceException;


public class Main {

    @EJB
    private static BookingSessionBeanRemote bookingSessionBean;

    @EJB
    private static ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote;

    @EJB
    private static EmailSessionBeanRemote emailSessionBeanRemote;

    @EJB
    private static CustomerEntitySessionBeanRemote customerEntitySessionBeanRemote;

    @EJB
    private static BusinessCategoryEntitySessionBeanRemote businessCategoryEntitySessionBeanRemote;

    @EJB
    private static AppointmentEntitySessionBeanRemote appointmentEntitySessionBeanRemote;

    @EJB
    private static AdminEntitySessionBeanRemote adminEntitySessionBeanRemote;
    
    
    
    @Resource(mappedName = "jms/queueCheckoutNotification")
    private static Queue queueCheckoutNotification;
    @Resource(mappedName = "jms/queueCheckoutNotificationFactory")
    private static ConnectionFactory queueCheckoutNotificationFactory;
    
    public static void main(String[] args) throws ParseException, UnknownPersistenceException, InputDataValidationException, AppointmentNumberExistsException 
    {
        MainApp mainApp = new MainApp(adminEntitySessionBeanRemote, appointmentEntitySessionBeanRemote, businessCategoryEntitySessionBeanRemote, customerEntitySessionBeanRemote, serviceProviderEntitySessionBeanRemote, bookingSessionBean, emailSessionBeanRemote, queueCheckoutNotification, queueCheckoutNotificationFactory);
        mainApp.runApp();
    }
    
}
