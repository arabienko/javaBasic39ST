package by.arabienko.service;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.impl.GetGuidChannel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GetGuidChannelTest {
    GetGuidChannel getGuidChannel = new GetGuidChannel();

    static Stream<Arguments> testArgumentsDataProvider() {
        List<ProgramGuide.Program> actualProgram = new ArrayList<>();
        ProgramGuide.Program program = new ProgramGuide().new Program("Wild animals.", "8:15");
        actualProgram.add(program);
        ProgramGuide.Program program2 = new ProgramGuide().new Program("Home.", "10:15");
        actualProgram.add(program2);
        ProgramGuide.Program program3 = new ProgramGuide().new Program("Ocean", "20:15");
        actualProgram.add(program3);
        ProgramGuide programGuid = new ProgramGuide("NATURE", "England", "MONDAY", actualProgram);
        List<ProgramGuide> programGuideList = new ArrayList<>();
        programGuideList.add(programGuid);
        String day = "MONDAY";
        String day2="";
        String channel = "NATURE";
        String channel2 = " ";
        String channel3 = "COOKING";
        HashMap<String, ProgramGuide.Program> hashMapExpected = new HashMap<>();
        hashMapExpected.put(String.valueOf(0), program);
        hashMapExpected.put(String.valueOf(1), program2);
        hashMapExpected.put(String.valueOf(2), program3);


        return Stream.of(
                arguments(programGuideList, channel, day, hashMapExpected),
                arguments(programGuideList, channel3, day, hashMapExpected),
                arguments(programGuideList, channel, day2, hashMapExpected),
                arguments(programGuideList, channel2, day, hashMapExpected)
       );
    }
    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void execute(List<ProgramGuide> list, String channel, String day, HashMap hashMapExpected) throws ServiceException {
        HashMap hashMapActual = getGuidChannel.execute(list, channel, day);
        assertEquals(hashMapExpected, hashMapActual);
    }
}