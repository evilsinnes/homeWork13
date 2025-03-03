package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


public class App {


    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("яблоко", 50);
        Product banana = new DiscountedProduct("банан", 100, 20);
        Product orange = new SimpleProduct("апельсин", 70);
        Product tomato = new SimpleProduct("помидор", 50);
        Product product4 = new DiscountedProduct("огурец", 20, 10);
        Product product5 = new FixPriceProduct("перец");
        Product product6 = new DiscountedProduct("персик", 25, 20);


        basket.addProduct(apple);
        basket.addProduct(product4);
        basket.addProduct(banana);



        basket.printProductInBasket();
        Article article1 = new Article("Как выбрать яблоки", "Выбирайте свежие и сочные яблоки.");
        Article article2 = new Article("Польза бананов", "Бананы богаты калием и полезны для здоровья.");

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары и статьи в поисковый движок
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрация поиска
        System.out.println("\nРезультаты поиска по запросу 'яблоко':");
        Searchable[] results = searchEngine.search("яблоко");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }

        System.out.println("\nРезультаты поиска по запросу 'банан':");
        results = searchEngine.search("банан");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }


        System.out.println("Есть ли в корзине банан? " + basket.containsProduct("банан"));
        System.out.println("Есть ли в корзине груша? " + basket.containsProduct("груша"));




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

        System.out.println("Есть ли в корзине банан? " + basket3.containsProduct("банан"));
        System.out.println("Есть ли в корзине груша? " + basket3.containsProduct("груша"));
    }


}
