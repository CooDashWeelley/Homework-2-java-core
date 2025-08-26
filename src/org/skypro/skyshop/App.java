package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct abc = new SimpleProduct("abc", 1);
        DiscountedProduct bcd = new DiscountedProduct("bcd", 2, 50);
        SimpleProduct cde = new SimpleProduct("cde", 3);
        FixPriceProduct vfr = new FixPriceProduct("vfr");
        DiscountedProduct bgt = new DiscountedProduct("bgt", 5, 25);
        SimpleProduct nhy = new SimpleProduct("nhy", 6);
        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(abc);
        productBasket.addProduct(abc);
        productBasket.addProduct(bcd);
        productBasket.addProduct(cde);
        productBasket.addProduct(vfr);
        productBasket.addProduct(bgt);
        productBasket.addProduct(nhy);
        productBasket.getBasket();
        System.out.println(productBasket.amountOfBasket());
        System.out.println(productBasket.findByTitle("abc"));
        System.out.println(productBasket.findByTitle("cba"));
        productBasket.clearBasket();
        productBasket.getBasket();
        System.out.println(productBasket.amountOfBasket());
        System.out.println(productBasket.findByTitle("abc"));
        productBasket2.getBasket();

    }
}