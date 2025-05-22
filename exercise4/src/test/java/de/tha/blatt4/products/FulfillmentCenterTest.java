package de.tha.blatt4.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FulfillmentCenterTest {

    @Test
    void sendProductsToCustomer() {
        Customer customer = new Customer("Kunde", "Teststraße 1", "test@gmail.com", 5000);
        ShoppingCart cart = new ShoppingCart(customer);
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter();

        Price computerPrice = new Price(200, Tax.FULL);
        Computer computer = new Computer("Test PC", computerPrice, 2.4, 3.2, 500);

        Price gamePrice = new Price(50.0, Tax.REDUCED);
        Game game = new Game("Test Game", gamePrice, 2022, 5.0);

        cart.addProduct(computer);
        cart.addProduct(game);

        try {
            fulfillmentCenter.sendProductsToCustomer(cart);

            assertEquals(2, customer.getProducts().size());
            assertEquals(1, computer.getUnitsSold());
            assertEquals(1, game.getUnitsSold());
        } catch (CannotShipException e) {
            fail("Keine Exception erwartet: " + e.getMessage());
        }
    }
}