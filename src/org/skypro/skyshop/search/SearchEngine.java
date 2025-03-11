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
