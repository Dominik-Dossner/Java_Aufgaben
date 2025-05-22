package de.tha.blatt4.products;

public enum Tax {
    FULL(1.19), REDUCED(1.07);
    protected double percentage;

    Tax(double percentage) {
        this.percentage = percentage;
    }

    public double getPriceWithTax(double amount) {
        return amount * percentage;
    }

}
