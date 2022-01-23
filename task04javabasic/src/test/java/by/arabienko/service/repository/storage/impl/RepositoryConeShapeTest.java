package by.arabienko.service.repository.storage.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.store.ConeShapeStore;
import by.arabienko.service.parser.ParseDateToObjects;
import by.arabienko.service.reader.ReadFileTXT;
import by.arabienko.service.repository.specification.find.impl.*;
import by.arabienko.service.repository.specification.find.spec.ShapeFindSpecification;
import by.arabienko.service.repository.specification.sort.impl.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RepositoryConeShapeTest {
    RepositoryConeShape repositoryConeShape =
            RepositoryConeShape.getInstance();
    ConeShapeStore coneStore = new ConeShapeStore();

    static public Stream<Arguments> testArgumentsDataProviderForGet() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTXT");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<ConeShape> shapes =
                parseDateToObjects.parserDate(list1);
        ConeShape expected = shapes.get(0);
        ConeShape expected1 = null;
        return Stream.of(
                arguments(9l, expected),
                arguments(20l, expected1)

        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForGet")
    void getItem(Long key,
                 ConeShape expected) {
        ConeShape actual =
                repositoryConeShape.getElement(key);
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForAdd() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTXT");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<ConeShape> shapes =
                parseDateToObjects.parserDate(list1);
        ConeShape coneShape =
                new ConeShape("name", 1, 1, 1, 20, 20);
        List<ConeShape> expected = new ArrayList<>(shapes);
        expected.add(coneShape);
        ConeShape coneShape1 =
                new ConeShape("name1", 1, 1, 1, 20, 20);
        List<ConeShape> expected1 = new ArrayList<>(expected);
        expected1.add(coneShape1);
        List<ConeShape> expected3 = new ArrayList<>(shapes);
        return Stream.of(
                arguments(expected, coneShape),
                arguments(expected1, coneShape1),
                arguments(expected3, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForAdd")
    void addShape(List<ConeShape> expected,
                  ConeShape coneShape) {
        repositoryConeShape.addElement(coneShape);
        List<ConeShape> actual = coneStore.getStore();
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForUpdate() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTXT");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<ConeShape> shapes =
                parseDateToObjects.parserDate(list1);
        ConeShape coneShape = shapes.get(0);
        List<ConeShape> expected = new ArrayList<>(shapes);
        List<ConeShape> expected2 = new ArrayList<>(shapes);
        ConeShape coneShape1 = coneShape.clone();
        expected.remove(0);
        expected.add(coneShape);
        expected2.remove(0);
        coneShape1.setHigh(100);
        expected2.add(coneShape1);

        return Stream.of(
                arguments(expected, coneShape),
                arguments(expected2, coneShape1),
                arguments(expected, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForUpdate")
    void update(List<ConeShape> expected,
                ConeShape coneShape) {
        repositoryConeShape.updateElement(coneShape);
        List<ConeShape> actual = coneStore.getStore();
        assertEquals(expected, actual);
    }


    static public Stream<Arguments> testArgumentsDataProviderForRemove() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTXT");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<ConeShape> shapes =
                parseDateToObjects.parserDate(list1);
        ConeShape coneShape = shapes.get(0);
        shapes.remove(0);
        List<ConeShape> expected = new ArrayList<>(shapes);
        return Stream.of(
                arguments(expected, coneShape),
                arguments(expected, coneShape)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForRemove")
    void removeShape(List<ConeShape> expected,
                     ConeShape coneShape) {
        repositoryConeShape.removeElement(coneShape);
        List<ConeShape> actual = coneStore.getStore();
        assertEquals(expected, actual);
    }


    static public Stream<Arguments> testArgumentsDataProviderForSort() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<String> listRead =
                readFileJson.readFile("fileTestRepositoryConeShape");
        List<ConeShape> shapesRead =
                parseDateToObjects.parserDate(listRead);

        List<ConeShape> shapesSortHigh = new ArrayList<>();
        shapesSortHigh.add(shapesRead.get(3));
        shapesSortHigh.add(shapesRead.get(1));
        shapesSortHigh.add(shapesRead.get(2));
        shapesSortHigh.add(shapesRead.get(0));

        List<ConeShape> shapesSortRadius = new ArrayList<>();
        shapesSortRadius.add(shapesRead.get(1));
        shapesSortRadius.add(shapesRead.get(0));
        shapesSortRadius.add(shapesRead.get(3));
        shapesSortRadius.add(shapesRead.get(2));

        List<ConeShape> shapesSortX = new ArrayList<>();
        shapesSortX.add(shapesRead.get(2));
        shapesSortX.add(shapesRead.get(0));
        shapesSortX.add(shapesRead.get(1));
        shapesSortX.add(shapesRead.get(3));

        List<ConeShape> shapesSortName = new ArrayList<>();
        shapesSortName.add(shapesRead.get(3));
        shapesSortName.add(shapesRead.get(2));
        shapesSortName.add(shapesRead.get(1));
        shapesSortName.add(shapesRead.get(0));

        ConeShapeSortByCoordinateX coneShapeSortByCoordinateX =
                new ConeShapeSortByCoordinateX();
        Comparator comparatorX =
                coneShapeSortByCoordinateX.sortComparator();

        ConeShapeSortByHigh coneShapeSortByHigh =
                new ConeShapeSortByHigh();
        Comparator comparatorHigh =
                coneShapeSortByHigh.sortComparator();

        ConeShapeSortByRadius coneShapeSortByRadius =
                new ConeShapeSortByRadius();
        Comparator comparatorRadius =
                coneShapeSortByRadius.sortComparator();

        ConeShapeSortByName coneShapeSortByName =
                new ConeShapeSortByName();
        Comparator comparatorName =
                coneShapeSortByName.sortComparator();

        ConeShapeSortByID coneShapeSortByID =
                new ConeShapeSortByID();
        Comparator comparatorID =
                coneShapeSortByID.sortComparator();

        return Stream.of(
                arguments(shapesSortRadius, comparatorRadius),
                arguments(shapesSortX, comparatorX),
                arguments(shapesRead, comparatorID),
                arguments(shapesSortName, comparatorName),
                arguments(shapesSortHigh, comparatorHigh)
        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForSort")
    void sort(List<ConeShape> expected,
              Comparator comparator) {
        List<ConeShape> actual =
                RepositoryConeShape.getInstance().sort(comparator);
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForFind() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        List<String> listRead =
                readFileJson.readFile("fileTestRepositoryConeShape");
        List<ConeShape> shapesRead =
                parseDateToObjects.parserDate(listRead);

        ConeShapeFindByHighBetween highBetween =
                new ConeShapeFindByHighBetween(10, 15);
        List<ConeShape> shapesSortHigh = new ArrayList<>();
        shapesSortHigh.add(shapesRead.get(1));
        shapesSortHigh.add(shapesRead.get(2));

        ConeShapeFindByRadiusBetween coneShapeFindByRadiusBetween =
                new ConeShapeFindByRadiusBetween(1, 6);
        List<ConeShape> shapesSortRadius = new ArrayList<>();
        shapesSortRadius.add(shapesRead.get(0));
        shapesSortRadius.add(shapesRead.get(1));

        ConeShapeFindFirstQuarter findFirstQuarter =
                new ConeShapeFindFirstQuarter();
        List<ConeShape> shapesSortX = new ArrayList<>();
        shapesSortX.add(shapesRead.get(0));
        shapesSortX.add(shapesRead.get(1));

        ConeShapeFindByID coneShapeFindByID =
                new ConeShapeFindByID(2L);
        List<ConeShape> shapesSortID = new ArrayList<>();
        shapesSortID.add(shapesRead.get(2));

        ConeShapeFindByIDRange coneShapeFindByIDRange =
                new ConeShapeFindByIDRange(0, 2);
        List<ConeShape> shapesSortIDRange = new ArrayList<>();
        shapesSortIDRange.add(shapesRead.get(0));
        shapesSortIDRange.add(shapesRead.get(1));
        shapesSortIDRange.add(shapesRead.get(2));

        ConeShapeFindInRangeSurfaceAreas coneShapeFindInRangeSurfaceAreas =
                new ConeShapeFindInRangeSurfaceAreas(20, 300);
        List<ConeShape> shapesSortRangeSurfaceAreas = new ArrayList<>();
        shapesSortRangeSurfaceAreas.add(shapesRead.get(1));

        ConeShapeFindInRangeVolume coneShapeFindInRangeVolume =
                new ConeShapeFindInRangeVolume(10, 100);
        List<ConeShape> shapesSortRangeVolume = new ArrayList<>();
        shapesSortRangeVolume.add(shapesRead.get(1));
        shapesSortRangeVolume.add(shapesRead.get(3));

        ConeShapeFindByName coneShapeFindByName =
                new ConeShapeFindByName("cone12");
        List<ConeShape> shapesSortName = new ArrayList<>();
        shapesSortName.add(shapesRead.get(2));

        ConeShapeFindByName coneShapeFindByNameNull =
                new ConeShapeFindByName("cone");
        List<ConeShape> shapesSortNameNull = new ArrayList<>();
        shapesSortNameNull.add(null);


        return Stream.of(
                arguments(shapesSortRadius, coneShapeFindByRadiusBetween),
                arguments(shapesSortX, findFirstQuarter),
                arguments(shapesSortID, coneShapeFindByID),
                arguments(shapesSortIDRange, coneShapeFindByIDRange),
                arguments(shapesSortName, coneShapeFindByName),
                arguments(shapesSortRangeSurfaceAreas, coneShapeFindInRangeSurfaceAreas),
                arguments(shapesSortRangeVolume, coneShapeFindInRangeVolume),
                arguments(shapesSortHigh, highBetween),
                arguments(null, coneShapeFindByNameNull)
                );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForFind")
    void query(List<ConeShape> expected,
               ShapeFindSpecification specification) {
        List<ConeShape> actual =
                RepositoryConeShape.getInstance().query(specification);
        assertEquals(expected, actual);
    }
}