package de.tha.blatt4.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;
    private Customer customer;
    private Computer computer;

    @BeforeEach
    void setUp() {
        shop = new Shop(1000.0);
        customer = new Customer("Test Kunde", "Teststraße 1", "test@example.com", 500.0);

        Price computerPrice = new Price(200.0, Tax.FULL);
        computer = new Computer("Test PC", computerPrice, 2.4, 3.2, 500);
    }

    @Test
    void newShoppingCart() {
            ShoppingCart cart = shop.newShoppingCart(customer);

            assertNotNull(cart, "Warenkorb sollte nicht null sein");
        assertSame(customer, cart.getCustomer(), "Warenkorb sollte den richtigen Kunden enthalten");
        assertEquals(0, cart.getProducts().size(), "Neuer Warenkorb sollte leer sein. ");
    }

    @Test
    void buy() {
        // Erfolgsfall: Normaler Kauf mit ausreichend Geld
        ShoppingCart cart = shop.newShoppingCart(customer);
        cart.addProduct(computer);
        
        double initialCustomerMoney = customer.getAvailableMoney();
        double initialShopMoney = shop.getMoney();
        double productPrice = computer.getPrice().getGrossPrice();
        
        try {
            shop.buy(cart);
            
            // 1. Prüfe, ob der Shop das Geld bekommen hat
            assertEquals(initialShopMoney + productPrice, shop.getMoney());
            
            // 2. Prüfe, ob der Kunde das Geld bezahlt hat
            assertEquals(initialCustomerMoney - productPrice, customer.getAvailableMoney());
            
            // 3. Prüfe, ob das Produkt an den Kunden geliefert wurde
            assertEquals(1, customer.getProducts().size());
            assertTrue(customer.getProducts().get(0) == computer);
            
            // 4. Prüfe, ob unitsSold erhöht wurde
            assertEquals(1, computer.getUnitsSold());
            
        } catch (Exception e) {
            fail("Keine Exception erwartet: " + e.getMessage());
        }
        
        // Fehlerfall: Kunde hat nicht genug Geld
        Customer poorCustomer = new Customer("Armer Kunde", "Adresse", "email", 10); // Wenig Geld
        ShoppingCart poorCart = shop.newShoppingCart(poorCustomer);
        poorCart.addProduct(computer); // Teurer Computer
        
        assertThrows(NotEnoughMoneyException.class, () -> {
            shop.buy(poorCart);
        });
    }

    @Test
    void getMoney() {
        assertEquals(1000, shop.getMoney());

        ShoppingCart cart = shop.newShoppingCart(customer);
        cart.addProduct(computer);

        try {
            shop.buy(cart);
            assertEquals(1000 + computer.getPrice().getGrossPrice(), shop.getMoney());
        } catch (Exception e) {
            fail("Keine Exception erwartet: " + e.getMessage());
        }
    }

    @Test
    void main() {
    }
}