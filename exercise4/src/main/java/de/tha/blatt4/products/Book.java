package de.tha.blatt4.products;

public class Book extends AbstractProduct implements Downloadable, Shippable {
    private String bookName;
    private String author;
    private int year;
    private int downlads;
    private int unitsolds;
    private double width = 0;
    private double height = 0;
    private double weight = 0;
    private double length = 0;

    public Book(String title, Price price, String author, int year, int downlads) {
        super(title, price);
        this.author = author;
        this.downlads = downlads;
        this.year = year;
    }

    @Override
    public double getDownloadSize() {
        return downlads;
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
        return unitsolds;
    }

    @Override
    public void unitSold() {}

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
    public void transferTo(Customer customer) {
        System.out.println("Buch '" + getName() + "' von " + author + " wird an " + customer.getName() + " digital übertragen");
        System.out.println("Download-Größe: " + getDownloadSize() + " MB");
        System.out.println("E-Mail: " + customer.getEmailAddress());

        customer.addProduct(this);
        
        unitSold();
    }
    
    @Override
    public void shipTo(Customer customer) {
        System.out.println("Buch '" + getName() + "' von " + author + " wird an " + customer.getName() + " versandt");
        System.out.println("Versandadresse: " + customer.getAddress());
        
        customer.addProduct(this);
        
        unitSold();
    }
}
