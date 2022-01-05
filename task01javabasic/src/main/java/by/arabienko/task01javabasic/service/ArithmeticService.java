package by.arabienko.task01javabasic.service;

/**
 * calculation of arithmetic expressions.
 */
public class ArithmeticService {

    public double sum(final double... x) {
        double s = 0;
        for (double v : x) {
            s = s + v;
        }
        return s;
    }

    public double multiply(final double... x) {
        double m = 1;
        for (double v : x) {
            m = m * v;
        }
        return m;
    }

    public double divide(final double x, final double y) {
        return x / y;
    }

    public double sub(final double x, final double y) {

        return x - y;
    }

    public double average(final double x, final double y) {

        return (x + y) / 2;
    }

    public int exponentiation(final double x, final double y) {

        return (int) Math.pow(x, y);
    }


}
