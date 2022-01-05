package by.arabienko.task02javabasic.service;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.impl.SortingMassive;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortingMassiveTest {
    SortingMassive sortingMassive = new SortingMassive();


    @DataProvider(name = "massive for sorting")
    public Object[][] dateSortMassive() {
        return new Object[][]{
                new Object[]{new Number[]{1, 2, 3}, new Number[]{1, 2, 3}},
                {new Number[]{7, 6, 5, 4, 3, 2, 1}, new Number[]{1, 2, 3, 4, 5, 6, 7}},
                {new Number[]{-1, 1, -1, 1, -1, 1}, new Number[]{-1, -1, -1, 1, 1, 1}},
                {new Number[]{5, 8, -9, 2, 0, 45.2, 12, -9, 20}, new Number[]{-9, -9, 0, 2, 5, 8, 12, 20, 45.2}},
                {new Number[]{0}, new Number[]{0}},
                {new Number[]{1, 1, 1}, new Number[]{1, 1, 1}},
                {new Double[]{7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0}, new Double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0}},
        };
    }


    @Test(description = "positive scenario for exchange testing sorting massive",
            dataProvider = "massive for sorting")
    public void testExchangeSortMassive(Number[] arg, Number[] argResult) throws ServiceException {

        Massive massive =
                new Massive(arg);

        Massive massive1 =
                new Massive(argResult);

        sortingMassive.exchangeSortMassive(massive);
        assertEquals(massive, massive1);
    }

    @Test(description = "positive scenario for shaker testing sorting massive",
            dataProvider = "massive for sorting")
    public void testShakerSortMassive(Number[] arg, Number[] argResult) throws ServiceException {

        Massive massive =
                new Massive(arg);

        Massive massive1 =
                new Massive(argResult);
        sortingMassive.shakerSortMassive(massive);
        assertEquals(massive, massive1);
    }

    @Test(description = "positive scenario for simple select testing sorting massive",
            dataProvider = "massive for sorting")
    public void testSimpleSelectSortMassive(Number[] arg, Number[] argResult) throws ServiceException {

        Massive massive =
                new Massive(arg);

        Massive massive1 =
                new Massive(argResult);
        sortingMassive.simpleSelectSortMassive(massive);
        assertEquals(massive, massive1);
    }

    @Test(description = "positive scenario for simple select testing sorting massive",
            dataProvider = "massive for sorting")
    public void testInsertionSortMassive(Number[] arg, Number[] argResult) throws ServiceException {

        Massive massive =
                new Massive(arg);

        Massive massive1 =
                new Massive(argResult);
        sortingMassive.simpleSelectSortMassive(massive);
        assertEquals(massive, massive1);
    }

    @Test(description = "positive scenario for merge testing sorting massive",
            dataProvider = "massive for sorting")
    public void testMergeSortMassive(Number[] arg, Number[] argResult) throws ServiceException {
        Massive massive =
                new Massive(arg);
        Massive massive1 =
                new Massive(argResult);
        System.out.println(massive);
        sortingMassive.simpleSelectSortMassive(massive);
        System.out.println(massive);
        System.out.println(massive1);
        assertEquals(massive, massive1);
    }

    @Test(description = "positive scenario for Shell testing sorting massive",
            dataProvider = "massive for sorting")
    public void testShellSortMassive(Number[] arg, Number[] argResult) throws ServiceException {
        Massive massive =
                new Massive(arg);

        Massive massive1 =
                new Massive(argResult);
        sortingMassive.shellSortMassive(massive);
        assertEquals(massive, massive1);
    }
}
