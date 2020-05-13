package learnTesting;

public class CustomException extends Exception {
    CustomException( String message, Throwable cause ) {
        super( message, cause );
    }

    CustomException( String message ) {
        super( message );
    }

}
