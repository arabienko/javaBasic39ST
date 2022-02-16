package by.arabienko.bean;

import java.util.ArrayList;
import java.util.Iterator;

public interface Component {
    void addElement(Component component) throws ExceptionBean;
    String getSomeDelimiter() throws ExceptionBean;
    Object getElement(int i) throws ExceptionBean;
    ArrayList<Component> getComponents() throws ExceptionBean;
    void removeElement(Component component) throws ExceptionBean;
    Iterator<Component> getIterator() throws ExceptionBean;
    int getSize() throws ExceptionBean;
}
