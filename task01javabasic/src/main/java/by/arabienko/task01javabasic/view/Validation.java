package by.arabienko.task01javabasic.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Valid input args.
 */
public class Validation {

    private static final Logger LOGGER = LogManager.getLogger(Validation.class);


    /**
     * @param arg value to check.
     * @throws Exception throws an exception if the value is not valid.
     */
    public void validNoZero(final double arg) throws Exception {
        if (arg == 0) {
            LOGGER.error("Arg equals zero");
            throw new Exception("incorrect input");
        }
    }

    /**
     * @param x value to check.
     * @throws Exception throws an exception if the value is not valid.
     */
    public void validAboveZero(final double x) throws Exception {
        if (x <= 0) {
            LOGGER.error("Arg less or equals then zero");
            throw new Exception("Numbers are less or equals ZERO");
        }
    }
}
