package devices;

public class MobilePhone extends Electronics {
    private String os;
    private double screenSize;
    private String color;

    

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MobilePhone(String os, double screenSize, String color, String brand, double price) {
        super(brand, price);
        this.os = os;
        this.screenSize = screenSize;
        this.color = color;
    }
}
