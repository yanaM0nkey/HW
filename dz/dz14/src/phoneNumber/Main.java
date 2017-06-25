package phoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    
    public static void main(String[] args) {
        String text = "+375(29)1234567";
        Pattern p = Pattern.compile("\\+375\\(?(17|29|44|33|25)\\)?\\d{7}$");
        Matcher m = p.matcher(text);
        
        if(m.matches()){
            System.out.println("Номер верный");
        } else{
            System.out.println("Номер неверный");
        }
           
    }
    
}
