package de.tha.blatt4.products;

abstract public class AbstractProduct implements Comparable<AbstractProduct>, UnitsSold, Product {
    private Price price;
    private String name;
    private int unitsSold = 0;


    public AbstractProduct(String name, Price price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public int compareTo(AbstractProduct other) {
        double thisprice = this.getPrice().getGrossPrice();
        double otherprice = other.getPrice().getGrossPrice();

        return Double.compare(thisprice, otherprice);
    }

    @Override
    public Price getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void unitSold() {
        this.unitsSold++;
    }

    public int getUnitsSold() {
        return unitsSold;
    }
}
