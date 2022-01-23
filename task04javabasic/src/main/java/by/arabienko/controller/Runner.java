package by.arabienko.controller;

import by.arabienko.creator.store.CreatorConeShapeStore;
import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.RegistrarShape;
import by.arabienko.bean.store.RegistrarConeStore;
import by.arabienko.service.parser.ParseDateToObjects;
import by.arabienko.service.reader.ReadFileTXT;
import by.arabienko.service.repository.specification.find.impl.ConeShapeFindFirstQuarter;
import by.arabienko.service.repository.specification.find.impl.ConeShapeFindInRangeSurfaceAreas;
import by.arabienko.service.repository.specification.find.spec.AndSpecification;
import by.arabienko.service.repository.specification.find.spec.ShapeFindSpecification;
import by.arabienko.service.repository.specification.sort.impl.ConeShapeSortByID;
import by.arabienko.service.repository.specification.sort.impl.ConeShapeSortByName;
import by.arabienko.service.repository.storage.impl.RepositoryConeShape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class Runner {
    public static void main(String[] args){
        CreatorConeShapeStore creator = new CreatorConeShapeStore();
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1  = readFileJson.readFile("fileTXT");
       /* ReadFileJson readFileJson1 = new ReadFileJson();
        List<String> list = readFileJson1.readFile("fileJson");*/
        ParseDateToObjects parseDateToObjects = new ParseDateToObjects();
        List<ConeShape> shapes = parseDateToObjects.parserDate(list1);
       // System.out.println("shapes "+shapes+"   "+shapes.size());

       // System.out.println("storage - "+creator.factoryMethodStorage().toString());

        ConeShapeSortByID coneShapeSortByID = new ConeShapeSortByID();
        Comparator comparator = coneShapeSortByID.sortComparator();
        ConeShapeSortByName coneShapeSortByName = new ConeShapeSortByName();
        Comparator comparator2 = coneShapeSortByName.sortComparator();
       // System.out.println("sort "+RepositoryConeShape.getInstance().sort(comparator2));
      //  System.out.println("ID "+RepositoryConeShape.getInstance().sort(comparator));


       // shapes.stream().sorted(comparator);
        List<ConeShape> coneShapes = new ArrayList<>(shapes);
        System.out.println("parse" + coneShapes);
        /*coneShapes.sort(comparator2);
        System.out.println(coneShapes);*/
        RegistrarConeStore registrarConeStore = new RegistrarConeStore();
        List<RegistrarShape>registrarShapes = registrarConeStore.getStore();
       // System.out.println(registrarShapes);
        //coneShapes.get(0).setHigh(5);
       // coneShapes.get(2).setRadius(50);
       // coneShapes.get(1).setY(10);
        List<RegistrarShape>registrarShapes1 = registrarConeStore.getStore();
       // System.out.println(registrarShapes1.equals(registrarShapes));
      // System.out.println(registrarShapes1);
        ShapeFindSpecification specification = new ConeShapeFindFirstQuarter();
        List<ConeShape>coneShapeList3 = RepositoryConeShape.getInstance().query(specification);
        System.out.println(coneShapeList3);
        ShapeFindSpecification specification1 = new ConeShapeFindInRangeSurfaceAreas(20, 300);
        List<ConeShape>coneShapeList = RepositoryConeShape.getInstance().query(specification1);
        System.out.println();
        System.out.println(coneShapeList+"   ");
        ShapeFindSpecification findSpecification = new AndSpecification(specification,specification1);
        System.out.println();
        List<ConeShape>coneShapeList2 = RepositoryConeShape.getInstance().query(findSpecification);
        System.out.println(coneShapeList2);
        }
}
