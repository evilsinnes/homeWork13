package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {


    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 30);
        Product orange = new Product("Апельсин", 70);
        Product tomato = new Product("Помидор", 50);
        Product product4 = new Product("Огурец", 20);
        Product product5 = new Product("перец", 10);
        Product product6 = new Product("product6", 25);


        System.out.println("basket1");
        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(apple);
        basket1.addProduct(banana);
        basket1.addProduct(orange);
        basket1.addProduct(tomato);
        // basket1.addProduct(cucumber);


        basket1.printProductInBasket();

        System.out.println("Есть ли в корзине Банан? " + basket1.containsProduct("Банан"));
        System.out.println("Есть ли в корзине Груша? " + basket1.containsProduct("Груша"));

        basket1.clearBasket();
        basket1.printProductInBasket();


        System.out.println();
        System.out.println("basket2");
        ProductBasket basket2 = new ProductBasket();

        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);
        basket2.addProduct(apple);


        System.out.println();
        System.out.println("basket3");
        ProductBasket basket3 = new ProductBasket();
        basket3.printProductInBasket();

        System.out.println("Есть ли в корзине Банан? " + basket1.containsProduct("Банан"));
        System.out.println("Есть ли в корзине Груша? " + basket1.containsProduct("Груша"));

        System.out.println(basket3.calcTotalPriceBasket());
    }


}
