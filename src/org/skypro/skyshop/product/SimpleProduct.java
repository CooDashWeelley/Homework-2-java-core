package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String title, int price) {
        super(title);
        if (price < 1) {
            throw new IllegalArgumentException("price less 1");
        } else {
            this.price = price;
        }
    }


    @Override
    public int getPrice() {
        return this.price;
    }


    @Override
    public boolean isSpecial() {
        return false;
    }


    @Override
    public String toString() {
        return "SimpleProduct{" +
                "title=" + getTitle() +
                ", price=" + price +
                '}';
    }
}
