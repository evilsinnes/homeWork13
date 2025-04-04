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

        Set<Searchable> results = searchEngine.search("яблоко");
        System.out.println("Результаты поиска (отсортированы по длине названия и имени):");
        results.forEach(item ->
                System.out.println(item.getStringRepresentation())
        );
    }
}



















//        List<Product> removedProducts = basket.removeProductByName("Банан");
//        System.out.println("\nУдаленные продукты:");
//        for (Product product : removedProducts) {
//            System.out.println(product);
//        }
//        System.out.println("\nСодержимое корзины после удаления:");
//        basket.printProductInBasket();
//
//
//        removedProducts = basket.removeProductByName("Груша");
//        if (removedProducts.isEmpty()) {
//            System.out.println("\nСписок удаленных продуктов пуст.");
//        }
//        System.out.println("\nСодержимое корзины после попытки удаления:");
//        basket.printProductInBasket();
//
//        SearchEngine searchEngine = new SearchEngine();
//        searchEngine.add(new SimpleProduct("Яблоко", 50));
//        searchEngine.add(new DiscountedProduct("Банан", 100, 20));
//        searchEngine.add(new Article("Как выбрать яблоки", "Выбирайте свежие и сочные яблоки."));
//
//        List<Searchable> results = searchEngine.search("яблоко");
//        System.out.println("Результаты поиска по запросу 'яблоко':");
//        for (Searchable result : results) {
//            System.out.println(result.getStringRepresentation());
//        }
//        try {
//            var bestMatch = searchEngine.findBestMatch("яблоко");
//            System.out.println("\nНайден лучший результат: " + bestMatch.getStringRepresentation());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//}

//        SearchEngine searchEngine = new SearchEngine(10);
//
//                searchEngine.add(new SimpleProduct("Яблоко", 50));
//        searchEngine.add(new DiscountedProduct("Банан", 100, 20));
//        searchEngine.add(new Article("Как выбрать яблоки", "Выбирайте свежие и сочные яблоки."));
//
//
//        try {
//            var bestMatch = searchEngine.findBestMatch("яблоко");
//            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//
//        try {
//            var bestMatch = searchEngine.findBestMatch("апельсин");
//            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//
//        try {
//            // Неправильное название (пустая строка)
//            Product invalidProduct = new SimpleProduct("", 100);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//        try {
//            // Неправильная цена (0)
//            Product invalidPrice = new SimpleProduct("Яблоко", 0);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//
//        try {
//            // Неправильная скидка (101)
//            Product invalidDiscount = new DiscountedProduct("Банан", 100, 101);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//}

//    ProductBasket basket = new ProductBasket();
//
//       Product apple = new SimpleProduct("яблоко", 50);
//       Product banana = new DiscountedProduct("банан", 100, 20);
//       Product orange = new SimpleProduct("апельсин", 70);
//       Product tomato = new SimpleProduct("помидор", 50);
//       Product product4 = new DiscountedProduct("огурец", 20, 10);
//       Product product5 = new FixPriceProduct("перец");
//       Product product6 = new DiscountedProduct("персик", 25, 20);
//
//
//        Product apple = new SimpleProduct("яблоко", 50);
//        Product banana = new DiscountedProduct("банан", 100, 20);
//        Product orange = new SimpleProduct("апельсин", 70);
//        Product tomato = new SimpleProduct("помидор", 50);
//        Product product4 = new DiscountedProduct("огурец", 20, 10);
//        Product product5 = new FixPriceProduct("перец");
//        Product product6 = new DiscountedProduct("персик", 25, 20);
//
//        basket.printProductInBasket();
//        Article article1 = new Article("Как выбрать яблоки", "Выбирайте свежие и сочные яблоки.");
//        Article article2 = new Article("Польза бананов", "Бананы богаты калием и полезны для здоровья.");
//
//
//        SearchEngine searchEngine = new SearchEngine(10);
//
//
//        searchEngine.add(apple);
//        searchEngine.add(banana);
//        searchEngine.add(orange);
//        searchEngine.add(article1);
//        searchEngine.add(article2);
//
//
//        System.out.println("\nРезультаты поиска по запросу 'яблоко':");
//        Searchable[] results = searchEngine.search("яблоко");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }
//
//        System.out.println("\nРезультаты поиска по запросу 'банан':");
//        results = searchEngine.search("банан");
//        for (Searchable result : results) {
//            if (result != null) {
//                System.out.println(result.getStringRepresentation());
//            }
//        }
//
//
//        System.out.println("Есть ли в корзине банан? " + basket.containsProduct("банан"));
//        System.out.println("Есть ли в корзине груша? " + basket.containsProduct("груша"));
//
//
//
//
//        System.out.println();
//        System.out.println("basket2");
//        ProductBasket basket2 = new ProductBasket();
//
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//        basket2.addProduct(apple);
//
//
//        System.out.println();
//        System.out.println("basket3");
//        ProductBasket basket3 = new ProductBasket();
//        basket3.printProductInBasket();
//
//
//
//        System.out.println(basket3.calcTotalPriceBasket());
//
//        System.out.println("Есть ли в корзине банан? " + basket3.containsProduct("банан"));
//        System.out.println("Есть ли в корзине груша? " + basket3.containsProduct("груша"));
//    }
//}


