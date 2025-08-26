package org.skypro.skyshop.product;

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
}
