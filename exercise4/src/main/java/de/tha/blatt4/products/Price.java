package de.tha.blatt4.products;

public class Price {
    private double netprice;
    private Tax taxclass;

    Price(double percentage, Tax tax) {
        this.netprice = percentage;
        this.taxclass = tax;
    }

    public double getNetprice() {
        return netprice;
    }

    public double getGrossPrice() {
        return netprice * taxclass.percentage;
    }
}
