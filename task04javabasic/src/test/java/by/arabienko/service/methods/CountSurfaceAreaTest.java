package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountSurfaceAreaTest {
    CountSurfaceArea counting = new CountSurfaceArea();
    static Stream<Arguments> testArgumentsDataProvider() {
        return Stream.of(
                arguments(10,20,2661.60),
                arguments(3,3,68.26),
                arguments(0,0,0),
                arguments(-1,20,0)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void counting(double high, double radius, double count) {
        ConeShape coneShape = new ConeShape(
                "name", 1, 1, 1,high, radius);
        double expected = count;
        double actual = counting.counting(coneShape);
        assertEquals(expected, actual,0.01);
    }
}