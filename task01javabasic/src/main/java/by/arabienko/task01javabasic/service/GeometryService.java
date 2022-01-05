package by.arabienko.task01javabasic.service;

import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.view.InputOutputData;

/**
 * Calculation of geometric expressions.
 */
public class GeometryService {

    /**
     * @param x radians.
     * @return degrees.
     */
    public Data radToDegree(final double x) {
        Data dataDegree = new Data();
        double degrees = x * 180 / Math.PI;
        int degreeInt = (int) degrees;
        double min = (degrees - degreeInt) * 60;
        int minInt = (int) min;
        double sec = (min - minInt) * 60;
        int secInt = (int) sec;
        dataDegree.push(degreeInt);
        dataDegree.push(minInt);
        dataDegree.push(secInt);
        return dataDegree;
    }

    public int degree(final double x) {
        double degrees = x * 180 / Math.PI;
        return (int) degrees;
    }

    public int minute(final double x) {
        double degrees = x * 180 / Math.PI;
        int degreeInt = (int) degrees;
        double min = (degrees - degreeInt) * 60;
        return (int) min;
    }

    public int second(final double x) {
        double degrees = x * 180 / Math.PI;
        int degreeInt = (int) degrees;
        double min = (degrees - degreeInt) * 60;
        int minInt = (int) min;
        double sec = (min - minInt) * 60;
        return (int) sec;
    }

    /**
     * @param x Radius
     * @return Circumference
     */
    public double circle(final double x) {

       return (2 * Math.PI * x);
    }

    /**
     * @param x Radius
     * @return Area of a circle
     */
    public double areaOfCircle(final double x) {

       return Math.PI * x * x;
    }

    /**
     * @param x side of a triangle
     * @param y side of a triangle
     * @param a angle between sides
     * @return area of a triangle
     */
    public double triangle(final double x, final double y, final double a) {
        double z = 0.5;
        double rad = Math.toRadians(a);
        ArithmeticService service = new ArithmeticService();
        return (service.multiply(x, y) * Math.sin(rad) * z);
    }

    /**
     * @param cornerOne angle value for calculation.
     * @param cornerTwo angle value for calculation.
     * @return determines which triangle.
     */
    public double cornersTriangle(final double cornerOne,
                                  final double cornerTwo) {
        InputOutputData ioData = new InputOutputData();
        double bln = 0;
        if ((cornerOne + cornerTwo) < 180) {
            if (cornerOne == 90 || cornerTwo == 90
                    || (cornerOne+cornerTwo) == 90) {
                bln = 1;
                ioData.output("The triangle exists and it is rectangular");
            } else {
                ioData.output("The triangle exists and it is not rectangular");
            }
        } else {
            ioData.output("The triangle is not exist");
        }
        return bln;
    }
}
