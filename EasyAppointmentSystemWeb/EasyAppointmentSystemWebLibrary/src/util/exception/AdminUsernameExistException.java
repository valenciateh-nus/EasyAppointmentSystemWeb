package util.exception;


public class AdminUsernameExistException extends Exception {
    
    public AdminUsernameExistException() {
    }

    public AdminUsernameExistException(String string) {
        super(string);
    }
}
