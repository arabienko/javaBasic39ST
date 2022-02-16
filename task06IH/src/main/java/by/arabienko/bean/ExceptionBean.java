package by.arabienko.bean;

public class ExceptionBean extends Exception{

    public ExceptionBean() {
    }
    public ExceptionBean(String message) {
        super(message);
    }
    public ExceptionBean(String message, Throwable cause) {
        super(message, cause);
    }
    public ExceptionBean(Throwable cause) {
        super(cause);
    }
}
