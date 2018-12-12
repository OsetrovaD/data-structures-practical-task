package com.osetrova.dominatingelement;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DominatingElementServiceTest {

    private DominatingElementService service = new DominatingElementService();

    @Test(expected = RuntimeException.class)
    public void checkExceptionByFindDominatingElement() {
        List<Integer> integers = Arrays.asList(10, 9, 9, 9, 8, 8, 10);

        service.findDominatingElement(integers);
    }

    @Test(expected = RuntimeException.class)
    public void checkExceptionByFindDominatingElementByComparator() {
        List<Integer> integers = Arrays.asList(10, 10, 9, 9, 9, 8, 8, 10);

        service.findDominatingElementByComparator(integers);
    }

    @Test
    public void checkFindDominatingElement() {
        List<Integer> integers = Arrays.asList(10, 9, 9, 9, 10);

        Integer dominatingElement = service.findDominatingElement(integers);

        Assert.assertEquals(Integer.valueOf(9), dominatingElement);
    }

    @Test
    public void checkFindDominatingElementByComparator() {
        List<Integer> integers = Arrays.asList(2, 2, 1, 1, 1, 2, 2);

        Integer dominatingElement = service.findDominatingElement(integers);

        Assert.assertEquals(Integer.valueOf(2), dominatingElement);
    }
}
