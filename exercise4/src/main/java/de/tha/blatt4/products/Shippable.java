package de.tha.blatt4.products;

public interface Shippable {
    double getWidth();
    double getHeight();
    double getWeight();
    double getLength();

    void shipTo(Customer customer);
}
