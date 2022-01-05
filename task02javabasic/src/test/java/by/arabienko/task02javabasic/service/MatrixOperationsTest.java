package by.arabienko.task02javabasic.service;

import by.arabienko.task02javabasic.bean.BeanException;
import by.arabienko.task02javabasic.bean.impl.Matrix;
import by.arabienko.task02javabasic.service.impl.MatrixOperations;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class MatrixOperationsTest {
    MatrixOperations matrixOperations = new MatrixOperations();

    static final double DELTA = 0.00001;

    @DataProvider(name = "arithmetic_sum")
    public Object[][] dateForArithmeticSum() {
        return new Object[][]{
                new Object[]{new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{2, 4, 6}, {6, 10, 8}, {14, 18, 16}}},

                {new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{-1, -2, -3}, {-3, -5, -4}, {-7, -9, -8}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},

                {new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                },
                {new Number[][]{{0}},
                        new Number[][]{{1}},
                        new Number[][]{{1}}
                },
                {new Number[][]{{0}},
                        new Number[][]{{0}},
                        new Number[][]{{0}}
                }
        };
    }

    @Test(description = "positive scenario for testing sum matrices [][]",
            dataProvider = "arithmetic_sum")
    public void testMatrixSum (Number[][] arg, Number[][] arg2,
                               Number[][] expected) throws ServiceException, BeanException {

        Matrix matrix =
                new Matrix(arg);
        Matrix matrix2 =
                new Matrix(arg2);
        Matrix matrixExpected =
                new Matrix(expected);
        Matrix actual = matrixOperations.
                matrixSum(matrix, matrix2);
        assertTrue(actual.equals(matrixExpected));
    }


    @DataProvider(name = "arithmetic_Subtraction")
    public Object[][] dateForArithmeticSubtraction() {
        return new Object[][]{
                new Object[]{new Number[][]{{1.0, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},

                {new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{-1, -2, -3}, {-3, -5, -4}, {-7, -9, -8}},
                        new Number[][]{{2, 4, 6}, {6, 10, 8}, {14, 18, 16}}},

                {new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                },
                {new Number[][]{{0}},
                        new Number[][]{{1}},
                        new Number[][]{{-1}}
                },
                {new Number[][]{{1}},
                        new Number[][]{{1}},
                        new Number[][]{{0}}
                }
        };
    }
    @Test(description = "positive scenario for testing subtraction matrices [][]",
            dataProvider = "arithmetic_Subtraction")
    public void testMatrixSubtraction (Number[][] arg, Number[][] arg2,
                                       Number[][] expected) throws ServiceException, BeanException {
        Matrix matrix =
                new Matrix(arg);
        Matrix matrix2 =
                new Matrix(arg2);
        Matrix matrixExpected =
                new Matrix(expected);
        Matrix actual = matrixOperations.
                matrixSubtraction(matrix, matrix2);
        assertTrue(actual.equals(matrixExpected));
    }

    @DataProvider(name = "arithmetic_multiply")
    public Object[][] dateForArithmeticMultiply() {
        return new Object[][]{
                new Object[]{new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{1, 4, 9}, {9, 25, 16}, {49, 81, 64}}},

                {new Number[][]{{1, 2, 3}, {3, 5, 4}, {7, 9, 8}},
                        new Number[][]{{-1, -2, -3}, {-3, -5, -4}, {-7, -9, -8}},
                        new Number[][]{{-1, -4, -9}, {-9, -25, -16}, {-49, -81, -64}}},

                {new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                        new Number[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
                },
                {new Number[][]{{0}},
                        new Number[][]{{1}},
                        new Number[][]{{0}}
                },
                {new Number[][]{{1}},
                        new Number[][]{{1}},
                        new Number[][]{{1}}
                }
        };
    }

    @Test(description = "positive scenario for testing multiply matrices [][]",
            dataProvider = "arithmetic_multiply")
    public void testMatrixMultiply (Number[][] arg, Number[][] arg2,
                                       Number[][] expected) throws ServiceException, BeanException {
        Matrix matrix =
                new Matrix(arg);
        Matrix matrix2 =
                new Matrix(arg2);
        Matrix matrixExpected =
                new Matrix(expected);
        Matrix actual = matrixOperations.
                matrixMultiply(matrix, matrix2);
        assertTrue(actual.equals(matrixExpected));

    }

    @DataProvider(name = "arithmetic_multiply_by_number")
    public Object[][] dateForArithmeticMultiplyByNumber() {
        return new Object[][]{
                new Object[]{new Number[][]{{1.0, 2.0, 3.0}, {3.0, 5.0, 4.0}, {7.0, 9.0, 8.0}}, 0.0,
                        new Number[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}},

                {new Number[][]{{0.0, 0, 0}, {0, 0, 0}, {0, 0, 0}}, -15,
                        new Number[][]{{0.0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},

                {new Number[][]{{0, 2, 3}, {3, 5, 4}, {7, 9, 8}},-1,
                        new Number[][]{{0.0, -2, -3}, {-3, -5, -4}, {-7, -9, -8}},
                }
        };
    }
    @Test(description = "positive scenario for testing matrix multiplication by number",
            dataProvider = "arithmetic_multiply_by_number")
    public void testMatrixMultiplyNumber (Number[][] arg, double number,
                                    Number[][] expected) throws ServiceException, BeanException {
        Matrix matrix =
                new Matrix(arg);
        Matrix matrixExpected =
                new Matrix(expected);
        Matrix actual = matrixOperations.
                matrixMultiplyNumber(matrix, number);
        assertTrue(actual.equals(matrixExpected));
    }
}
