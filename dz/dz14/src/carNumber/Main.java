package carNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    
    public static void main(String[] args) {
        String text = "2017 AB-7";
        Pattern p = Pattern.compile("[0-9]{4}\\s\\w{2}-[0-7]{1}");
        Matcher m = p.matcher(text);
        
        if(m.matches()){
            System.out.println("Номер верный");
        } else{
            System.out.println("Номер неверный");
        }
    }
    
}
