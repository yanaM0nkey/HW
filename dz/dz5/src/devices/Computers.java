package devices;


public class Computers extends Devices {
    private String brand;

    public Computers(String brand, double price) {
        super(price);
        this.brand = brand;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}
