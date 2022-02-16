package by.arabienko.service.interpreter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayDeque;

import static org.testng.Assert.*;

public class CreateReversePolishNotationTest {
    CreateReversePolishNotation polishNotation =
            new CreateReversePolishNotation();

    @DataProvider(name = "create_polish_notation")
    public Object[][] dateForArithmeticSum() {
        String str = "(6>>6)&(5^5)";
        String str2 = "6>>6&5^5";
        ArrayDeque<String> reverseNotation =
                new ArrayDeque<>();
        ArrayDeque<String> reverseNotation2 =
                new ArrayDeque<>();
        reverseNotation.add("6");
        reverseNotation.add("6");
        reverseNotation.add(">>");
        reverseNotation.add("5");
        reverseNotation.add("5");
        reverseNotation.add("^");
        reverseNotation.add("&");
        reverseNotation2.add("6");
        reverseNotation2.add("6");
        reverseNotation2.add("5");
        reverseNotation2.add("5");
        reverseNotation2.add("^");
        reverseNotation2.add("&");
        reverseNotation2.add(">>");
      return new Object[][]{
                new Object[]{str, reverseNotation},
                new Object[]{str2, reverseNotation2},
        };
    }
    @Test(description = "create_polish_notation",
            dataProvider = "create_polish_notation")
    public void testCreationReverse(String str, ArrayDeque<String> expected) {
        ArrayDeque<String> actual =
                polishNotation.creationReverse(str);
        assertEquals(actual, expected);
    }
}