package com.osetrova.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortOddNumbersService {

    public void sortOddNumbersOnly(int[] numbers) {
        List<Integer> indexes = new ArrayList<>();
        Queue<Integer> oddNumbers = new PriorityQueue<>();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                indexes.add(i);
                oddNumbers.add(numbers[i]);
            }
        }

        indexes.forEach(x -> numbers[x] = oddNumbers.remove());
    }
}
