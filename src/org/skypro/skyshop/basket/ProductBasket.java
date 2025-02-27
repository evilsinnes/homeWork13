package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] products;
    private int count;


    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;

    }

    public void addProduct(Product product) {
        System.out.println("ProductBasket.addProduct" + product);
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт: корзина переполнена!");
        }
    }

    public int calcTotalPriceBasket() {
        System.out.println();
        System.out.println("ProductBasket.calcTotalPriceBasket");
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;

    }

    public void printProductInBasket() {
        System.out.println();
        System.out.println("ProductBasket.printProductInBasket");
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()){
                    specialCount++;
                }
            }

        }
        System.out.println("Итого " + calcTotalPriceBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String productName) {
        System.out.println();
        System.out.println("ProductBasket.containsProduct");
        if (productName == null) {
            return false;
        }

        for (Product product : products) {
            if (product != null && product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        System.out.println("ProductBasket.clearBasket");
        for (Product product : products) {
            products = null;
        }
        count = 0;
        System.out.println("Корзина очищена.");
    }
}

