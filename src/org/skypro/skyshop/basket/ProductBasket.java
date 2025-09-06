package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> productBasket = new LinkedHashMap<>();


    public void addProduct(Product product) {
        if (!productBasket.containsKey(product.getTitle())) {
            List<Product> productList = new ArrayList<>();
            productBasket.put(product.getTitle(), productList);
        }
        productBasket.get(product.getTitle()).add(product);
    }


    public int amountOfBasket() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }


    public Map<String, List<Product>> printBasket() {
        return this.productBasket;
    }


    public void getBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("Basket is empty");
        } else {
            System.out.println(printBasket());
            System.out.println("Amount: " + this.amountOfBasket());
            System.out.println("Special Product: " + getSpecialCount());
        }
    }


    private int getSpecialCount() {
        return (int) productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean findByTitle(String title) {
        if (productBasket.containsKey(title)) {
            return productBasket.get(title).stream()
                    .anyMatch(e -> e.getTitle().equals(title));

        }
        return false;
    }


    public void clearBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("Basket is empty");
        } else {
            productBasket.clear();
        }
    }


    public List<Product> removeFromBasketByName(String title) {
        List<Product> removedProduct = new LinkedList<>();
        if (productBasket.containsKey(title)) {
            removedProduct = productBasket.get(title).stream()
                    .filter(e -> e.getTitle().equals(title))
                    .collect(Collectors.toList());
            productBasket.remove(title);
        }
        if (removedProduct.isEmpty()) {
            System.out.println("Remove list is empty");
        } else {
            System.out.print("Remove list: ");
        }
        return removedProduct;
    }


}
