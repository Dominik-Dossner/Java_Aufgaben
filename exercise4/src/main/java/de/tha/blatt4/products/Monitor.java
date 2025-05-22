package de.tha.blatt4.products;

public class Monitor extends AbstractProduct implements Shippable {
    private double price;
    private double size;
    private String resolution;
    private int unitSolds;
    private double width = 0;
    private double height = 0;
    private double weight = 0;
    private double length = 0;

    public Monitor(String title, Price price, double size, String resolution) {
        super(title, price);
        this.size = size;
        this.resolution = resolution;
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
    public int getUnitsSold() {
        return unitSolds;
    }

    @Override
    public void unitSold() {
        unitSolds++;
    }
    
    @Override
    public void shipTo(Customer customer) {
        System.out.println("Monitor '" + getName() + "' mit " + size + "" + " Zoll und " + resolution + " wird an " + customer.getName() + " versandt");
        System.out.println("Versandadresse: " + customer.getAddress());
        
        customer.addProduct(this);
        
        unitSold();
    }
}
