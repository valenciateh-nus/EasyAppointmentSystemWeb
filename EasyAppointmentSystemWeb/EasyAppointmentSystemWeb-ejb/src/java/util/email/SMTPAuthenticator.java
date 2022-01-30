/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.email;

import javax.mail.PasswordAuthentication;


public class SMTPAuthenticator extends javax.mail.Authenticator
{
    private String smtpAuthUser;
    private String smtpAuthPassword;
    
    
        
    public SMTPAuthenticator() 
    {
    }

    
    
    public SMTPAuthenticator(String smtpAuthUser, String smtpAuthPassword)
    {
        this.smtpAuthUser = smtpAuthUser;
        this.smtpAuthPassword = smtpAuthPassword;
    }
    
    
    
    @Override
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(smtpAuthUser, smtpAuthPassword);
    }
}
