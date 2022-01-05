package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.impl.Matrix;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SaveToFileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveMatrixToFileImpl implements SaveToFileService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(SaveMatrixToFileImpl.class);

        /**
         * @param list with massive for saving to file
         * @return new List with File name
         * @throws ServiceException write error.
         */
        @Override
        public List saveToFile(List list) throws ServiceException {

            Matrix massiveImpl = (Matrix) list.get(0);

            Number [][] matrix = massiveImpl.getMatrix();

            List<String> listWithNameFile = new ArrayList<>();
            Path path = Paths.get("src/main/resources");

            Path fileToCreatePath = path.resolve("save_matrix.txt");


            // Create a temporary file in a specified directory.
            Path file;
            try {
                file = Files.createFile(fileToCreatePath);


                String newFileName = file.toString();
                LOGGER.debug("File created " + newFileName);

                StringBuilder stringBuilder = new StringBuilder();
                BufferedWriter bufferedWriter;

                bufferedWriter = new BufferedWriter(new FileWriter(newFileName));

                for (Number[] numbers : matrix) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        stringBuilder.append(numbers[j]).append(" ");
                    }
                    stringBuilder.append("\n");
                }
                bufferedWriter.write(String.valueOf(stringBuilder));
                bufferedWriter.close();
                listWithNameFile.add(newFileName);

            } catch (IOException e) {
                LOGGER.debug("The write operation failed. " + e);
                throw new ServiceException("The write operation failed.");
            }
            return listWithNameFile;
        }
    }

