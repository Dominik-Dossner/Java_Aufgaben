package de.tha.blatt4.products;

public class Computer extends AbstractProduct implements Shippable {
    private double price;
    private double ramSpeed;
    private double cpuSpeed;
    private double storageSize;
    private int unitSolds;
    private double width = 0;
    private double height = 0;
    private double weight = 0;
    private double length = 0;

    public Computer(String title, Price price, double ramSpeed, double cpuSpeed, double storageSize) {
        super(title, price);
        this.ramSpeed = ramSpeed;
        this.cpuSpeed = cpuSpeed;
        this.storageSize = storageSize;
    }


    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Price getPrice() {
        return super.getPrice();
    }

    @Override
    public int getUnitsSold() {
        return unitSolds;
    }

    @Override
    public void unitSold() {
        unitSolds++;
    }
    
    @Override
    public void shipTo(Customer customer) {
        System.out.println("Computer '" + getName() + "' wird an " + customer.getName() + " versandt");
        System.out.println("Versandadresse: " + customer.getAddress());
        
        customer.addProduct(this);
        // Hinweis: unitSold() wird im FulfillmentCenter aufgerufen, nicht hier
    }
}
