package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SortDateFileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Sort big file.
 * External sorting.
 * Divide the file into smaller parts.
 * We sort them using the quick sort method.
 * Next, we sort the files using the merge method.
 */
public class FileSortImpl implements SortDateFileService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(FileSortImpl.class);

    /**
     * Divide the file into parts (set the size in the method).
     * @param list list with name file for sorting.
     * @return new sorting file.
     * @throws ServiceException exception.
     */
    @Override
    public List sortDate(List list) throws ServiceException {

        String fileName = (String) list.get(0);
        ClassLoader classLoader = getClass().getClassLoader();
        List<String> tempFileSet;
        char[] buffer;
        int bytesAmount;
        InputStreamReader streamReader;
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            tempFileSet = new ArrayList<>();
            int sizeOfFiles = 250 * 100;
            buffer = new char[sizeOfFiles];
            streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            while ((bytesAmount = bufferedReader.read(buffer)) > 0) {
                // Create a temporary file
                Path path = Paths.get("src/main/resources/tempdir");
                // Create a temporary file in a specified directory.
                Path file = Files.createTempFile(path, "temp_", ".txt");
                String str = file.toString();
                tempFileSet.add(str);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
                bufferedWriter.write(String.valueOf(buffer), 0, bytesAmount);
                bufferedWriter.close();
                sortFile(str);
            }
            bufferedReader.close();
        } catch (IOException | ServiceException e) {
            LOGGER.debug("Incorrect creation of temporary files.");
            throw new ServiceException("The sort file operation failed.");
        }
        String getResult = generateMergeTempFiles(tempFileSet);
        List<String> newList = new ArrayList<>();
        newList.add(getResult);
        LOGGER.debug(" Sort file completed " + getResult);
        return newList;
    }


    /**
     * Write the data into new files and sort them.
     * @param filePath
     * @throws ServiceException
     */
    static private void sortFile(String filePath) throws ServiceException {

        try (BufferedReader bw = new BufferedReader(new FileReader(filePath))) {
            String s;
            StringBuilder sb = new StringBuilder();

            while ((s = bw.readLine())!=null) {
                sb.append(s);
            }
            String[] word = sb.toString().trim().split(" ");
            int[] numb = new int[word.length];
            int i = 0;
            for (String string : word) {
                numb[i] = parseInt(string);
                i++;
            }
            quickSort(numb, 0, numb.length - 1);
            writeArrayToFile(filePath, numb);
        } catch (IOException | ServiceException ex) {
            LOGGER.debug("The sort temp file operation failed.");
            throw new ServiceException("The sort temp file operation failed.");
        }
    }


    /**
     * A static method for writing data to a file.
     * @param filePath
     * @param numb
     * @throws ServiceException
     */
    private static void writeArrayToFile(String filePath, int[] numb) throws ServiceException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            for (int num : numb) {
                String s1 = String.valueOf(num);
                stringBuilder.append(s1);
                stringBuilder.append(" ");
            }
            String str = stringBuilder.toString();
            bufferedWriter.write(str);
            bufferedWriter.close();
       } catch (IOException e) {
            LOGGER.debug("The write operation failed.");
            throw new ServiceException("The write operation failed.");
        }
    }

    /**
     * Quick sorting. The array is divided into two sub arrays,
     * the middle line is the element that is in the center.
     * During the work of the algorithm, elements smaller
     * than the middle one are moved to the left,
     * and the big ones to the right. The same actions will be
     * performed recursively. Sub-arrays will be split into
     * sub-arrays (until there is one element left).
     * @param array       array for sorting
     * @param leftBorder  first item in array
     * @param rightBorder second item in array
     */
    private static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Move the left marker from left to right while the element is smaller than the pivot
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            // Move the right marker until the element is larger than the pivot
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            // Let's check that there is no need to swap the elements that the markers point to.
            if (leftMarker <= rightMarker) {
                // The left marker will be smaller than the right marker only if we have to swap
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                // Move markers to get new borders
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        // Execute recursively for parts
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
    }


    /**
     * Merge two files.Create a temporary file to merge the two.
     * @param tempFileSet list with set files for merge.
     * @return name sort big file.
     * @throws ServiceException exception.
     */
    private static String generateMergeTempFiles(List<String> tempFileSet) throws ServiceException {

        String str = null;
        String strNew = null;
        while (tempFileSet.size() > 1) {
            File pathFirst = new File(tempFileSet.get(0));
            File pathSecond = new File(tempFileSet.get(1));
            str = mergeFileTemp(pathFirst, pathSecond);
            tempFileSet.remove(0);
            tempFileSet.remove(0);
            tempFileSet.add(str);
        }
        Path source = Paths.get(str);
        Path target = Paths.get("src/main/resources/newSortFile.txt");
        try {
            strNew = String.valueOf(Files.move(source, target));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Merge short file completed");
        return strNew;
    }

     /**
     * Sort by merging two files.
     * @param pathFirst  name file for merge.
     * @param pathSecond name file for merge.
     * @return new merge file.
     * @throws ServiceException
     */
    private static String mergeFileTemp (File pathFirst, File pathSecond) throws ServiceException {

        //list for saving numbers.
        List<Integer> list = new ArrayList<>();
        // Create a temporary file in a specified directory.
        Path file;
        String str;
        BufferedWriter bufferedWriter;
        Path path = Paths.get("src/main/resources/tempdir");
        try {
            file = Files.createTempFile(path, "Merg_temp_", ".txt");
            str = file.toString();
            LOGGER.debug("Create temp file: "+ str);
           bufferedWriter = new BufferedWriter(new FileWriter(str));
            Scanner scanner1 = new Scanner(pathFirst);
            Scanner scanner2 = new Scanner(pathSecond);
            int num1;
            int num2;
            boolean bln = true;
            boolean bln2 = true;
            int count = 0;
            while ((scanner1.hasNext() || bln) & (scanner2.hasNext() || bln2)) {
                if (scanner1.hasNext()) {
                    num1 = scanner1.nextInt();
                    if (scanner2.hasNext()) {
                        num2 = scanner2.nextInt();
                        if (list.size()!=0) {
                            List newList = new ArrayList();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i) <= num1 &
                                        (list.get(i) <= num2 )) {
                                    String stringBuilder = list.get(i) +
                                            " ";
                                    bufferedWriter.write(stringBuilder);
                                    newList.add(list.get(i));
                                }
                            }
                            list.removeAll(newList);
                        }
                        if (num1 > num2) {
                            String stringBuilder = num2 +
                                    " ";
                            bufferedWriter.write(stringBuilder);
                            list.add(num1);
                        } else {
                            String stringBuilder = num1 +
                                    " ";
                            bufferedWriter.write(stringBuilder);
                            list.add(num2);
                            count = num2;
                        }
                    } else {
                        while (scanner1.hasNext()) {
                            int num3 = scanner1.nextInt();
                            String stringBuilder = num3 +
                                    " ";
                            bufferedWriter.write(stringBuilder);
                            if (list.size()!=0) {
                                List newList = new ArrayList();
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i) <= num3 ) {
                                        String stringBuilder1 = list.get(i) +
                                                " ";
                                        bufferedWriter.write(stringBuilder1);
                                        newList.add(list.get(i));
                                    }
                                }
                                list.removeAll(newList);
                            }
                        }
                        bln2 = false;
                    }
                } else {
                    while (scanner2.hasNext()) {
                        int num3 = scanner2.nextInt();
                        String stringBuilder = num3 +
                                " ";
                        bufferedWriter.write(stringBuilder);
                        if (list.size()!=0) {
                            List newList = new ArrayList();
                            for (Integer integer : list) {
                                if (integer <= num3) {
                                    String stringBuilder1 = integer +
                                            " ";
                                    bufferedWriter.write(stringBuilder1);
                                    newList.add(integer);
                                }
                            }
                            list.removeAll(newList);
                        }
                    }
                    bln = false;
                }
            }
            for (Integer integer : list) {
                String stringBuilder = integer +
                        " ";
                bufferedWriter.write(stringBuilder);
            }
            list.clear();
            bufferedWriter.close();
        } catch (IOException e) {
            LOGGER.debug("The merge two file operation failed." + e);
            throw new ServiceException("The merge two file operation failed.");
        }
        return str;
    }


    /**
     * method for generate new big file with int numbers, using only for create file.
     */
    public void generateBigFile() throws ServiceException {

        String fileName = "src/main/resources/filesort";
        // size new big file
        int lineSize = 100;
        int lines = 1000;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            Random random = new Random();
            for (int i = 0; i < lines; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                //Generate random numbers into file
                while (stringBuilder.length() < lineSize) {
                    stringBuilder.append(random.nextInt(1000));
                    stringBuilder.append(" ");
                }
                String padding = stringBuilder.toString();

                bufferedWriter.write(padding);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            LOGGER.debug("The creation big file is failed." + e);
            throw new ServiceException("The creation big file is failed.");
        }
    }


/*    *//**
     * Sort by merging two files.
     * @param pathFirst  name file for merge.
     * @param pathSecond name file for merge.
     * @return new merge file.
     *//*
    private static String mergeFileTwo(File pathFirst, File pathSecond) throws ServiceException {

        //list for saving numbers.
        List<Integer> list = new ArrayList<>();
        // Create a temporary file in a specified directory.
        Path file;
        String str;
        BufferedWriter bufferedWriter;
        Path path = Paths.get("src/main/resources/tempdir");
        try {
            file = Files.createTempFile(path, "Merg_temp_", ".txt");
            str = file.toString();
            LOGGER.debug("Create temp file: "+ str);
            bufferedWriter = new BufferedWriter(new FileWriter(str));
            Scanner scanner1 = new Scanner(pathFirst);
            Scanner scanner2 = new Scanner(pathSecond);
            int num1;
            int num2;
            boolean bln = true;
            boolean bln2 = true;
            int count = 0;
            while (scanner1.hasNext() || bln) {
                if (scanner1.hasNext()) {
                    num1 = scanner1.nextInt();
                    while (scanner2.hasNext() || bln2) {
                        if (scanner2.hasNext()) {
                            num2 = scanner2.nextInt();
                            if (list.size()!=0) {
                                List newList = new ArrayList();
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i) <= num1 &
                                            (num1 <= num2 )) {
                                        String stringBuilder = list.get(i) +
                                                " ";
                                        bufferedWriter.write(stringBuilder);
                                        newList.add(list.get(i));
                                    }
                                }
                                list.removeAll(newList);
                            }
                            if (num1 > num2) {
                                String stringBuilder = num2 +
                                        " ";
                                bufferedWriter.write(stringBuilder);
                            } else {
                                String stringBuilder = num1 +
                                        " ";
                                bufferedWriter.write(stringBuilder);
                                list.add(num2);
                                count = num2;
                                break;
                            }
                        } else {
                            while (scanner1.hasNext()) {
                                int num3 = scanner1.nextInt();

                                String stringBuilder = num3 +
                                        " ";
                                bufferedWriter.write(stringBuilder);
                                if (list.size()!=0) {
                                    List newList = new ArrayList();

                                    for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i) <= num3 ) {
                                            String stringBuilder1 = list.get(i) +
                                                    " ";
                                            bufferedWriter.write(stringBuilder1);
                                            newList.add(list.get(i));
                                        }
                                    }
                                    list.removeAll(newList);
                                }
                            }

                            bln2 = false;
                        }
                    }
                } else {
                    while (scanner2.hasNext()) {
                        int num3 = scanner2.nextInt();
                        String stringBuilder = num3 +
                                " ";
                        bufferedWriter.write(stringBuilder);
                        if (list.size()!=0) {
                            List newList = new ArrayList();

                            for (Integer integer : list) {
                                if (integer <= num3) {
                                    String stringBuilder1 = integer +
                                            " ";
                                    bufferedWriter.write(stringBuilder1);
                                    newList.add(integer);
                                }
                            }
                            list.removeAll(newList);
                        }
                    }
                    bln = false;
                }
            }
            for (Integer integer : list) {
                String stringBuilder = integer +
                        " ";
                bufferedWriter.write(stringBuilder);
            }

            list.clear();
            bufferedWriter.close();

        } catch (IOException e) {
            LOGGER.debug("The merge two file operation failed." + e);
            throw new ServiceException("The merge two file operation failed.");
        }
        return str;
    }*/

}

