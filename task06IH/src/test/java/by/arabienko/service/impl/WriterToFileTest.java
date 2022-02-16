package by.arabienko.service.impl;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class WriterToFileTest {
    WriterToFile writer = new WriterToFile();

    @DataProvider(name = "write_file")
    public Object[][] dateForArithmeticSum() {
        String d = System.lineSeparator();
        String str = "One two three four. Red, green, black." +d+
                "One two three four five. Red, green, black ((5>>5)^(6<<6))&2 go." +d+
                "Three cats. Red - green. By.";
        return new Object[][]{
                new Object[]{str},
        };
    }

    @Test(description = "write_file",
            dataProvider = "write_file")
    public void testWriteToFile(String actual) throws InterruptedException {
        writer.writeToFile(actual);
        ReaderFromFile reader = new ReaderFromFile();
        String expected = reader.readFromFile("output.txt");
        assertEquals(actual, expected);
    }
}