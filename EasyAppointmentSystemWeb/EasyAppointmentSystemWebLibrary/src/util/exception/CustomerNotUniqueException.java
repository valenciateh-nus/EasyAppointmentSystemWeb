package util.exception;



public class CustomerNotUniqueException extends Exception
{
    public CustomerNotUniqueException()
    {
    }
    
    
    
    public CustomerNotUniqueException(String msg)
    {
        super(msg);
    }
}