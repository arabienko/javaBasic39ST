package by.arabienko.bean.entity;

import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.CommandCountSurfaceArea;
import by.arabienko.controller.command.impl.CommandCountVolume;
import by.arabienko.controller.command.impl.CommandRatioVolumesFigureByPlane;

import java.util.Objects;

/**
 * Registrar class for storing
 * the calculated parameters of the cone.
 */
public class RegistrarShape implements Registrar{
    private Long ID;
    private double volume;
    private double surfaceArea;
    private double ratioVolumes;

    public RegistrarShape(Long ID, double volume,
                          double surfaceArea,
                          double ratioVolumes) {
        this.ID = ID;
        this.volume = volume;
        this.surfaceArea = surfaceArea;
        this.ratioVolumes = ratioVolumes;
    }


    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getRatioVolumes() {
        return ratioVolumes;
    }

    public void setRatioVolumes(double ratioVolumes) {
        this.ratioVolumes = ratioVolumes;
    }

    @Override
    public Long getID() {
        return ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        RegistrarShape that = (RegistrarShape) o;
        return Double.compare(that.volume, volume)==0
                && Double.compare(that.surfaceArea, surfaceArea)==0
                && Double.compare(that.ratioVolumes, ratioVolumes)==0
                && Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, surfaceArea,
                ratioVolumes, ID);
    }

    @Override
    public String toString() {
        return "RegistrarShape{" +
                "capacity=" + volume +
                ", surface Area=" + surfaceArea +
                ", ratio Volumes=" + ratioVolumes +
                ", ID=" + ID +
                '}';
    }
}
