package by.arabienko.service.reader;

import by.arabienko.service.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReadFileTXTTest {
    ReadFileTXT readFile = new ReadFileTXT();

    static Stream<Arguments> testArgumentsDataProvider() {

        List<String> list=new ArrayList<>();
        List<String>list1=new ArrayList<>();
        list1.add("123");
        List<String>list2=new ArrayList<>();
        list2.add("123");
        list2.add("321");
        return Stream.of(
                arguments("fileTXTtest",list ),
                arguments("fileTXTtest1",list1 ),
                arguments("fileTXTtest2",list2 ),
                arguments("fileTXTtest3",list )
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void readFile(String nameFile, List<String> list ) throws ServiceException {
        List<String> actual = readFile.readFile(nameFile);
        assertEquals(actual,list);
    }
}