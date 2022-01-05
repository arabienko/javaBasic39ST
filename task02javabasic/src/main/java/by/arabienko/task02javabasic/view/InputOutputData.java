package by.arabienko.task02javabasic.view;


/**
 * Data Input and Output.
 */
public class InputOutputData {


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
