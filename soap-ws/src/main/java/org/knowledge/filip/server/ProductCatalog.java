package org.knowledge.filip.server;

import java.util.*;

public class ProductCatalog {

    public List<String> getProductCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Books");
        categories.add("Music");
        categories.add("Movies");
        return categories;
    }
}
