package by.arabienko.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import by.arabienko.service.ServiceException;
import by.arabienko.service.Validation;
import by.arabienko.service.IWorkWithFileJson;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Writes Bank objects to a Json file
 */
public class WriteDateToFileJson implements IWorkWithFileJson {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(WriteDateToFileJson.class);

    @Override
    public List workWithFile(List listDate) throws ServiceException {
        //todo

        Validation validation = new Validation();

        if (!validation.isNotEmpty(listDate)){
            LOGGER.error("No date for write date to file.");
            throw new ServiceException("No date for write date to file.");
        }

        Path path = Paths.get("src/main/resources");

        String str = (String) listDate.get(1);

        List list = (List) listDate.get(0);

        Path fileToCreatePath = path.resolve(String.valueOf(new File(str)));
        Gson gson = new Gson();

        File fileName = new File(String.valueOf(fileToCreatePath));

        // list of Java objects to JSON file
        try (FileWriter writer = new FileWriter(fileName)) {


                gson.toJson(list, writer);

            writer.flush();

        } catch (IOException e) {
            LOGGER.error("Writing is error. "+e);
            e.printStackTrace();
        }

        LOGGER.debug("Writing was created.");
        return listDate;
    }
 }
