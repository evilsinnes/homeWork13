package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .sorted(Comparator.comparing(Searchable::getName))
                .collect(Collectors.toMap(
                        Searchable::getName,
                        s -> s,
                        (existing, replacement) -> existing, TreeMap::new));
    }

//    public List<Searchable> search(String query) {
//        List<Searchable> results = new ArrayList<>();
//
//        if (query == null || query.isBlank()) {
//            return results;
//        }
//
//        String lowerCaseQuery = query.toLowerCase();
//
//        for (Searchable searchable : searchables) {
//            if (searchable != null) {
//                String lowerCaseSearchTerm = searchable.getSearchTerm().toLowerCase();
//                if (lowerCaseSearchTerm.contains(lowerCaseQuery)) {
//                    results.add(searchable);
//                }
//            }
//        }
//
//        return results;
//    }


    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.isBlank()) {
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
}
