package proC;

import java.lang.*;

/**
 * Created by jamesMAC on 21/05/2016.
 */

public class InvalidNumberOfArgumentsException extends Exception {

    public InvalidNumberOfArgumentsException() {
        super(">Incorrect number of arguments supplied to command.");
    }

}
