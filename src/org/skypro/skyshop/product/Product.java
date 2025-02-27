package org.skypro.skyshop.product;

public abstract class Product {
    private String name;
    // private int price;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpecial() {
        return false;
    }

    public abstract int getPrice();


    @Override
    public String toString() {
        return " " + name + '\'' + getPrice();
    }
}

