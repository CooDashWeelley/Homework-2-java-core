package org.skypro.skyshop.search.interfaces;

public interface Searchable {
    String getSearchTerm();

    int compareTo(Searchable o);
}
