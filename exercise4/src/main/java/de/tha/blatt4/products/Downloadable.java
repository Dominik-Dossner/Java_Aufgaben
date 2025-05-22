package de.tha.blatt4.products;

public interface Downloadable {
    double getDownloadSize();

    void transferTo(Customer customer);
}
