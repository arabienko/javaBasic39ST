package by.arabienko.service.interpreter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayDeque;

import static org.testng.Assert.*;

public class StartingCalculationProcessTest {
    @DataProvider(name = "create_polish_notation")
    public Object[][] dateForArithmeticSum() {
        ArrayDeque<String> reverseNotation =
                new ArrayDeque<>();
        reverseNotation.add("6");
        reverseNotation.add("6");
        reverseNotation.add(">>");
        reverseNotation.add("5");
        reverseNotation.add("5");
        reverseNotation.add("^");
        reverseNotation.add("&");
        ArrayDeque<String> reverseNotation2 =
                new ArrayDeque<>();
        reverseNotation2.add("6");
        reverseNotation2.add("6");
        reverseNotation2.add("5");
        reverseNotation2.add("5");
        reverseNotation2.add("^");
        reverseNotation2.add("&");
        reverseNotation2.add(">>");
        ArrayDeque<String> reverseNotation3 =
                new ArrayDeque<>();
        reverseNotation3.add("5");
        reverseNotation3.add("~");
        ArrayDeque<String> reverseNotation4 =
                new ArrayDeque<>();
        reverseNotation4.add("2");
        reverseNotation4.add("6");
        reverseNotation4.add(">>");
        reverseNotation4.add("2");
        reverseNotation4.add("6");
        reverseNotation4.add("<<");
        reverseNotation4.add("2");
        reverseNotation4.add("6");
        reverseNotation4.add(">>");
        reverseNotation4.add("^");
        reverseNotation4.add("&");
       return new Object[][]{
                new Object[]{reverseNotation, 0},
                new Object[]{reverseNotation2, 0},
                new Object[]{reverseNotation3, -6},
               new Object[]{reverseNotation4, 1},

       };
    }
    @Test(description = "create_polish_notation",
            dataProvider = "create_polish_notation")
    public void testCalculate( ArrayDeque<String> str, Integer expected) {
        StartingCalculationProcess calculationProcess =
                new StartingCalculationProcess(str);
        Number actual =
                calculationProcess.calculate();
        assertEquals(actual, expected);
    }
}