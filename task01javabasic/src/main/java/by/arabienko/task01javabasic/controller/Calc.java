package by.arabienko.task01javabasic.controller;

public class Calc {

    public int sub(int a, int b) {
        return 0;
    }

    public int mul(int a, int b) {
        return 0;
    }

    public int div(int a, int b) throws Exception {
        return a/b;
    }

    public double sqrt(double a) throws Exception {
        if (a >= 0) {
            return 0; // Math.sqrt(a); // реализация через метод Ньютона
        } else {
            throw new Exception();
        }

    }

    public int sum(int i, int i1) {
        return i+i1;
    }
}