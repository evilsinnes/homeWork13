package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();




    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
                return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();

    }
    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }
    public void printProductInBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
        System.out.println("Корзина очищена.");
    }

    public List<Product> removeProductByName(String name) {
               return Optional.ofNullable(productsMap.remove(name))
                       .orElse(Collections.emptyList());
    }

}

