package by.arabienko.service;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.impl.GetGuidAfterTime;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GetGuidAfterTimeTest {
    GetGuidAfterTime getGuidAfterTime = new GetGuidAfterTime();

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
        String day2 = "SUNDAY";
        String time = "10:00";
        String time2 = "22:00";
        String time3 = "20:00";
        HashMap<String, ProgramGuide.Program> hashMapExpected = new HashMap<>();
        hashMapExpected.put("NATURE",program2);
        HashMap<String, ProgramGuide.Program> hashMapExpected2 = new HashMap<>();
        hashMapExpected2.put("NATURE",program2);
        HashMap<String, ProgramGuide.Program> hashMapExpected3 = new HashMap<>();
        hashMapExpected3.put("NATURE",program3);
        List<ProgramGuide> programGuideList3 = programGuideList;

        return Stream.of(
                arguments(programGuideList, day, time,hashMapExpected),
                arguments(programGuideList, day, time2,hashMapExpected2),
                arguments(programGuideList, day2, time,hashMapExpected2),
                arguments(programGuideList3, day, time3,hashMapExpected3)
        );
    }
    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void execute(List list, String day, String time, HashMap hashMapExpected) throws ServiceException {
        HashMap hashMapActual = getGuidAfterTime.execute(list, day, time);
        assertEquals(hashMapActual, hashMapExpected);
    }
}
