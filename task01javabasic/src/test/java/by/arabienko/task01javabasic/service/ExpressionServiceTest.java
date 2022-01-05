package by.arabienko.task01javabasic.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ExpressionServiceTest {
    ExpressionService expressionService = new ExpressionService();

    @DataProvider(name = "input_x_abcd")
    public Object[][] createDataInput() {
        return new Object[][]{
                {new double[]{0, 0, 0, 0, 0}, 0},
                {new double[]{-1, 1, 0, 0, 0}, -1},
                {new double[]{1, 1, 0, 0, -1}, 0},
                {new double[]{1, 0, 0, 0, 1}, 1},
                {new double[]{1, 0, 0, 5, -5}, 0},
                {new double[]{-1, 0, 0, -5, 5}, 10}
        };
    }

    @Test(description = "Positive scenario cubic expression",
            dataProvider = "input_x_abcd")
    public void testCubicExpression(double[] arg, double expected) {
        double actual = expressionService.cubicExpression(arg[0], arg[1], arg[2], arg[3], arg[4]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "input_to_compare")
    public Object[][] createDataCreate() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{-1, 1}, 1},
                {new double[]{1, 1}, 0},
                {new double[]{1, 0}, 0},
                {new double[]{1, -1}, 0},
                {new double[]{-1, 0}, 1}
        };
    }

    @Test(description = "Positive scenario compare two number",
            dataProvider = "input_to_compare")
    public void testCompareNumber(double[] arg, double expected) {
        expressionService.compareNumber(arg[0], arg[1]);
        assertTrue(true);
    }

    @DataProvider(name = "input_arg")
    public Object[][] createDataForFunction() {
        return new Object[][]{
                {new double[]{0}, 9},
                {new double[]{1}, 8},
                {new double[]{14}, -0.2},
                {new double[]{30}, -0.0967741935483871},
        };
    }

    @Test(description = "Positive scenario function",
            dataProvider = "input_arg")
    public void tesFunctionExecute(double[] arg, double expected) throws Exception {
        double actual = expressionService.functionExecute(arg[0]);
        assertEquals(actual, expected);
    }

    @Test(description = "Negative scenario function",
            expectedExceptions = Exception.class)
    public void tesFunctionExecuteNegative() throws Exception {
        double actual = expressionService.functionExecute(-1);
    }

    @DataProvider(name = "Max_Min_compare")
    public Object[][] createDataMaxMin() {
        return new Object[][]{
                {new double[]{-1, 1, 0}, 0},
                {new double[]{1, 0, -1}, 0},
                {new double[]{-10, -1, 10}, 0},
                {new double[]{5, -5, 10}, 5}
        };
    }

    @Test(description = "Positive scenario Max and Min sum",
            dataProvider = "Max_Min_compare")
    public void testMaxMinCompareNumber(double[] arg, double expected) throws Exception {
        double actual = expressionService.maxMinCompareNumber(arg[0], arg[1], arg[2]);
    }

    @DataProvider(name = "Max_Min_compare_Exception")
    public Object[][] createDataMaxMinException() {
        return new Object[][]{
                {new double[]{0, 0, 0}, 0},
                {new double[]{1, 1, 5}, 6},
                {new double[]{1, 1, 1}, 0},
                {new double[]{-1, -1, -1}, 5}
        };
    }

    @Test(description = "negative scenario Max and Min sum",
            dataProvider = "Max_Min_compare_Exception", expectedExceptions = Exception.class)
    public void testMaxMinCompareNumberNegative(double[] arg, double expected) throws Exception {
        double actual = expressionService.maxMinCompareNumber(arg[0], arg[1], arg[2]);
        assertEquals(actual, expected);
    }
}