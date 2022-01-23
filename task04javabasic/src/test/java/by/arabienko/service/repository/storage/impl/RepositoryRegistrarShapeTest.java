package by.arabienko.service.repository.storage.impl;

import by.arabienko.bean.entity.RegistrarShape;
import by.arabienko.bean.store.RegistrarConeStore;
import by.arabienko.creator.store.CreatorConeShapeStore;
import by.arabienko.service.parser.ParseDateToObjects;
import by.arabienko.service.reader.ReadFileTXT;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RepositoryRegistrarShapeTest {

    static RepositoryRegistrarShape registrarShape =
            RepositoryRegistrarShape.getInstance();
    static RegistrarConeStore store =
            new CreatorConeShapeStore().
            createRegistrarStore();

    static public Stream<Arguments> testArgumentsDataProviderForGet() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTestRepositoryConeShape");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        parseDateToObjects.parserDate(list1);
        List<RegistrarShape> registrarShapes =
                store.getStore();

        return Stream.of(
                arguments(1l, registrarShapes.get(1)),
                arguments(3l, registrarShapes.get(3)),
                arguments(5l, null)

        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForGet")
    void getItem(Long key,
                 RegistrarShape expected) {
        RegistrarShape actual =
                registrarShape.getElement(key);
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForAdd() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTestRepositoryConeShape");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        parseDateToObjects.parserDate(list1);
        List<RegistrarShape> list = store.getStore();
        List<RegistrarShape> registrarShapes = new ArrayList<>(list);
        RegistrarShape shape =
                new RegistrarShape(10L, 50, 50, 50);
        RegistrarShape shape1 = store.getStore().get(0);
        registrarShapes.add(shape);


        return Stream.of(
                arguments(shape, registrarShapes),
                arguments(shape1, registrarShapes),
                arguments(null, registrarShapes)

        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForAdd")
    void add(RegistrarShape shape,
             List<RegistrarShape> expected) {
        registrarShape.addElement(shape);
        List<RegistrarShape> actual = store.getStore();
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForRemove() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTestRepositoryConeShape");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        parseDateToObjects.parserDate(list1);
        List<RegistrarShape> list = store.getStore();
        List<RegistrarShape> registrarShapes = new ArrayList<>(list);
        RegistrarShape shape =
                new RegistrarShape(10L, 50, 50, 50);
        RegistrarShape shape1 = store.getStore().get(0);
        registrarShapes.remove(shape1);


        return Stream.of(
                arguments(shape, list),
                arguments(shape1, registrarShapes),
                arguments(null, registrarShapes)

        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForRemove")
    void remove(RegistrarShape shape,
                List<RegistrarShape> expected) {
        registrarShape.removeElement(shape);
        List<RegistrarShape> actual = store.getStore();
        assertEquals(expected, actual);
    }

    static public Stream<Arguments> testArgumentsDataProviderForUpdate() {
        ReadFileTXT readFileJson = new ReadFileTXT();
        List<String> list1 =
                readFileJson.readFile("fileTestRepositoryConeShape");
        ParseDateToObjects parseDateToObjects =
                new ParseDateToObjects();
        parseDateToObjects.parserDate(list1);
        List<RegistrarShape> list = store.getStore();
        list.remove(1);
        RegistrarShape registrarShape =
                new RegistrarShape(1L, 3, 1, 1);
        list.add(registrarShape);
        RegistrarShape registrarShape2 =
                new RegistrarShape(10L, 3, 1, 1);

        return Stream.of(
                arguments(registrarShape, list),
                arguments(null, list),
                arguments(registrarShape2, list)

        );
    }

    @ParameterizedTest
    @MethodSource("testArgumentsDataProviderForUpdate")
    void update(RegistrarShape shape,
                List<RegistrarShape> expected) {
        registrarShape.updateElement(shape);
        List<RegistrarShape> actual = store.getStore();
        assertEquals(expected, actual);
    }
}