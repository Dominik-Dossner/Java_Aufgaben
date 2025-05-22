package de.tha.blatt4.products;

import de.tha.blatt3.Container;
import de.tha.blatt3.DoubleLinkedList;

public class ShoppingCart {
    private Customer customer;
    private DoubleLinkedList products;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.products = new DoubleLinkedList();
    }

    public double getGrossPrice() {
        double totalPrice = 0.0;
        for (int i = 0; i < products.size(); i++) {
            AbstractProduct product = (AbstractProduct) products.get(i);
            totalPrice += product.getPrice().getGrossPrice();
        }
        return totalPrice;
    }

    public Container getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Customer getCustomer() {
        return customer;
    }
}
