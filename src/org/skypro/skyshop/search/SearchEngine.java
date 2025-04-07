package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();
    private final SearchableComparator comparator = new SearchableComparator();



    public void add(Searchable searchable) {
        searchables.add(searchable);
    }


    public Set<Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptySet();
        }

        String lowerCaseQuery = query.toLowerCase();
        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerCaseQuery))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(comparator)
                ));
    }




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

                int count = (int) clone(searchTerm, lowerCaseQuery);
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

    private Object clone(String searchTerm, String lowerCaseQuery) {
        return null;
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