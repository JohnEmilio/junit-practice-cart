package tech.strategio;

import java.util.*;

public class ShoppingCart {

    private ArrayList items;

    public ShoppingCart() {
        items = new ArrayList();
    }

    public double getBalance() {
        double balance = 0.00;
        for (Object o : items) {
            Product item = (Product) o;
            balance += item.getPrice();
        }
        return balance;
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public void removeItem(Product item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException("Milk not found in shopping cart");}
    }

    public int getItemCount() {
        return items.size();
    }

    public void empty() {
        items.clear();
    }
}


