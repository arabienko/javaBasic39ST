package by.arabienko.service.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Validation class
 */
public class Validation {

    private static final Logger LOGGER = LogManager.getLogger(Validation.class);

    /**
     * @param data massive
     * @return boolean: true is if length equals six.
     */
    public boolean lengthSix(String[] data) {
        if (data.length==6) {
            return true;
        }
        LOGGER.info("The value does not match the input. " +
                "Length is more than six.");
        return false;
    }

    /**
     * @param str
     * @return true is if @param parse to double
     */
    public boolean isNumber(String... str) {
        for (String str1 : str) {
            try {
                Double.parseDouble(str1);
            } catch (NumberFormatException e) {
                LOGGER.info("The value does not match the input." + e);
                return false;
            }
        }
        return true;
    }

    /**
     * @param number
     * @return true is if numbers is double.
     */
    public boolean dataAboveZero(double... number) {
        for (double number1 : number) {
            if (number1 <= 0) {
                LOGGER.info("The value does not match the input. " +
                        "Number is less or equals zero - " + number1);
                return false;
            }
        }
        return true;
    }
}
