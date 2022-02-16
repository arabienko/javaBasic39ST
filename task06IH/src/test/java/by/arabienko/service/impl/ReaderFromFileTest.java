package by.arabienko.service.impl;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ReaderFromFileTest {
ReaderFromFile reader = new ReaderFromFile();
    @DataProvider(name = "read_file")
    public Object[][] dateForArithmeticSum() {
        String d = System.lineSeparator();
        String str = "One two three four. Red, green, black." +d+
                "One two three four five. Red, green, black ((5>>5)^(6<<6))&2 go." +d+
                "Three cats. Red - green. By.";
        return new Object[][]{
                new Object[]{"text_test", str},
                new Object[]{"", str},

        };
    }

    @Test(description = "read_file",
            dataProvider = "read_file")
    public void testReadFromFile(String path, String expected) {
        String actual = reader.readFromFile(path);
        assertEquals(actual, expected);
    }
}