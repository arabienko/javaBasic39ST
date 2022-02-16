package by.arabienko.controller.factory;

import by.arabienko.bean.Component;
import by.arabienko.bean.ComponentLeaf;

public class LeafCreator extends Creator{
    @Override
    public Component factoryMethod(String str) {
        Character character = str.charAt(0);
        return new ComponentLeaf(character);
    }
}
