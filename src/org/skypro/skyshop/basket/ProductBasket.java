package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {

    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;

    }


    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        System.out.println("ProductBasket.addProduct" + product);
        if (count < products.length) {
            products[count] = product;
            count++;
        } else System.out.println("Невозможно добавить продукт: корзина переполнена!");
    }


    //Метод получения общей стоимости корзины
    public int calcTotalPriceBasket() {
        System.out.println();
        System.out.println("ProductBasket.calcTotalPriceBasket");
        int totalPrice = 0;
        for (int i = 0; i < count; i++) {
            totalPrice += products[i].getPrice();
        }
                return totalPrice;
    }

    //Метод, который печатает содержимое корзины
    public void printProductInBasket() {
        System.out.println();
        System.out.println("ProductBasket.printProductInBasket");
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < count; i++) {

            System.out.println(products[i].getName() + ":" + products[i].getPrice());
                   }
        System.out.println("Итого " + calcTotalPriceBasket());

    }

    // Метод проверки наличия продукта в корзине по имени
    public boolean containsProduct(String productName) {

        System.out.println();
        System.out.println("ProductBasket.containsProduct");
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины
    public void clearBasket() {
        System.out.println("ProductBasket.clearBasket");
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
        System.out.println("Корзина очищена.");
    }
}

