package by.arabienko.task01javabasic.service;

import by.arabienko.task01javabasic.entity.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CyclesServiceTest {
    CyclesService cyclesService = new CyclesService();

    @DataProvider(name = "SumFractions")
    public Object[][] createSumFractions() {
        return new Object[][]{
                {new double[]{1}, 1},
                {new double[]{2}, 1.5},
        };
    }

    @Test(description = "Positive scenario SumFractions",
            dataProvider = "SumFractions")
    public void testSumFractions(double[] arg, double expected) throws Exception {
        double actual = cyclesService.sumFractions(arg[0]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "testAllNumbers")
    public Object[][] createDataNumbers() {
        return new Object[][]{
                {new double[]{1, 2, 3, 4, 5}, 5},
                {new double[]{1, 2, 3, 4, 5, 6}, 6},
                {new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15}, 15},
                {new double[]{1}, 1},
                {new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22, 24}, 24}
        };
    }

    @Test(description = "test that finds numbers up to " +
            "a given one that are divisible by their own numbers",
            dataProvider = "testAllNumbers")
    public void testAllNumbers(double[] arg, int a) {
        Data expected = new Data();
        for (double v : arg) {
            expected.push(v);
        }
        Data actual = cyclesService.allNumbers(a);
        int count = 0;
        for (int i = 0; i < actual.getLength(actual); i++) {
            if (expected.getData(i)==actual.getData(i)) {
                count++;
            }
        }
        assertEquals(expected.getLength(expected), count);
    }
}