package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;


public abstract class Product implements Searchable {
    private  final String name;


    public Product(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }


    public boolean isSpecial() {
        return false;
    }

    public abstract int getPrice();


    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }
}


