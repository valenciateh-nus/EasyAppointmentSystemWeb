package ejb.session.stateless;

import entity.AppointmentEntity;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import util.email.EmailManager;



@Stateless
@Local(EmailSessionBeanLocal.class)
@Remote(EmailSessionBeanRemote.class)

public class EmailSessionBean implements EmailSessionBeanLocal, EmailSessionBeanRemote 
{
    private final String GMAIL_USERNAME = "vtjw1000@gmail.com";
    private final String GMAIL_PASSWORD = "Valencia100!";
    
    
    @Override
    public Boolean emailCheckoutNotificationSync(AppointmentEntity appointmentEntity, String fromEmailAddress, String toEmailAddress)
    {
        EmailManager emailManager = new EmailManager(GMAIL_USERNAME, GMAIL_PASSWORD);
        Boolean result = emailManager.emailCheckoutNotification(appointmentEntity, fromEmailAddress, toEmailAddress);
        
        return result;
    } 

}