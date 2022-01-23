package by.arabienko.bean.entity;

import by.arabienko.bean.observer.ConeShapeEvent;
import by.arabienko.bean.observer.ConeShapeObserver;
import java.util.Objects;

/**
 * Entity Cone.
 *The object is constructed
 * from a point (center of the base),
 * a radius of the base, and a height.
 */
public class ConeShape extends Point implements Cloneable{

    private static long counter;
    private final Long ID = counter++;
    private double high;
    private double radius;
    private String nameShape;
    private ConeShapeObserver observer;

    public ConeShape(String nameShape, double x,
                     double y, double z,
                     double high, double radius) {
        super(x, y, z);
        this.nameShape = nameShape;
        this.high = high;
        this.radius = radius;
    }

    public Long getID() {
        return ID;
    }

    public double getHigh() {
        return high;
    }

    public double getRadius() {
        return radius;
    }

    public void setHigh(double high){
        this.high = high;
        notifyObservers();
    }

    public void setRadius(double radius){
        this.radius = radius;
       notifyObservers();
    }

    public void setY(double y) {
        super.setY(y);
        notifyObservers();
    }

   public String getNameShape() {
        return nameShape;
    }

    public void addObserver(ConeShapeObserver observer) {
        this.observer = observer;
        observer.addObservable(this);
    }
    public void removeObserver() {
        observer.removeObservable(this);
        observer = null;
    }
    private void notifyObservers() {
        if(observer != null) {
            observer.handleEvent(
                    new ConeShapeEvent(this));
        }
    }
    @Override
    public void draw() {

    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConeShape coneShape = (ConeShape) o;
        return Double.compare(coneShape.high, high)==0
                && Double.compare(coneShape.radius, radius)==0
                && coneShape.ID==ID
                && coneShape.nameShape.equals(nameShape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                ID, high, radius, nameShape);
    }

    @Override
    public String toString() {
        return "ConeShape{" +
                "name= " + nameShape +
                ", ID='" + ID + '\'' +
                ", " + super.toString() +
                ", high=" + high +
                ", radius=" + radius +
                '}';
    }

    @Override
    public ConeShape clone() {
        try {
            ConeShape clone = (ConeShape) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
