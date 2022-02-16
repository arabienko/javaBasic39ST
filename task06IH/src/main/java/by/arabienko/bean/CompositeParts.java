package by.arabienko.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class CompositeParts implements Component {
    private String someDelimiter;
    private ArrayList<Component> components = new ArrayList<>();

    public CompositeParts(String someDelimiter) {
        this.someDelimiter = someDelimiter;
    }

    public String getSomeDelimiter() {
        return someDelimiter;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    @Override
    public void addElement(Component component) {
        components.add(component);
    }

    @Override
    public Object getElement(int i) {
        return components.get(i);
    }

    @Override
    public void removeElement(Component component) {
        components.remove(component);
    }

    public int getSize() {
        return components.size();
    }

    @Override
    public Iterator<Component> getIterator() {
        return components.iterator();
    }

    @Override
    public String toString() {
        return "Composite{" + components +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof CompositeParts)){
            System.out.println("CompositeParts not");
            return false;}
        CompositeParts that = (CompositeParts) o;
        if( this.getSize() != that.getSize()) {
            return false;}
        for (int i = 0; i < this.getSize(); i++) {
            if (!that.getSomeDelimiter().equals(this.getSomeDelimiter())
                    || !that.getElement(i).equals(this.getElement(i))){
                return false;
            }

        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}