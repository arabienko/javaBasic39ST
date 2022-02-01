package by.arabienko.service.impl;

import by.arabienko.entity.impl.Bank;
import by.arabienko.entity.impl.CreditLine;
import by.arabienko.service.Validation;
import by.arabienko.service.IWorkWithFileJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Read Jason File and write Bank Objects to List.
 */
public class ParseDateFromFileJson implements IWorkWithFileJson {

    /**
     * Logging events.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ParseDateFromFileJson.class);
    @Override
    public List workWithFile(List list) throws IOException {
        String file = (String) list.get(0);
        Validation validation = new Validation();
        if (validation.isExist(file)) {
            throw new IOException("File not exist.");
        }
        if (file.isEmpty()) {
            throw new IOException("No file name.");
        }
        Gson gson = new Gson();
        //Parsing data from a file to a Bank object
        Type listType = new TypeToken<List<Bank>>() {
        }.getType();
        List<CreditLine> listObjects =
                gson.fromJson(loadFileFromClasspath(file),
                        listType);
        LOGGER.debug("File was parsed "
                + file);

        return listObjects;
    }
    private static String loadFileFromClasspath(String fileName)
            throws IOException {
        ClassLoader classLoader =
                ParseDateFromFileJson.class.getClassLoader();
        try (InputStream inputStream =
                     classLoader.getResourceAsStream(fileName)) {
            return IOUtils.toString(inputStream,
                    StandardCharsets.UTF_8);
        }
    }
}

