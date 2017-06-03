package devices;

public class Notebook extends Computers {
    private String type;
    private int screenSize;
    private String screenResolution;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public Notebook(String type, int screenSize, String screenResolution, String brand, double price) {
        super(brand, price);
        this.type = type;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
    }
    
}
