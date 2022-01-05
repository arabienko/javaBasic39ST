package by.arabienko.task01javabasic.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticServiceTest {
    ArithmeticService arithmeticService = new ArithmeticService();
static final double DELTA = 0.00001;
    @DataProvider(name = "arithmetic_sum")
    public Object[][] dateForArithmeticSum() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, 1}, 0},
                {new double[]{1, 1}, 2},
                {new double[]{1, -1}, 0},
                {new double[]{0, 1}, 1}
        };
    }

    @Test(description = "method sum", dataProvider = "arithmetic_sum")
    @Parameters({"testng", "expectedDegree"})
    public void testSum(double[] arg, double expected) {
        double actual = arithmeticService.sum(arg[0], arg[1]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "arithmetic_multiply")
    public Object[][] dateForArithmeticMultiply() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{0, 1}, 0},
                {new double[]{1, 1}, 1},
                {new double[]{1, 0}, 0},
                {new double[]{0, 0}, 0},
                {new double[]{-1, -1}, 1}
        };
    }

    @Test(description = "method multiply", dataProvider = "arithmetic_multiply")
    @Parameters({"testng", "expectedDegree"})
    public void testMultiply(double[] arg, double expected) {
        double actual = arithmeticService.multiply(arg[0], arg[1]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "arithmetic_Exponentiation")
    public Object[][] dateForArithmeticExponentiation() {
        return new Object[][]{
                {new double[]{0, 0}, 1},
                {new double[]{0, 1}, 0},
                {new double[]{1, 1}, 1},
                {new double[]{1, 0}, 1},
                {new double[]{0, 0}, 1},
                {new double[]{-1, -1}, -1}
        };
    }

    @Test(description = "method Exponentiation", dataProvider = "arithmetic_Exponentiation")
    @Parameters({"testng", "expectedDegree"})
    public void testExponentiation(double[] arg, double expected) {
        double actual = arithmeticService.exponentiation(arg[0], arg[1]);
        assertEquals(actual, expected, DELTA);
    }
}