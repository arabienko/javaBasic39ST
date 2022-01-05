package by.arabienko.task01javabasic.service;

import by.arabienko.task01javabasic.view.InputOutputData;

public class ExpressionService {

    /**
     * @param x input
     * @param a Coefficient
     * @param b Coefficient
     * @param c Coefficient
     * @param d Coefficient
     * @return Expression like a*X^3 + b*X^2 + c*X + d
     */
    public double cubicExpression(final double x, final double a,
                                  final double b, final double c,
                                  final double d) {
        ArithmeticService service = new ArithmeticService();

        return service.sum(service.multiply(c, x),
                service.multiply(b, service.exponentiation(x, 2)),
                service.multiply(a, service.exponentiation(x, 3)), d);
    }

    /**
     * @param numberOne first number for compare
     * @param numberTwo second number for compare
     * @return string with the result
     */
    public void compareNumber(final double numberOne,
                              final double numberTwo) {
        //todo true-folse or -1 0 1, iodata-, not void
        InputOutputData ioData = new InputOutputData();
        String compare;
        if (numberOne < numberTwo) {
            ioData.output("Is the number One less than " +
                    "the Second number?: YES");
        } else {
            ioData.output("Is the number One less than " +
                    "the Second number?: NO");
        }

    }

    /**
     * Find max sum: max sum one number of three numbers with fourth
     * and min sum one numebr of the three numbers with fourth.
     *
     * @param a number one
     * @param b number two
     * @param c number three
     * @param d fourth number
     * @return sum = maxSum+minSum
     */
    public double equalNumberD(final double a, final double b,
                               final double c, final double d) {
        InputOutputData ioData = new InputOutputData();
        double muxSub = 0;
        if (a!=d && b!=d && c!=d) {
            ArithmeticService arithmeticService = new ArithmeticService();
            double subDA = arithmeticService.sub(d, a);
            double subDB = arithmeticService.sub(d, b);
            double subDC = arithmeticService.sub(d, c);
            if (subDA > subDB) {
                if (subDA > subDC) {
                    muxSub = subDA;
                }
            } else {
                muxSub = Math.max(subDB, subDC);
            }
        } else {
            ioData.output("One of the numbers is the number D");
        }
        return muxSub;
    }

    /**
     * @param arg input parametr
     * @return calculation result
     * @throws Exception zero check
     */
    public double functionExecute(final double arg) throws Exception {
        ArithmeticService service = new ArithmeticService();
        double result;
        if (arg==-1) {
            throw new Exception("zero exception");
        }
        if (arg > 13) {
            result = service.divide(-3, service.sum(1, arg));
        } else {
            result = service.sub(9, service.exponentiation(arg, 3));
        }
        return result;
    }

    /**
     * @param v  numebrs for compare
     * @param v1 numebrs for compare
     * @param v2 numebrs for compare
     * @return sum: max and min numbers
     * @throws Exception
     */
    public double maxMinCompareNumber(final double v,
                                      final double v1, final double v2)
            throws Exception {
        ArithmeticService service = new ArithmeticService();
        double result = 0;
        if (v==v1 && v2==v1) {
            throw new Exception(" You enter three of the same numbers.");
        }
        if (v==v1 || v2==v1 || v==v2) {
            throw new Exception(" You enter two of the same numbers");
        }

        if (v > v1 && v > v2) {
            if (v1 < v2) {
                result = service.sum(v, v1);
            } else {
                result = service.sum(v, v2);
            }
        }
        if (v1 > v2 && v1 > v) {
            if (v2 < v) {
                result = service.sum(v1, v2);
            } else {
                result = service.sum(v1, v);
            }
        }
        if (v2 > v1 && v2 > v) {
            if (v1 < v) {
                result = service.sum(v2, v1);
            } else {
                result = service.sum(v2, v);
            }
        }
        return result;
    }

    /**
     * @param a values to exchange
     * @param b values to exchange
     */
    public void changeViaParameter(int a, int b) {
        int z;
        System.out.println("1 - Parameter a= " + a
                + "; parameter b= " + b);
        z = a;
        a = b;
        b = z;
        System.out.println("1 - Parameter aNew= " + a
                + "; parameter bNew= " + b);
    }

    /**
     * @param a values to exchange
     * @param b values to exchange
     */
    public void changeViaMathOperations(int a, int b) {
        int count = 0;
        System.out.println("2 - Parameter a= " + a
                + "; parameter b= " + b);
        if (a > b) {
            do {
                b++;
                count++;
            } while (b!=a);
            a -= count;
        } else {
            do {
                a++;
                count++;
            } while (b!=a);
            b -= count;
        }
        System.out.println("2 - Parameter aNew= " + a
                + "; parameter bNew= " + b);
    }

    /**
     * # Second method.
     *
     * @param a values to exchange
     * @param b values to exchange
     */
    public void changeViaMathOperationsTwo(int a, int b) {
        System.out.println("3 - Parameter a= " + a
                + "; parameter b= " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("3 - Parameter aNew= " + a
                + "; parameter bNew= " + b);
        a = a + b - (b = a);
        System.out.println("3 - Parameter aNew= " + "" + a
                + "; parameter bNew= " + b);
    }

    /**
     * change via XOR.
     *
     * @param a values to exchange
     * @param b values to exchange
     */
    public void changeViaLogicOperation(int a, int b) {
        System.out.println("4 - Parameter a= " + a
                + "; parameter b= " + b);
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("4 - Parameter aNew= " + a
                + "; parameter bNew= " + b);


    }
}
