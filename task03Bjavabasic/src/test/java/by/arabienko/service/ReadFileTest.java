package by.arabienko.service;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.impl.ReadFile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReadFileTest {
    ReadFile readFile = new ReadFile();


    static Stream<Arguments> testArgumentsDataProvider() {
        List<ProgramGuide.Program> actualProgram = new ArrayList<>();
        ProgramGuide.Program program = new ProgramGuide().new Program("Wild animals.", "8:15");
        actualProgram.add(program);
        ProgramGuide programGuid = new ProgramGuide("NATURE", "England", "MONDAY", actualProgram);
        List<ProgramGuide> programGuideList = new ArrayList<>();
        programGuideList.add(programGuid);
        HashMap hashMapExpected = new HashMap<>();
        hashMapExpected.put(0, programGuideList);
        String nameFile = "testGuid";
        String nameFile2 = "";
        ProgramGuide programGuide2 = null;
        HashMap hashMapExpected2 = new HashMap();
        hashMapExpected2.put(0, programGuide2);
        String nameFile3 = "testGuid2";
        return Stream.of(
                arguments(hashMapExpected, nameFile),
                arguments(hashMapExpected, nameFile2),
                arguments(hashMapExpected2, nameFile3)
        );
    }
    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void execute(HashMap expected, String nameFile) throws IOException {
        HashMap hashMapActual = readFile.read(nameFile);
        assertEquals(expected, hashMapActual);
    }
}