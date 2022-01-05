package by.arabienko.task01javabasic.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * storing values.
 */
public class Data {
     private final List<Double> list = new ArrayList<>();

    private final List<String> list2 = new ArrayList<>();

    /**
     * @param i number item
     * @return item
     */
    public double getData(final int i) {

        return list.get(i);
    }

    /**
     * @param i number item
     */
    public void push(final double i) {

        list.add(i);
    }

    public void push(final String i) {

        list2.add(i);
    }

    /**
     * @param data
     * @return number of members.
     */
    public int getLength(final Data data) {

        return list.size();
    }
}
