package org.knowledge.filip.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class TestString {

    @Test
    public void sortAlphabetically() {
        List<String> actual = Arrays.asList("GB", "RO", "FR", "GE", "DN", "EN");
        List<String> expected = Arrays.asList("RO", "DN", "EN", "FR", "GB", "GE");

        System.out.println("Unsorted countries:\t" + actual);
        CountriesSorter countriesSorter = new CountriesSorter(actual);
        System.out.println("Sorted countries:\t" + countriesSorter.sortLeCountries());
        Assert.assertEquals(countriesSorter.sortLeCountries(), expected);
    }

    @Test
    public void sortAlphabeticallyWithDuplicates() {
        List<String> actual = Arrays.asList("GB", "RO", "GB", "FR", "GE", "RO", "DN", "EN");
        List<String> expected = Arrays.asList("RO", "RO", "DN", "EN", "FR", "GB", "GB", "GE");

        System.out.println("Unsorted countries:\t" + actual);
        CountriesSorter countriesSorter = new CountriesSorter(actual);
        System.out.println("Sorted countries:\t" + countriesSorter.sortLeCountries());
        Assert.assertEquals(countriesSorter.sortLeCountries(), expected);
    }
}
