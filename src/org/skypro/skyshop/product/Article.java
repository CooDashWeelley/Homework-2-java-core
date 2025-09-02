package org.skypro.skyshop.product;

import org.skypro.skyshop.search.interfaces.Searchable;

import java.util.Objects;

public class Article implements Searchable, Comparable<Searchable> {
    private String title;

    public Article(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Article: "
                + "title: " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.getTitle());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String getSearchTerm() {
        return title;
    }

    @Override
    public int compareTo(Searchable o) {
        return title.compareTo(o.getSearchTerm());
    }
}
