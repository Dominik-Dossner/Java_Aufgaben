package de.tha.blatt4.products;

import de.tha.blatt4.products.FulfillmentCenter;

public class Shop {
    private FulfillmentCenter fulfillmentCenter;
    private double availableMoney;

    public Shop(double availableMoney) {
        this.availableMoney = availableMoney;
        fulfillmentCenter = new FulfillmentCenter();
    }

    
    public ShoppingCart newShoppingCart(Customer customer) {
        return new ShoppingCart(customer);
    } 
    
    public void buy (ShoppingCart cart) throws NotEnoughMoneyException, CannotShipException {
        double totalPrice = cart.getGrossPrice();
        Customer customer = cart.getCustomer();
        
        if (totalPrice > availableMoney) {
            throw new NotEnoughMoneyException("Not enough money");
        }
        
        customer.pay(totalPrice);
        availableMoney += totalPrice;
        fulfillmentCenter.sendProductsToCustomer(cart);
    }
    
    public double getMoney() {
        return availableMoney;
    }

    public static void main(String[] args) {
        Shop result = new Shop(2000);
        Customer customer = new Customer("Dominik", "Hannover", "dominik@hannover.de", 1500);
        ShoppingCart cart = result.newShoppingCart(customer);
        
        cart.addProduct(new Computer("Laptop", new Price(1000, Tax.FULL), 5, 5, 200));
        cart.addProduct(new Monitor("Monitor", new Price(100, Tax.FULL), 24, "2560x1440"));
        
        try {
            result.buy(cart);
            System.out.println("==================================");
            System.out.println("✅ Kauf erfolgreich abgeschlossen!");
            System.out.println("Kunde: " + customer.getName());
            System.out.println("Artikel: " + cart.getProducts().size() + " Produkte");
            System.out.println("==================================");
        } catch (NotEnoughMoneyException e) {
            System.out.println("==================================");
            System.out.println("❌ FEHLER: Nicht genügend Geld!");
            System.out.println("Kunde: " + customer.getName());
            System.out.println("==================================");
        } catch (CannotShipException e) {
            System.out.println("==================================");
            System.out.println("❌ FEHLER: Produkt kann nicht versendet werden!");
            System.out.println("Produkt: " + e.getMessage());
            System.out.println("==================================");
        }
    }
}
