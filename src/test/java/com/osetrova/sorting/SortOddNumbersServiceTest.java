package com.osetrova.sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortOddNumbersServiceTest {

    private SortOddNumbersService service = new SortOddNumbersService();

    @Test
    public void checkSortOddNumbersOnly() {
        int[] numbers = {5, 7, 2, 8, 1, 4};
        service.sortOddNumbersOnly(numbers);

        int[] expected = {1, 5, 2, 8, 7, 4};
        assertArrayEquals(expected, numbers);
    }
}
