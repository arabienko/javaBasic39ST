package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RatioVolumesFigureByPlaneTest {
    RatioVolumesFigureByPlane counting = new RatioVolumesFigureByPlane();

    static Stream<Arguments> testArgumentsDataProvider() {
        return Stream.of(
                arguments(1, 10, 5, 20, 20, 0.13),
                arguments(1, 20, 3, 40, 40, 0.13),
                arguments(1, 20, 3, -40, -40, 0),
                arguments(1, 20, 3, -40, 10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void counting(double x, double y, double z, double high, double radius, double count) {
        ConeShape coneShape = new ConeShape(
                "name", x, y, z, high, radius);
        double expected = count;
        double actual = counting.counting(coneShape);
        assertEquals(expected, actual, 0.01);
    }
}