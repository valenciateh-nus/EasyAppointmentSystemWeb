/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerwebserviceclient;

import ws.client.AppointmentNotFoundException_Exception;
import ws.client.CustomerDeletionException_Exception;
import ws.client.CustomerNotUniqueException_Exception;
import ws.client.CustomerEntity;
import ws.client.CustomerNotFoundException_Exception;
import ws.client.InputDataValidationException_Exception;
import ws.client.InputInvalidValuesException_Exception;
import ws.client.InvalidLoginCredentialException_Exception;
import ws.client.LocalDate;
import ws.client.LocalTime;
import ws.client.ServiceProviderBlockedException_Exception;
import ws.client.ServiceProviderNotFoundException_Exception;
import ws.client.UnknownPersistenceException_Exception;

/**
 *
 * @author adele
 */
public class CustomerWebServiceClient {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.runApp();
    }  

    

    
    
}
