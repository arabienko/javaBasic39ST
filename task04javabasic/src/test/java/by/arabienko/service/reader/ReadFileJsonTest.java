package by.arabienko.service.reader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReadFileJsonTest {
    ReadFileJson readFile = new ReadFileJson();

    static Stream<Arguments> testArgumentsDataProvider() {

        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("123");
        List<String> list2 = new ArrayList<>();
        list2.add("123");
        list2.add("321");
        return Stream.of(
                arguments("fileJsonTest", list),
                arguments("fileJsonTest1", list1),
                arguments("fileJsonTest2", list2),
                arguments("fileJsonTest3", list)
                );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void readFile(String nameFile, List<String> list){
        List<String> actual = readFile.readFile(nameFile);
        assertEquals(actual, list);

    }
}