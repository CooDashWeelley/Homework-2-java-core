package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        SimpleProduct abc = new SimpleProduct("abc", 1);
        SimpleProduct abc1 = new SimpleProduct("abc", 2);
        SimpleProduct abc2 = new SimpleProduct("abc", 3);
        SimpleProduct abc3 = new SimpleProduct("abc", 4);
        DiscountedProduct bcd = new DiscountedProduct("bcd", 2, 50);
        SimpleProduct cde = new SimpleProduct("cde", 3);
        FixPriceProduct vfr = new FixPriceProduct("vfr");
        DiscountedProduct bgt = new DiscountedProduct("bgt", 5, 25);
        SimpleProduct nhy = new SimpleProduct("nhy", 6);

        ProductBasket productBasket = new ProductBasket();
        ProductBasket productBasket2 = new ProductBasket();

        productBasket2.addProduct(abc);
        productBasket.addProduct(abc);
        productBasket.addProduct(abc1);
        productBasket.addProduct(abc2);
        productBasket.addProduct(bcd);
        productBasket.addProduct(cde);
        productBasket.addProduct(vfr);
        productBasket.addProduct(bgt);
        productBasket.addProduct(nhy);
        productBasket.getBasket();
        System.out.println(productBasket.amountOfBasket());
        System.out.println(productBasket.findByTitle("abc"));
        System.out.println(productBasket.findByTitle("cba"));
//        productBasket.clearBasket();
        productBasket.getBasket();
        System.out.println(productBasket.amountOfBasket());
        System.out.println(productBasket.findByTitle("abc"));
        productBasket2.getBasket();

        try {
            DiscountedProduct empty2 = new DiscountedProduct("a", 0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("incorrect data");
        }
        try {
            SimpleProduct empty = new SimpleProduct("", 1);
        } catch (IllegalArgumentException e) {
            System.out.println("incorrect data");
        }

        SearchEngine search = new SearchEngine();

        try {
            System.out.println(search.findBestMatch("abcabccdecdecde", productBasket));
        } catch (BestResultNotFound e) {
            System.out.println("result not found");
        }
        try {
            System.out.println(search.findBestMatch("a", productBasket2));
        } catch (BestResultNotFound e) {
            System.out.println("result not found");
        }
        System.out.println(productBasket.removeFromBasketByName("abc"));
        System.out.println(productBasket.printBasket());
        productBasket2.removeFromBasketByName("d");
        productBasket.getBasket();

        search.addToSearchList(abc);
        search.addToSearchList(bcd);
        search.addToSearchList(cde);
        search.addToSearchList(vfr);
        search.addToSearchList(bgt);
        search.addToSearchList(nhy);
        search.addToSearchList(abc1);
        search.addToSearchList(abc2);
        search.addToSearchList(abc3);

        System.out.println(search.findAllMatch("abc"));

    }
}