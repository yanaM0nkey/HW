package formatdate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewClass {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat();
        SimpleDateFormat df = new SimpleDateFormat();
        SimpleDateFormat ff = new SimpleDateFormat();
        char e = 'e';
        sf.applyPattern("MMMM");
        String dateString = sf.format(date);
         System.out.print(dateString);
        df.applyPattern(" d");
        dateString = df.format(date);
        System.out.print(dateString);
        System.out.print(e + ", ");
        ff.applyPattern("K:m a ");
        dateString = ff.format(date);
        System.out.println(dateString);
    }
}