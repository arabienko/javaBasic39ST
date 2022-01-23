package by.arabienko.creator.store;

import by.arabienko.bean.store.ConeShapeStore;
import by.arabienko.bean.store.RegistrarConeStore;

public abstract class CreatorStore {
    public abstract ConeShapeStore createStore();
    public abstract RegistrarConeStore createRegistrarStore();
}
