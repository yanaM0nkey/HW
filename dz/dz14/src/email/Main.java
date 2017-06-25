package email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        
        String text = "skfjn;akfn sfkj@gmail.com slkfmlk slkmf smlfm@gmail.com nskfjn snkjdnf@gmail.com";
        String text2 = "";
        String newText = "";
        char[] chArray = text.toCharArray();
        int k = 0;
        Pattern p = Pattern.compile(".+\\@{1}.+\\.(com|by|ru)");
        Matcher m;
        for(int i = 0; i<chArray.length; i++){	
                if(chArray[i] == ' '){
                    text2 = text.substring(k, i);
                    k = i+1;
                    System.out.println(text2);
                    m = p.matcher(text2);
                    if(!m.matches()){
                        newText+= text2 + " ";
                    }
                }
                if(i == chArray.length-1){
                    text2 = text.substring(k, chArray.length);
                    System.out.println(text2);
                    m = p.matcher(text2);
                    if(!m.matches()){
                        newText+= text2 + " ";
                    }
                }
                
        }
        System.out.println(newText); 
    }  
}
