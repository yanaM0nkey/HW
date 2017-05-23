package dz1;

import static java.lang.Math.*;

public class Dz1 {

    public static void main(String[] args) {
        
        System.out.println("Программа 1:");
        String str = "Солнышко";
        System.out.println("Количество символов в строке - " + str.length());
        String str1 = str.substring(0, str.length()/2);
        String str2 = str.substring(str.length()/2);
        System.out.println("строка1-" + str1 + " строка2-" + str2);
        
        System.out.println("Программа 2:");
        int n = 2225556;
        if(n%10 == 7)
            System.out.println("Последняя цифра числа является семеркой");
        else
            System.out.println("Последняя цифра числа не является семеркой");
        
        
        System.out.println("Программа 3:");
        double a = 6;
        double b = 8;
        double r = 5;
        double diag = sqrt(pow(a,2)+pow(b,2));
        if(2*r>=diag)
          System.out.println("Прямоугольное отверстие можно полностью закрыть круглой картонкой");
        else
          System.out.println("Прямоугольное отверстие нельзя полностью закрыть круглой картонкой");
        
        System.out.println("Программа 4:");
        int n2 = 1011;
        int ost = n2%100;
        if(ost<20 && ost>10)
            System.out.println(n2 + " рублей");
        else if(n2%10 == 1)
            System.out.println(n2 + " рубль");
        else if(n2%10 == 2 || n2%10 == 3 || n2%10 == 4)
            System.out.println(n2 + " рубля");
        else
            System.out.println(n2 + " рублей");
       
        System.out.println("Программа 5:");
        String str3 = "##? my# dear#";
        str3 = str3.replace("?", "Hello");
        char[] chArray = str3.toCharArray();
        char[] newchArray = new char[chArray.length];
        for(int i = 0; i<chArray.length; i++){
            if(chArray[i] != '#')
                newchArray[i] = chArray[i];
        }
        System.out.println(newchArray);
        
        System.out.println("Доп. программа:");
        double x = 1;
        double s = 2;
        double t = 1;
        double y = pow(sin(pow(x,t)),2)/sqrt(1+pow(x,s));
        System.out.println(y);
    }
}
