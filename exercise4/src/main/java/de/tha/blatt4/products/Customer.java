package de.tha.blatt4.products;

import de.tha.blatt3.Container;
import de.tha.blatt3.DoubleLinkedList;

public class Customer {
    private String address;
    private String name;
    private DoubleLinkedList ownedProducts;
    private double money;
    private String emailAddress;

    public Customer(String name, String address, String emailAddress, double money) {
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.money = money;
        this.ownedProducts = new DoubleLinkedList();
    }

    public void receiveProduct(Shippable product) {
        if (product instanceof Product) {
            ownedProducts.add((Product) product);
        }
    }

    public void downloadProduct(Downloadable product) {
        if (product instanceof Product) {
            ownedProducts.add((Product) product);
        }
    }
    
    public void addProduct(Product product) {
        ownedProducts.add(product);
    }

    public double getAvailableMoney() {
        return money;
    }

    public Container getProducts() {
        return ownedProducts;
    }

    public void pay(double amount) throws NotEnoughMoneyException {
        if (money >= amount) {
            money -= amount;
        } else {
            throw new NotEnoughMoneyException("Nicht genügend Geld zum Bezahlen von " + amount);
        }
        
    }

    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

}
