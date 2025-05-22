package de.tha.blatt4.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractProductTest {

    @Test
    void compareTo() {
        Price highPrice = new Price(100, Tax.FULL);
        Price lowPrice = new Price(50, Tax.FULL);

        TestProduct cheapProduct = new TestProduct("Günstig", lowPrice);
        TestProduct expensiveProduct = new TestProduct("Expensiv", highPrice);
    
        assertTrue(cheapProduct.compareTo(expensiveProduct) < 0);
        assertTrue(expensiveProduct.compareTo(cheapProduct) > 0);
   
        TestProduct anotherExpensive = new TestProduct("AnderesTeur", highPrice);
        assertEquals(0, expensiveProduct.compareTo(anotherExpensive));
    }

    @Test
    void getPrice() {
        Price price = new Price(100, Tax.FULL);
        TestProduct product = new TestProduct("Test", price);

        //assertEquals(price, product.getPrice());
        assertSame(price, product.getPrice());
    }

    @Test
    void getName() {
        String productName = "Test";
        TestProduct product = new TestProduct(productName, new Price(10.0, Tax.REDUCED));

        assertEquals(productName, product.getName());
    }

    @Test
    void unitSold() {
        TestProduct product = new TestProduct("Test", new Price(100, Tax.REDUCED));

        assertEquals(0, product.getUnitsSold());

        product.unitSold();

        assertEquals(1, product.getUnitsSold());
    }

    @Test
    void getUnitsSold() {
        TestProduct product = new TestProduct("Test", new Price(100, Tax.REDUCED));

        int runs = 5;

        for (int i = 0; i < runs; i++) {
            product.unitSold();
        }

        assertEquals(runs, product.getUnitsSold());
    }
}