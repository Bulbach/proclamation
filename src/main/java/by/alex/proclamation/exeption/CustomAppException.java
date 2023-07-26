package by.alex.proclamation.exeption;

public class CustomAppException extends RuntimeException {

    public CustomAppException(Throwable cause ) {
        super(cause);
    }
    public CustomAppException(String str) {
        super(new RuntimeException());
    }
}
