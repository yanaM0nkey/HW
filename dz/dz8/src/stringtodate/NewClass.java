package stringtodate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NewClass {
    public static void main(String[] args) throws ParseException {
        String date = "2017-06-05 20:25";
        Date date2;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd hh:mm");
        date2 = format.parse(date);
        System.out.println(date2);
    }
    
}
