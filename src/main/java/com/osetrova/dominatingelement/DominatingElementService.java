package com.osetrova.dominatingelement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DominatingElementService {

    public Integer findDominatingElement(List<Integer> numbers) {
        Map<Integer, Integer> uniqueNumbers = new HashMap<>();
        int maxValue = 1;
        int maxKey = 0;

        for (Integer number : numbers) {
            Integer mergedValue = uniqueNumbers.merge(number, 1, (value, newValue) -> value + newValue);
            if (mergedValue > maxValue) {
                maxValue = mergedValue;
                if (maxKey != number) {
                    maxKey = number;
                }
            }
        }

        if (maxValue < numbers.size() / 2.0) {
            throw new RuntimeException("List doesn't have dominating element.");
        }

        return maxKey;
    }

    public Integer findDominatingElementByComparator(List<Integer> numbers) {
        Map<Integer, Integer> uniqueNumbers = new HashMap<>();

        for (Integer number : numbers) {
            uniqueNumbers.merge(number, 1, (value, newValue) -> value + newValue);
        }

        Integer key = uniqueNumbers.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("List doesn't have dominating element."))
                .getKey();

        if (uniqueNumbers.get(key) < numbers.size() / 2.0) {
            throw new RuntimeException("List doesn't have dominating element.");
        }

        return key;
    }
}
