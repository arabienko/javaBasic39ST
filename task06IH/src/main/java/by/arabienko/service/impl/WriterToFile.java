package by.arabienko.service.impl;

import by.arabienko.service.ExceptionService;
import by.arabienko.service.IWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterToFile implements IWriter {
    private static final Logger LOGGER =
            LogManager.getLogger(WriterToFile.class);

    @Override
    public void writeToFile(String text) {
        Path path = Paths.get("src/main/resources/");
        String nameFile = "output.txt";
        try {
            Path fileToCreatePath = path.resolve(nameFile);
            String newFileName = fileToCreatePath.toString();
            FileWriter fileWriter =
                    new FileWriter(newFileName, true);
            fileWriter.append(text);
            fileWriter.close();
            LOGGER.debug("Text was written to file "+ nameFile);
        } catch (IOException e) {
            LOGGER.debug("The write operation failed. " + e);
            e.printStackTrace();
        }
    }
}
