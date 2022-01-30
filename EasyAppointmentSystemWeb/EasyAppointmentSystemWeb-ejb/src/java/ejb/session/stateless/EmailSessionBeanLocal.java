package ejb.session.stateless;

import entity.AppointmentEntity;

public interface EmailSessionBeanLocal {
    
    public Boolean emailCheckoutNotificationSync(AppointmentEntity appointmentEntity, String fromEmailAddress, String toEmailAddress);

}
