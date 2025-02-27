package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {


    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 50);
        Product banana = new SimpleProduct("Банан", 30);
        Product orange = new SimpleProduct("Апельсин", 70);
        Product tomato = new SimpleProduct("Помидор", 50);
        Product product4 = new DiscountedProduct("Огурец", 20, 10);
        Product product5 = new FixPriceProduct("перец");
        Product product6 = new DiscountedProduct("Персик", 25, 20);



        System.out.println("basket1");
        ProductBasket basket1 = new ProductBasket();
        basket1.addProduct(apple);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(tomato);
        basket1.addProduct(product6);


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



        System.out.println(basket3.calcTotalPriceBasket());

        System.out.println("Есть ли в корзине Банан? " + basket3.containsProduct("Банан"));
        System.out.println("Есть ли в корзине Груша? " + basket3.containsProduct("Груша"));
    }


}
