package ejb.session.stateless;

import entity.AdminEntity;
import java.util.List;
import util.exception.AdminNotFoundException;
import util.exception.AdminUsernameExistException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;
import util.exception.UpdateAdminException;

public interface AdminEntitySessionBeanRemote {

    public List<AdminEntity> retrieveAllAdmins();

    public AdminEntity adminLogin(String email, String password) throws InvalidLoginCredentialException;
    
    public AdminEntity retrieveAdminByEmail(String email) throws AdminNotFoundException;
    
    public AdminEntity retrieveAdminEntityById(Long adminId) throws AdminNotFoundException;

    public void updateAdminEntity(AdminEntity adminEntity) throws InputDataValidationException, UpdateAdminException, AdminNotFoundException;

    public void deleteAdmin(Long adminId) throws AdminNotFoundException;
    
    public AdminEntity retrieveAdminEntityByName(String name) throws AdminNotFoundException;
    
    public Long createNewAdmin(AdminEntity newAdminEntity) throws AdminUsernameExistException, UnknownPersistenceException, InputDataValidationException;
    
}
