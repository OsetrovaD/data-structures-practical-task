package com.osetrova.anagram;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class AnagramServiceTest {

    private AnagramService service = new AnagramService();

    @Test
    public void checkFindAnagrams() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<TreeSet<String>> anagrams = service.findAnagrams(strings);

        List<TreeSet<String>> expectedAnagrams = new ArrayList<>();
        expectedAnagrams.add(new TreeSet<String>() {
            {
                this.add("eat");
                this.add("tea");
                this.add("ate");
            }
        });

        expectedAnagrams.add(new TreeSet<String>() {
            {
                this.add("tan");
                this.add("nat");
            }
        });

        expectedAnagrams.add(new TreeSet<String>() {
            {
                this.add("bat");
            }
        });

        assertEquals(expectedAnagrams, anagrams);
    }
}
