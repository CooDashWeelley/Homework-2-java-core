package org.skypro.skyshop.search;

import org.skypro.skyshop.search.comparators.SortComparator;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.interfaces.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables = new HashSet<>();

    public void addToSearchList(Searchable item) {
        searchables.add(item);
    }


    public Map<String, Searchable> findBestMatch(String search) throws BestResultNotFound {
        int maxCoincidence = 0;
        Map<String, Searchable> bestMatchMap = new TreeMap<>();
        for (Searchable product : searchables) {
            if (product != null && search.contains(product.getSearchTerm())) {
                bestMatchMap.put(product.getSearchTerm(), product);
                maxCoincidence++;
            }
        }
        if (maxCoincidence == 0) {
            throw new BestResultNotFound("best result not found");
        }
        return bestMatchMap;
    }


    public List<Searchable> findAllMatch(String search) {
        List<Searchable> matchList = new LinkedList<>();
        for (Searchable product : searchables) {
            if (product.getSearchTerm().equals(search)) {
                matchList.add(product);
            }
        }
        if (matchList.isEmpty()) {
            System.out.println("No matches");
        }
        return matchList;
    }

    public Set<Searchable> search(String searchRequest) {
        Set<Searchable> listOfSearch = new TreeSet<>(new SortComparator());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchRequest)) {
                listOfSearch.add(searchable);
            }
        }
        if (listOfSearch.isEmpty()) {
            System.out.println("No matches");
        }
        return listOfSearch;
    }
}
