package devices;


public class Electronics extends Devices  {
    private String brand;

    
    public Electronics(String brand, double price) {
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
