package by.arabienko.task02javabasic.controller.command;

import by.arabienko.task02javabasic.service.*;
import by.arabienko.task02javabasic.service.impl.*;

/**
 * A factory for creating a single instance for services.
 */
public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {}

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }

    private final CreateArrayService massiveService = new CreateMassiveImpl();
    private final CreateArrayService matrixService = new CreateMatrixImpl();

    public CreateArrayService getMassiveService(){ return massiveService; }

    public CreateArrayService getMatrixService(){
        return matrixService;
    }

    private final FileReadService fileReadService = new ReadFileImpl();

    public FileReadService getFileReadService() {
        return fileReadService;
    }

    private final MatrixOperationService matrixSum = new MatrixSumImpl();

    public MatrixOperationService getMatrixSum() {
        return matrixSum;
    }

    private final MatrixOperationService matrixMultiply = new MatrixMultiplyImpl();

    public MatrixOperationService getMatrixMultiply() {
        return matrixMultiply;
    }

    private final MatrixOperationService matrixSubtraction = new MatrixSubtractionImpl();

    public MatrixOperationService getMatrixSubtraction() {
        return matrixSubtraction;
    }

    private final SaveToFileService saveMassiveToFile = new SaveMassiveToFileImpl();
    private final SaveToFileService saveMatrixToFile = new SaveMatrixToFileImpl();

    public SaveToFileService getSaveMassiveToFile(){
        return saveMassiveToFile;
    }

    public SaveToFileService getSaveMatrixToFile(){
        return saveMatrixToFile;
    }

    private final SortDateFileService sortDateService = new FileSortImpl();

    public SortDateFileService getSortDateService(){
        return sortDateService;
    }

    private final SortMassiveService sortMassiveExchange = new ExchangeSortMassiveImpl();

    public SortMassiveService getSortMassiveExchange(){
        return sortMassiveExchange;
    }

    private final SortMassiveService sortMassiveMerge = new MergeSortMassiveImpl();

    public SortMassiveService getSortMassiveMerge(){
        return sortMassiveMerge;
    }

    private final SortMassiveService sortMassiveInsertion = new InsertionSortMassiveImpl();

    public SortMassiveService getSortMassiveInsertion(){
        return sortMassiveInsertion;
    }

    private final SortMassiveService sortMassiveShaker = new ShakerSortMassiveImpl();

    public SortMassiveService getSortMassiveShaker(){
        return sortMassiveShaker;
    }

    private final SortMassiveService sortMassiveShell = new ShellSortMassiveImpl();

    public SortMassiveService getSortMassiveShell(){
        return sortMassiveShell;
    }

    private final SortMassiveService sortMassiveSimple = new SimpleSelectSortMassiveImpl();

    public SortMassiveService getSortMassiveSimple(){
        return sortMassiveSimple;
    }

}
