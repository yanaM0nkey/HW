package task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    
    public static void main(String[] args) {
        String text = "sfdsgs.json";
        Pattern p = Pattern.compile("([^\\s]+(?=\\.(json|xml))\\.\\2)");
        Matcher m = p.matcher(text);
        if(m.matches()){
            System.out.println("������ ����� ������");
        } else{
            System.out.println("�������� ������ �����");
        }
        Pattern p2 = Pattern.compile("\\.(json|xml)");
        Matcher m2 = p2.matcher(text);
        if(m2.find()){
            System.out.println("���������� ����� - " 
                    + text.substring(m2.start()+1, m2.end()));
        }else
            System.out.println("err");
        
    }
    
}
