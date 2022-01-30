package ejb.session.stateless;

import entity.AppointmentEntity;

public interface EmailSessionBeanRemote 
{

    public Boolean emailCheckoutNotificationSync(AppointmentEntity appointmentEntity, String fromEmailAddress, String toEmailAddress);
  
}
