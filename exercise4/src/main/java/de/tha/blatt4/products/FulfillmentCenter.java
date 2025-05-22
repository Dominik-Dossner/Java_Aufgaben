package de.tha.blatt4.products;

public class FulfillmentCenter {
    public FulfillmentCenter() {}

    public void sendProductsToCustomer(ShoppingCart cart) throws CannotShipException {
        Customer customer = cart.getCustomer();
        
        for (int i = 0; i < cart.getProducts().size(); i++) {
            Product product = (Product) cart.getProducts().get(i);
            
            boolean delivered = false;
            
            if (product instanceof Shippable) {
                ((Shippable) product).shipTo(customer);
                delivered = true;
            } else if (product instanceof Downloadable) {
                ((Downloadable) product).transferTo(customer);
                delivered = true;
            }
            
            if (!delivered) {
                throw new CannotShipException("Produkt " + product.getName() + " kann nicht versendet oder heruntergeladen werden");
            }
            
            if (product instanceof UnitsSold) {
                ((UnitsSold) product).unitSold();
            }
        }
    }
}
