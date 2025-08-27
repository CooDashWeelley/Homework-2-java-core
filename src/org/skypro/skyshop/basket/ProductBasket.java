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
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void getBasket() {
        int specialProduct = 0;
        if (productCount == 0) {
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
