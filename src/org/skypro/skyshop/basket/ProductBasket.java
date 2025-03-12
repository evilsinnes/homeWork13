package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    private List<Product> products;


    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        System.out.println("ProductBasket.addProduct" + product);
        products.add(product);
    }

    public int getTotalPrice() {
        System.out.println();
        System.out.println("ProductBasket.getTotalPrice");
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;

    }

    public void printProductInBasket() {
        System.out.println("ProductBasket.printProductInBasket");
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;

        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }

        }
        System.out.println("Итого " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        System.out.println();
        System.out.println("ProductBasket.containsProduct");
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        System.out.println("ProductBasket.clearBasket");
        products.clear();
        System.out.println("Корзина очищена.");
    }

    public List<Product> removeProductByName (String name){
        List<Product> removedProducts = new ArrayList<>();
    Iterator<Product> iterator = products.iterator();
    while (iterator.hasNext()) {
        Product product = iterator.next();
        if (product.getName().equals(name)){
            removedProducts.add(product);
            iterator.remove();
        }
    }
    return removedProducts;
    }
}

