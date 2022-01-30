package ejb.session.stateless;

import entity.BusinessCategoryEntity;
import java.util.List;
import util.exception.BusinessCategoryExistException;
import util.exception.BusinessCategoryNotFoundException;
import util.exception.DeleteBusinessCategoryException;
import util.exception.InputDataValidationException;
import util.exception.UnknownPersistenceException;


public interface BusinessCategoryEntitySessionBeanRemote {
    
    public List<BusinessCategoryEntity> retrieveAllBusinessCategories();

    //public BusinessCategoryEntity createNewBusinessCategoryEntity(BusinessCategoryEntity newBusinessCategoryEntity) throws CreateNewBusinessCategoryException;

    public String createNewBusinessCategoryEntity(BusinessCategoryEntity newBusinessCategoryEntity) throws BusinessCategoryExistException, UnknownPersistenceException, InputDataValidationException;
    
    public void deleteBusinessCategory(Long businessCategoryId) throws DeleteBusinessCategoryException, BusinessCategoryNotFoundException;

    public BusinessCategoryEntity retrieveBusinessCategoriesByName(String name) throws BusinessCategoryNotFoundException;
    
    public BusinessCategoryEntity retrieveBusinessCategoriesById(Long businessCategoryId) throws BusinessCategoryNotFoundException;

}
