package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productMap = new LinkedHashMap<>();

    private int basketSize = 0;


    public void addProduct(Product product) {
        if (!productMap.containsKey(product.getTitle())) {
            List<Product> productList = new ArrayList<>();
            productMap.put(product.getTitle(), productList);
        }
        productMap.get(product.getTitle()).add(product);
        basketSize++;
    }

    public int amountOfBasket() {
        int sum = 0;
        for (Map.Entry<String, List<Product>> products : productMap.entrySet()) {
            for (Product product : products.getValue()) {
                sum += product.getPrice();
            }
        }
        return sum;

    }


    public Map<String, List<Product>> printBasket() {
        return this.productMap;
    }


    public void getBasket() {
        int specialProduct = 0;
        if (basketSize == 0) {
            System.out.println("Basket is empty");
        } else {
            for (Map.Entry<String, List<Product>> products : productMap.entrySet()) {
                for (Product product : products.getValue()) {
                    if (product.isSpecial()) {
                        specialProduct++;
                    }
                }
            }
            System.out.println(printBasket());
            System.out.println("Amount: " + this.amountOfBasket());
            System.out.println("Special Product: " + specialProduct);
        }
    }


    public boolean findByTitle(String title) {
        for (Map.Entry<String, List<Product>> products : productMap.entrySet()) {
            for (Product product : products.getValue()) {
                if (product != null && title.equals(product.getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }


    public void clearBasket() {
        if (basketSize == 0) {
            System.out.println("Basket is empty");
        } else {
            productMap.clear();
            basketSize = 0;
        }
    }


    public List<Product> removeFromBasketByName(String title) {
        List<Product> removedProduct = new LinkedList<>();
        if (productMap.containsKey(title)) {
            ListIterator<Product> iter = productMap.get(title).listIterator();
            while (iter.hasNext()) {
                Product prod = iter.next();
                if (prod.getTitle().equals(title)) {
                    removedProduct.add(prod);
                }
            }
            productMap.remove(title);
        }
        if (removedProduct.isEmpty()) {
            System.out.println("Remove list is empty");
        } else {
            System.out.print("Remove list: ");
        }
        return removedProduct;
    }


}
