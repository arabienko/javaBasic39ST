package by.arabienko.task05thread.service.impl;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateMassiveImplFromFileTest {
    CreateMassiveImpl createMassiveFromFile = new CreateMassiveImpl();

    @Test
    public void testCreateArray() {
        List<String> list = new ArrayList<>();
        list.add("1 2 3 5 4 25 6");
        List actual = new ArrayList(Collections.singleton(new Number[]{1, 2, 3, 5, 4, 25, 6}));
        List expected = createMassiveFromFile.createArray(list);
        assertEqualsDeep(actual, expected);
    }

    private boolean assertEqualsDeep(List actual, List expected) {
        Number[] numActual = (Number[]) actual.get(0);
        Number[] numExpect = (Number[]) actual.get(0);
        for (int j = 0; j < numActual.length; j++) {
            if (numActual[j] != numExpect[j]) {
                return false;
            }
        }
        return true;
    }
}
