package task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    public static void main(String[] args) {
        String text = "hellowoooorld";
        String text2 = "";
        System.out.println(text);
        do{
            text2 = find(text);
            if(!text2.equals("end")){
                text = text2;
                //System.out.println("******");
            }
            //System.out.println("===========");
        }while(!text2.equals("end"));
        System.out.println(text);  
    }
    
    public static String find(String text){
        String pattern = "([a-z])\\1+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        if(m.find()) {
            int num = m.end()- m.start();
            //System.out.println(text + "-------1");
            System.out.println(text.substring(m.start(), m.end()) + "*");
            text = text.replace(text.substring(m.start(), m.end()),
                    text.substring(m.start(), m.start()+1)+ Integer.toString(num));
            //System.out.println(text + "-----2");
            return text;    
        }
        else
            return "end";
        
    }
}
