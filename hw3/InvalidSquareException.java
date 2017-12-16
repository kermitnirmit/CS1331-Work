/**
 * The exception for an invalid square
 *
 * @author nshah372
 * @version 1.0
 *
 * This should be a checked exception because the user can input/create a
 * square with any value. The compiler should check if it is a real square,
 * because otherwise my program would not be able to use that square to find
 * the possible moves.
 */

public class InvalidSquareException extends Exception {
    /**
     * The exception for an invalid square
     * @param  message       made in the other class, what gets printed.
     */
    public InvalidSquareException(String message) {
        super(message);
    }
}
