package org.skypro.skyshop.product;

import org.skypro.skyshop.search.interfaces.Searchable;

import java.util.Objects;

public abstract class Product  implements Searchable {
    private String title;

    public Product(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("name is null or empty");
        } else {
            this.title = title;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product: " + getTitle() + ", price: " + getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getPrice() == product.getPrice() && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }

    @Override
    public String getSearchTerm() {
        return this.title;
    }
}
