package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BaseOnPlaneTest {
    BaseOnPlane baseOnPlane = new BaseOnPlane();

    static Stream<Arguments> testArgumentsDataProvider() {

        return Stream.of(
                arguments(10,20,1, 0),
                arguments(3,3,1,0),
                arguments(0,0,0, 1),
                arguments(0,0,5,1)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void counting(double x, double y,double z, double count) {
        ConeShape coneShape = new ConeShape("name", x, y, z, 1, 1);
        double expected = count;
        double actual = baseOnPlane.counting(coneShape);
        assertEquals(expected, actual, 0.01);
    }
}