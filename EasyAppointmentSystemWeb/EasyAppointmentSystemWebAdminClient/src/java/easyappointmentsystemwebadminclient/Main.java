package easyappointmentsystemwebadminclient;

import javax.ejb.EJB;
import ejb.session.stateless.AdminEntitySessionBeanRemote;
import ejb.session.stateless.AppointmentEntitySessionBeanRemote;
import ejb.session.stateless.BusinessCategoryEntitySessionBeanRemote;
import ejb.session.stateless.CustomerEntitySessionBeanRemote;
import ejb.session.stateless.EmailSessionBeanRemote;
import ejb.session.stateless.ServiceProviderEntitySessionBeanRemote;
import javax.jms.Queue;
import javax.jms.ConnectionFactory;
import javax.annotation.Resource;


public class Main 
{

    @EJB
    private static EmailSessionBeanRemote emailSessionBeanRemote;

    @EJB
    private static ServiceProviderEntitySessionBeanRemote serviceProviderEntitySessionBeanRemote;

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

    
    public static void main(String[] args) 
    {
        MainApp mainApp = new MainApp(adminEntitySessionBeanRemote, appointmentEntitySessionBeanRemote, businessCategoryEntitySessionBeanRemote, customerEntitySessionBeanRemote, serviceProviderEntitySessionBeanRemote, emailSessionBeanRemote, queueCheckoutNotification, queueCheckoutNotificationFactory);
        mainApp.runApp();
    }
}
