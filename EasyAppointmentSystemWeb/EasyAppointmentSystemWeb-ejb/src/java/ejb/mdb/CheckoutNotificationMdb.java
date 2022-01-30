/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.mdb;

import ejb.session.stateless.AppointmentEntitySessionBeanLocal;
import ejb.session.stateless.EmailSessionBeanLocal;
import entity.AppointmentEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import util.exception.AppointmentNotFoundException;

/**
 *
 * @author valenciateh
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queueCheckoutNotification"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class CheckoutNotificationMdb implements MessageListener {

    @EJB
    private AppointmentEntitySessionBeanLocal appointmentEntitySessionBeanLocal;
    @EJB
    private EmailSessionBeanLocal emailSessionBeanLocal;

    
    public CheckoutNotificationMdb() {
        
    }
    
    @Override
    public void onMessage(Message message) {

        try {
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                String toEmailAddress = mapMessage.getString("toEmailAddress");
                String fromEmailAddress = mapMessage.getString("fromEmailAddress");
                Long appointmentEntityId = (Long) mapMessage.getLong("appointmentEntityId");
                AppointmentEntity appointmentEntity = appointmentEntitySessionBeanLocal.retrieveAppointmentByAppointmentId(appointmentEntityId);

                emailSessionBeanLocal.emailCheckoutNotificationSync(appointmentEntity, fromEmailAddress, toEmailAddress);

                System.err.println("********** CheckoutNotificationMdb.onMessage: " + appointmentEntity.getAppointmentId() + "; " + toEmailAddress + "; " + fromEmailAddress);
            }
        } catch (AppointmentNotFoundException | JMSException ex) {

            System.err.println("CheckoutNotificationMdb.onMessage(): " + ex.getMessage());

        }
    }

    @PostConstruct
    public void postConstruct() {
    }

    @PreDestroy
    public void preDestroy() {
    }

}
