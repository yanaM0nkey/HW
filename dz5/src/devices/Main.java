package devices;

public class Main {

    public static void main(String[] args) {
       MobilePhone phone = new MobilePhone("Android", 5, "white", "Samsung", 500);
       Notebook notebook = new Notebook("home", 15, "FullHD", "ASUS", 800);
       
       System.out.println("Phone brand:" + phone.getBrand() + "\nScreen size:" + phone.getScreenSize() + "\nColor:" + phone.getColor() + "\nOS:" + phone.getOs() + "\nPrice:" + phone.getPrice());
       System.out.println("Computer brand:" + notebook.getBrand() + "\nScreen size:" + notebook.getScreenSize() + "\nType:" + notebook.getType() + "\nScreen resolution:" + notebook.getScreenResolution() + "\nPrice:" + notebook.getPrice());
    }

}
