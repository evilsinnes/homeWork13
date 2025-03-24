package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productsMap;


    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        System.out.println("Добавить продукт" + product);
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        System.out.println();
        System.out.println("ProductBasket.getTotalPrice");
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();

    }

    public void printProductInBasket() {

        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;

        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                System.out.println(product);

                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        System.out.println("ProductBasket.clearBasket");
        productsMap.clear();
        System.out.println("Корзина очищена.");
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }

}

