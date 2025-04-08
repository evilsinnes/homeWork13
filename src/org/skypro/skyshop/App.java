package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class App {


    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Яблоко", 50));
        basket.addProduct(new DiscountedProduct("Банан", 100, 20));
        basket.addProduct(new FixPriceProduct("Апельсин"));
        System.out.println("\nСодержимое корзины:");
        basket.printProductInBasket();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Яблоко", 50));
        searchEngine.add(new DiscountedProduct("Банан", 100, 20));
        searchEngine.add(new Article("Как выбрать яблоко", "Выбирайте свежие и сочные яблоки."));
        searchEngine.add(new Article("Польза бананов", "О полезных свойствах"));

        System.out.println("Результаты поиска по запросу 'яблоко':");
        searchEngine.search("яблоко").forEach(System.out::println);

        System.out.println("\nРезультаты поиска по запросу 'банан':");
        searchEngine.search("банан").forEach(System.out::println);

    }
}




















