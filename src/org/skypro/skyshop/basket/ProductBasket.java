package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ProductBasket {
    private List<Product> productBasket = new LinkedList<>();

    private int basketSize = 0;


    public void addProduct(Product product) {
        productBasket.add(product);
        basketSize++;
    }

    public int amountOfBasket() {
        int sum = 0;
        for (Product product : productBasket) {
            sum += product.getPrice();
        }
        return sum;
    }


    public List<Product> printBasket() {
        return this.productBasket;
    }


    public void getBasket() {
        int specialProduct = 0;
        if (basketSize == 0) {
            System.out.println("Basket is empty");
        } else {
            for (Product product : productBasket) {
                if (product == null) {
                    continue;
                } else {
                    System.out.println(product);
                }
                if (product.isSpecial()) {
                    specialProduct++;
                }
            }
            System.out.println("Amount: " + this.amountOfBasket());
            System.out.println("Special Product: " + specialProduct);
        }
    }


    public boolean findByTitle(String title) {
        for (Product product : productBasket) {
            if (product != null && title.equals(product.getTitle())) {
                return true;
            }
        }
        return false;
    }


    public void clearBasket() {
        if (basketSize == 0) {
            System.out.println("Basket is empty");
        } else {
            ListIterator<Product> iter = productBasket.listIterator();
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
            }
            basketSize = 0;
        }
    }


    public List<Product> removeFromBasketByName(String title) {
        ListIterator<Product> iter = this.productBasket.listIterator();
        List<Product> removedProduct = new LinkedList<>();
        while (iter.hasNext()) {
            Product prod = iter.next();
            if (prod.getTitle().equals(title)) {
                removedProduct.add(prod);
                iter.remove();
            }
        }
        if (removedProduct.isEmpty()) {
            System.out.println("Remove list is empty");
        } else {
            System.out.print("Remove list: ");
        }
        return removedProduct;
    }


}
