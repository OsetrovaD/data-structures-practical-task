package com.osetrova.anagram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

public class AnagramService {

    public List<TreeSet<String>> findAnagrams(String... strings) {
        Map<String, TreeSet<String>> anagrams = new LinkedHashMap<>();

        for (String string : strings) {
            if (!anagrams.isEmpty()) {
                Optional<String> optional = anagrams.keySet().stream()
                        .filter(x -> isAnagram(x, string))
                        .findFirst();
                if (optional.isPresent()) {
                    anagrams.get(optional.get()).add(string);
                    continue;
                }
            }
            anagrams.put(string, new TreeSet<String>(Comparator.naturalOrder()) {
                {
                    this.add(string);
                }
            });
        }

        return new ArrayList<>(anagrams.values());
    }

    private boolean isAnagram(String mainString, String checkedString) {
        boolean result = true;
        if (mainString.length() == checkedString.length()) {
            for (int i = 0; i < mainString.length(); i++) {
                if (checkedString.indexOf(mainString.charAt(i)) < 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }

        return result;
    }
}
