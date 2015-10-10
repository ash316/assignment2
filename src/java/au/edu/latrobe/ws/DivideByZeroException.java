
package au.edu.latrobe.ws;

/**
 * Simple Custom Exception Class to handle Division by zero condition.
 * 
 */
public class DivideByZeroException extends Exception {
    
    public DivideByZeroException() {
        super();
    }
    
    public DivideByZeroException(String message) {
        super(message);
    }
    
    public DivideByZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
