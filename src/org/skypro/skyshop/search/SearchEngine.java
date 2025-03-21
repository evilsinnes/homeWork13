package org.skypro.skyshop.search;

public class SearchEngine {
    private  final Searchable[] searchables;
    private  int count;

    public SearchEngine(int capacity) {
        this.searchables =  new Searchable[capacity];
        this.count = 0;
    }
    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить элемент: поисковый движок переполнен!");
        }
    }

    public Searchable findBestMatch (String query) throws BestResultNotFound {
        if (query == null || query.isBlank()){
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым.");
        }
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                String searchTerm = searchable.getSearchTerm().toLowerCase();
                String lowerCaseQuery = query.toLowerCase();

                int count = countOccurrences(searchTerm, lowerCaseQuery);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + query);
        }

        return bestMatch;
    }
    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        String lowerCaseQuery = query.toLowerCase();
        for (Searchable searchable : searchables) {
            if (searchable != null) {

                String lowerCaseSearchTerm = searchable.getSearchTerm().toLowerCase();
                if (lowerCaseSearchTerm.contains(lowerCaseQuery)) {
                    results[foundCount] = searchable;
                    foundCount++;
                    if (foundCount == 5) {
                        break;
                    }
                }
            }
        }

        return results;
    }


}
