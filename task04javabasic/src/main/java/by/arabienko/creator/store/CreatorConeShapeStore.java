package by.arabienko.creator.store;

import by.arabienko.bean.store.ConeShapeStore;
import by.arabienko.bean.store.RegistrarConeStore;


public class CreatorConeShapeStore extends CreatorStore {

    @Override
    public ConeShapeStore createStore() {
        return new ConeShapeStore();
    }

    @Override
    public RegistrarConeStore createRegistrarStore() {
        return new RegistrarConeStore();
    }
}
