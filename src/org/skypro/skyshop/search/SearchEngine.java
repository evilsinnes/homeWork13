package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;


public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();
    private final SearchableComparator comparator = new SearchableComparator();

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Set<Searchable> search(String query) {
        if (query == null || query.isBlank()) {
            return Collections.emptySet();
        }

        String lowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(comparator)));
    }


    private Comparator<Searchable> createSearchableComparator() {
        return Comparator
                .comparingInt((Searchable s) -> -s.getName().length()) // Сортировка по убыванию длины
                .thenComparing(Searchable::getName); // Затем по алфавиту
    }

    public Set<Searchable> findAll() {
        return Collections.unmodifiableSet(searchables);
    }

    public void clear() {
        searchables.clear();
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
