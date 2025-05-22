package de.tha.blatt4.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void getGrossPrice() {
        Customer customer = new Customer("Test Kunde", "Teststraße 1", "test@example.com", 1000.0);
        ShoppingCart shoppingCart = new ShoppingCart(customer);

        assertEquals(0, shoppingCart.getGrossPrice());

        Computer computer = new Computer("Test PC", new Price(100.0, Tax.FULL), 2.4, 3.2, 500);
        shoppingCart.addProduct(computer);

        assertEquals(computer.getPrice().getGrossPrice(), shoppingCart.getGrossPrice());
    }

    @Test
    void getProducts() {
        Customer customer = new Customer("Test Kunde", "Teststraße 1", "test@example.com", 1000.0);
        ShoppingCart shoppingCart = new ShoppingCart(customer);

        assertEquals(0, shoppingCart.getProducts().size());

        Computer computer = new Computer("Test PC", new Price(100.0, Tax.FULL), 2.4, 3.2, 500);
        shoppingCart.addProduct(computer);

        assertEquals(1, shoppingCart.getProducts().size());
        assertEquals(computer, shoppingCart.getProducts().get(0));
    }

    @Test
    void addProduct() {
        Customer customer = new Customer("Test Kunde", "Teststraße 1", "test@example.com", 1000.0);
        ShoppingCart shoppingCart = new ShoppingCart(customer);

        Computer computer = new Computer("Test PC", new Price(100.0, Tax.FULL), 2.4, 3.2, 500);
        shoppingCart.addProduct(computer);

        assertEquals(1, shoppingCart.getProducts().size());
        assertEquals(computer, shoppingCart.getProducts().get(0));
}

    @Test
    void getCustomer() {
        Customer customer = new Customer("Test Kunde", "Teststraße 1", "test@example.com", 1000.0);
        ShoppingCart shoppingCart = new ShoppingCart(customer);

        assertEquals(customer, shoppingCart.getCustomer());
    }
}