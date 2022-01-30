package util.email;

import entity.AppointmentEntity;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailManager 
{
    private final String emailServerName = "smtp.gmail.com";     
    private final String mailer = "JavaMailer";
    private String smtpAuthUser;
    private String smtpAuthPassword;
    
    
    
    public EmailManager()
    {
    }

    
    
    public EmailManager(String smtpAuthUser, String smtpAuthPassword)
    {
        this.smtpAuthUser = smtpAuthUser; // user email
        this.smtpAuthPassword = smtpAuthPassword; // user password
    }
    
    
    
    public Boolean emailCheckoutNotification(AppointmentEntity appointmentEntity, String fromEmailAddress, String toEmailAddress)
    {
        String emailBody = "";
            
        emailBody += "Dear " + appointmentEntity.getCustomerEntity().getFullName() + ",\n\n";
        emailBody += "This is a reminder email for your appointment with Appointment Number: " + appointmentEntity.getAppointmentNo() + ".\n";

        emailBody += "Here are the details of your appointment:\n\n";
        emailBody += "Appointment Date: " + appointmentEntity.getScheduledDate() + "\n";
        emailBody += "Appointment Time: " + appointmentEntity.getScheduledTime() + "\n";
        emailBody += "Service Provider Name: " + appointmentEntity.getServiceProviderEntity().getName() + "\n";
        emailBody += "Business Category: " + appointmentEntity.getBusinessCategoryEntity().getCategory() + "\n";
        emailBody += "City: " + appointmentEntity.getServiceProviderEntity().getCity() + "\n";
        emailBody += "Business Address: " + appointmentEntity.getServiceProviderEntity().getBusinessAddress() + "\n\n";
        
        emailBody += "If you are unable to make it for the appointment, you are advised to cancel the appointment and make a new one. The new appointment must be made 2 hours in advance prior to the actual appointment. Thank you.\n\n";
        emailBody += "Regards, \n";
        emailBody += "EasyAppointment Administrators";
        
        try 
        {
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", emailServerName);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.ssl.trust", emailServerName);          
            javax.mail.Authenticator auth = new SMTPAuthenticator(smtpAuthUser, smtpAuthPassword);
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);            
            Message msg = new MimeMessage(session);
                                    
            if (msg != null)
            {
                msg.setFrom(InternetAddress.parse(fromEmailAddress, false)[0]);
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress, false));
                msg.setSubject("Reminder Email for your appointment!");
                msg.setText(emailBody);
                msg.setHeader("X-Mailer", mailer);
                
                Date timeStamp = new Date();
                msg.setSentDate(timeStamp);
                
                Transport.send(msg);
                
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            
            return false;
        }
    }
}
