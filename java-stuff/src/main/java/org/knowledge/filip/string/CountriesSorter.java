package org.knowledge.filip.string;

import java.util.*;

public class CountriesSorter {
    private List<String> countries;

    public CountriesSorter(List<String> countries) {
        Collections.sort(countries, (o1, o2) -> {
            if (o1.equals("RO")) {
                return -1;
            } else if (o2.equals("RO")) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });
        this.countries = countries;
    }

    public List<String> sortLeCountries() {
        return countries;
    }
}
