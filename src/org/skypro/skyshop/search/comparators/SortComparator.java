package org.skypro.skyshop.search.comparators;

import org.skypro.skyshop.search.interfaces.Searchable;

import java.util.Comparator;

public class SortComparator implements Comparator<Searchable> {


    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length()) == 0) {
            return o1.compareTo(o2);
        }
        return Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
    }
}
