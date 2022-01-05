package by.arabienko.task01javabasic.service;

import by.arabienko.task01javabasic.entity.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeometryServiceTest {
    GeometryService geometryService = new GeometryService();

    @DataProvider(name = "converting radians to degrees")
    public Object[][] dateFromRadianToDegree() {
        return new Object[][]{
                {new double[]{0}, 0},
                {new double[]{Math.PI}, 180},
                {new double[]{-Math.PI * 2}, -360},
                {new double[]{Math.PI / 2}, 90},
                {new double[]{Math.PI / 4}, 45}
        };
    }
    @Test(description = "Positive scenario converting from radian to degree",
            dataProvider = "converting radians to degrees")
    @Parameters({"testng", "expectedDegree"})
    public void testRadToDegree(double[] arg, double expected) {
        Data actual = geometryService.radToDegree(arg[0]);
        assertEquals(actual.getData(0), expected);
    }

    @DataProvider(name = "input_date_to_degree")
    public Object[][] dateDegree() {
        return new Object[][]{
                {new double[]{0}, 0},
                {new double[]{Math.PI}, 180},
                {new double[]{-Math.PI * 2}, -360},
                {new double[]{Math.PI / 2}, 90},
                {new double[]{Math.PI / 4}, 45}
        };
    }

    @DataProvider(name = "input_date_to_Minute")
    public Object[][] dateMinute() {
        return new Object[][]{
                {new double[]{0}, 0},
                {new double[]{Math.PI}, 0},
                {new double[]{Math.PI * 2}, 0},
                {new double[]{Math.PI / 5}, 0},
        };
    }

    @Test(groups = "Radian", description = "from radian to degree" +
            "/ positive scenario", dataProvider = "input_date_to_degree")
    @Parameters({"testng", "expectedDegree"})
    public void testDegree(double[] arg, double expected) {
        double actual = geometryService.degree(arg[0]);
        assertEquals(actual, expected);
    }

    @Test(groups = "Radian", description = "from radian to minute" +
            "/ positive scenario", dataProvider = "input_date_to_Minute")
    @Parameters({"testng", "expectedDegree"})
    public void testMinute(double[] arg, double expected) {
        double actual = geometryService.minute(arg[0]);
        assertEquals(actual, expected);
    }


    @Test(groups = "Radian", description = "from radian to second" +
            "/ positive scenario", dataProvider = "input_date_to_Minute")
    @Parameters({"testng", "expectedDegree"})
    public void testSecond(double[] arg, double expected) {
        int actual = geometryService.second(arg[0]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "input_date_radius")
    public Object[][] dateForCircle() {
        return new Object[][]{
                {new double[]{0}, 0},
                {new double[]{1}, 2 * Math.PI},
                {new double[]{-1}, -2 * Math.PI},
                {new double[]{2}, Math.PI * 4},
                {new double[]{0.5}, Math.PI}
        };
    }

    @DataProvider(name = "input_date_radius_for_area")
    public Object[][] dateForAreaCircle() {
        return new Object[][]{
                {new double[]{0}, 0.0},
                {new double[]{1}, Math.PI},
                {new double[]{-1}, Math.PI},
                {new double[]{4}, Math.PI * 16},
                {new double[]{9}, Math.PI * 81}
        };
    }

    @Test(groups = "Radius", description = "circumference" +
            "/ positive scenario", dataProvider = "input_date_radius")
    @Parameters({"testng", "expectedDegree"})
    public void testCircle(double[] arg, double expected) {
        double actual = geometryService.circle(arg[0]);
        assertEquals(actual, expected);
    }

    @Test(groups = "Radius", description = "area of circle" +
            "/ positive scenario", dataProvider = "input_date_radius_for_area")
    @Parameters({"testng", "expectedDegree"})
    public void testAreaOfCircle(double[] arg, double expected) {
        double actual = geometryService.areaOfCircle(arg[0]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "input_date_triangle")
    public Object[][] dateForAreaTriangle() {
        return new Object[][]{
                {new double[]{0, 0, 90}, 0},
                {new double[]{1, 0, 45}, 0},
                {new double[]{0, 1, 30}, 0},
                {new double[]{-1, 0, 45}, 0},
                {new double[]{5, 5, 0}, 0},
                {new double[]{5, 5, 0}, 0}
        };
    }

    @Test(description = "area of triangle / positive scenario",
            dataProvider = "input_date_triangle")
    @Parameters({"testng", "expectedDegree"})
    public void testTriangle(double[] arg, double expected) {
        double actual = geometryService.triangle(arg[0], arg[1], arg[2]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "corners_triangle")
    public Object[][] dateCorners() {
        return new Object[][]{
                {new double[]{0, 0}, 0},
                {new double[]{45, 45}, 1},
                {new double[]{0, 1, 30}, 0},
                {new double[]{200, 0, 45}, 0},
                {new double[]{100, 100, 0}, 0},
                {new double[]{181, 25, 0}, 0}
        };
    }

    @Test(description = "positive, corners triangle",
            dataProvider = "corners_triangle")
    @Parameters({"testng", "expectedDegree"})
    public void testCornersTriangle(double[] arg, double expected) {
        double actual = geometryService.cornersTriangle(arg[0], arg[1]);
        assertEquals(actual, expected);
    }
}