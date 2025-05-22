package de.tha.blatt4.products;

public class Game extends AbstractProduct implements Downloadable {
    private double price;
    private int year;
    private double downloads;
    private int unitSolds;

    public Game(String title, Price price, int year, double downloads) {
        super(title, price);
        this.year = year;
        this.downloads = downloads;
    }


    @Override
    public double getDownloadSize() {
        return downloads;
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
    public void transferTo(Customer customer) {

        System.out.println("Spiel '" + getName() + "' wird an " + customer.getName() + " übertragen");
        System.out.println("Download-Größe: " + getDownloadSize() + " GB");
        System.out.println("E-Mail: " + customer.getEmailAddress());
        
        customer.addProduct(this);
    }
}
