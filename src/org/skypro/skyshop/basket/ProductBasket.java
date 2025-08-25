package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] productBasket = new Product[5];
    private int productCount = 0;


    public void addProduct(Product product) {
        if (productCount == 5) {
            System.out.println("not enough space to add product");
        } else {
            productBasket[productCount] = product;
            productCount++;
        }
    }

    public int amountOfBasket() {
        int sum = 0;
        for (Product product : productBasket) {
            if (product == null) {
                continue;
            } else {
                sum += product.getCost();
            }
        }
        return sum;
    }

    public void getBasket() {
        if (productCount == 0) {
            System.out.println("Basket is empty");
        } else {
            for (Product product : productBasket) {
                if (product == null) {
                    continue;
                } else {
                    System.out.println(product);
                }
            }
            System.out.println("Amount: " + this.amountOfBasket());
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
        if (productCount == 0) {
            System.out.println("Basket is empty");
        } else {
            for (int i = productCount; i != 0; i--) {
                productBasket[i - 1] = null;
            }
            productCount = 0;
        }
    }
}
