package org.skypro.skyshop.search;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import org.skypro.skyshop.search.interfaces.Searchable;

public class SearchEngine {

    public Searchable findBestMatch(String search, ProductBasket basket) throws BestResultNotFound {
        Product[] products = basket.getAllBasket();
        int maxCoincidence = 0;
        Searchable searchableProduct = null;
        for (Product product : products) {
            if (product != null) {
                int coincidence = countCoincidence(product.getSearchTerm(), search);
                if (maxCoincidence < coincidence) {
                    maxCoincidence = coincidence;
                    searchableProduct = product;
                }
            }
        }
        if (maxCoincidence == 0) {
            throw new BestResultNotFound("best result not found");
        }
        return searchableProduct;
    }

    private int countCoincidence(String temp, String search) {
        int count = 0;
        int index = 0;
        while (true) {
            int coincidence = search.indexOf(temp, index);
            if (coincidence == -1) {
                break;
            }
            count++;
            index = coincidence + temp.length();
        }
        return count;
    }
}
