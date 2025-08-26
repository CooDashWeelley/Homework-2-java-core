package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int PRICE = 10;

    public FixPriceProduct(String title) {
        super(title);
    }


    @Override
    public int getPrice() {
        return PRICE;
    }


    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String toString() {
        return "FixPriceProduct{" +
                "title=" + getTitle() +
                ", Fix Price=" + PRICE +
                "}";
    }
}
