package by.arabienko.task02javabasic.controller.command;


import by.arabienko.task02javabasic.controller.command.impl.MassiveCreatorArray;
import by.arabienko.task02javabasic.controller.command.impl.MatrixCreatorArray;

public class FactoryCreatorArray {

    private static final FactoryCreatorArray INSTANCE = new FactoryCreatorArray();

    private FactoryCreatorArray(){}

    public static FactoryCreatorArray getInstance(){
        return INSTANCE;
    }

    public static CreatorArray massiveService = new MassiveCreatorArray();

    public CreatorArray getMassiveService(){
        return massiveService;
    }

    public static CreatorArray matrixService = new MatrixCreatorArray();

    public CreatorArray getMatrixService(){
        return matrixService;
    }

}
