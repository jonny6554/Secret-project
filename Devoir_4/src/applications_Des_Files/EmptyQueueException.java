/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
    }

    public EmptyQueueException( String message ) {
        super( message );
    }
}
