package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int percentOfDiscount;

    public DiscountedProduct(String title, int basePrice, int percentOfDiscount) {
        super(title);
        this.basePrice = basePrice;
        this.percentOfDiscount = percentOfDiscount;
    }


    @Override
    public int getPrice() {
        return basePrice - basePrice * percentOfDiscount / 100;
    }


    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String toString() {
        return "DiscountedProduct{" +
                "title= " + getTitle() +
                ", Price=" + getPrice() +
                ", percentOfDiscount=" + percentOfDiscount +
                "%}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return super.getTitle().equals(that.getTitle()) && basePrice == that.basePrice && percentOfDiscount == that.percentOfDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, percentOfDiscount);
    }
}
