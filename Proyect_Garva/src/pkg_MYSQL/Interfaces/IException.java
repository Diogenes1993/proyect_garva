package pkg_MYSQL.Interfaces;

public class IException extends Exception{
   
    public IException(String message) {
        super(message);
    }

    public IException(String message, Throwable cause) {
        super(message, cause);
    }

    public IException(Throwable cause) {
        super(cause);
    }
}
