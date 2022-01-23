package by.arabienko.service.methods;

import by.arabienko.bean.entity.Shape;

public interface ICountService<T extends Shape> {
    double counting (T shape);
}
