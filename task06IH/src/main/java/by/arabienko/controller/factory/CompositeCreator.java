package by.arabienko.controller.factory;

import by.arabienko.bean.Component;
import by.arabienko.bean.CompositeParts;

public class CompositeCreator extends Creator{
    @Override
    public Component factoryMethod(String str) {
        return new CompositeParts(str);
    }
}
