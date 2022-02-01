package by.arabienko.task05thread.bean.impl;

import by.arabienko.task05thread.bean.ArrayInterface;

import java.util.Arrays;

/**
 * @param <T> parametric class Massive
 */
public class Massive<T extends Number> implements ArrayInterface {

    private T[] massive;
    private static long counter = 0;
    private static long ID = counter++;

    public Massive(T[] massive) {
        this.massive = massive;
    }
    public Massive() {
    }
   public T[] getMassive() {
        T[] massiveCopy = massive.clone();
        return massiveCopy;
    }
    public void setMassive(T[] massive) {
        this.massive = massive;
    }

    @Override
    public long id() {
        return ID;
    }

    private Number getElement(int column) {
        return massive[column];
    }
    public void setElement(int column, T value) {
        massive[column] = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Massive<?> massive1 = (Massive<?>) o;
        for (int i = 0; i < massive.length; i++) {
            if (Double.compare(massive1.getElement(i).doubleValue(),
                    massive[i].doubleValue()) != 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
       /* final int prime = 37;
        int result = 1;
        result = prime * result + Arrays.hashCode(massive);
        result = (int) (prime * result + ID);*/
        return Arrays.hashCode(massive);
    }
    @Override
    public String toString() {
        final String SPACE = ", ";
        StringBuilder stringBuilder = new StringBuilder("\nMassive: "
                + massive.length + " elements " + "\n");
        for (T rows : massive) {
            stringBuilder.append(rows).append(SPACE);
        }
        return stringBuilder.toString();
    }
}
