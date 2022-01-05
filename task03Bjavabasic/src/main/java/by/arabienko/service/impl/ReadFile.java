package by.arabienko.service.impl;


import by.arabienko.service.IFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import by.arabienko.entity.ProgramGuide;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.Logger;

/**
 * Read file
 */
public class ReadFile implements IFile {

   private static final Logger LOGGER = LogManager.getLogger(ReadFile.class);

    public HashMap read(String str) throws IOException {

        if (str.isEmpty() || str.trim().isEmpty()){
            LOGGER.debug("File name is empty.");
           throw  new ServerException("File name is empty.");
        }
       List<ProgramGuide> fromJson = new Gson().fromJson(
               loadFileFromClasspath(str),
                new TypeToken<List<ProgramGuide>>() {
        }.getType());
        LOGGER.debug("File was parsed: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put(0, fromJson);

        return hashMap;
    }

    private static String loadFileFromClasspath(String fileName) throws IOException {
        ClassLoader classLoader = ReadFile.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }
}
