package de.tha.blatt4.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getName() {
        String object = "Test Object";
        Computer computer = new Computer(object, new Price(100, Tax.FULL), 2.4, 3.2, 500);

        assertSame(object, computer.getName());
    }

    @Test
    void getPrice() {
        Price price = new Price(100.0, Tax.FULL);
        Computer computer = new Computer("Test PC", price, 2.4, 3.2, 500);

        assertEquals(100, computer.getPrice().getNetprice());
        assertEquals(119, computer.getPrice().getGrossPrice());

        assertSame(price, computer.getPrice());
    }
}