package proC;

/**
 * Created by jamesMAC on 25/05/2016.
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String message) {
        super("'" + message + "' is not a valid command.");
    }
}
