package util.exception;


public class CustomerEmailExistsException extends Exception {

    public CustomerEmailExistsException() {
    }

    public CustomerEmailExistsException(String string) {
        super(string);
    }
    
}
