package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product abc = new Product("abc", 1);
        Product bcd = new Product("bcd", 2);
        Product cde = new Product("cde", 3);
        Product vfr = new Product("vfr", 4);
        Product bgt = new Product("bgt", 5);
        Product nhy = new Product("nhy", 6);
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