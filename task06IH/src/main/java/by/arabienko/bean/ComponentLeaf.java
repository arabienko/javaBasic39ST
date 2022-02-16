package by.arabienko.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ComponentLeaf implements Component {
    private Character symbol;

    public ComponentLeaf(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    @Override
    public void addElement(Component component) throws ExceptionBean {
        throw new ExceptionBean("Cannot add component.");
    }

    @Override
    public String getSomeDelimiter() throws ExceptionBean {
        throw new ExceptionBean("Cannot get delimiter.");
    }

    @Override
    public Object getElement(int i){
        return symbol;
    }

    @Override
    public ArrayList<Component> getComponents() throws ExceptionBean {
        throw new ExceptionBean("Cannot get components.");
    }

    @Override
    public void removeElement(Component component) throws ExceptionBean {
        throw new ExceptionBean("Cannot remove component.");
    }

    @Override
    public Iterator<Component> getIterator() throws ExceptionBean {
        throw new ExceptionBean("Cannot get iterator component.");
    }

    @Override
    public int getSize() throws ExceptionBean {
        throw new ExceptionBean("Cannot get size component.");
    }

    @Override
    public String toString() {
        return "{" + symbol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof ComponentLeaf)) return false;
        ComponentLeaf leaf = (ComponentLeaf) o;
        if(!symbol.equals(leaf.symbol)){
            return false;
        }
        return symbol.equals(leaf.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
