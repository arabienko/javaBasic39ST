package by.arabienko.task01javabasic.view;

import by.arabienko.task01javabasic.entity.Data;

/**
 * Data Input and Output.
 */
public class InputOutputData {
    public Data input(Data data, final double i) {
        data.push(i);
        return data;
    }

    public Data input(final Data data, final String i) {
        data.push(i);
        return data;
    }

    public void output(final Data arg) {

        for (int i = 0; i < arg.getLength(arg); i++) {
            System.out.print(" " + arg.getData(i));
        }
        System.out.println();
    }

    public void output(final String str, final Data arg) {

        System.out.print(str + " ");
        for (int i = 0; i < arg.getLength(arg); i++) {
            System.out.print(arg.getData(i) + " ");
        }
        System.out.println();
    }

    public void output(final String arg) {

        System.out.println(arg);
    }

    public void output(final String label, final double arg) {

        System.out.print(label + arg);
        System.out.println();
    }

    public void output(final int i, final char arg) {

        System.out.println("number " + i + " - " + arg + " ");
    }
}
