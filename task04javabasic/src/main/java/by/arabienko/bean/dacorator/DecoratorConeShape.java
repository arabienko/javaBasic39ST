package by.arabienko.bean.dacorator;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.observer.ConeShapeEvent;
import by.arabienko.bean.observer.ConeShapeObserver;

public class DecoratorConeShape{
    protected ConeShape coneShape;
    private ConeShapeObserver observer;

    public DecoratorConeShape() {
        super();
    }

    public DecoratorConeShape(ConeShape coneShape) {
        this.coneShape = coneShape;
    }
   public void addObserver(ConeShapeObserver observer) {
        this.observer = observer;
        observer.addObservable(coneShape);
    }
    public void removeObserver() {
        observer.removeObservable(coneShape);
        observer = null;
    }
    private void notifyObservers() {
        if(observer != null) {
            observer.handleEvent(new ConeShapeEvent(coneShape));
        }
    }

    public void setHigh(double high) {
        coneShape.setHigh(high);
       notifyObservers();
    }

    public void setRadius(double radius) {
        coneShape.setRadius(radius);
        notifyObservers();
    }

    public void setY(double y) {
        notifyObservers();
    }
}
