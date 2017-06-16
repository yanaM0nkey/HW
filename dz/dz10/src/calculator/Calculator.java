package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("введите 1, чтобы сложить 2 числа\n" +
"введите 2, чтобы умножить 2 числа\n" + "введите 3, чтобы вычесть одно число от другого\n" +
                "введите 4, чтобы разделить одно число на другое\n");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        switch(ans){
            case 1:
                try{
                double res = addition();
                System.out.println("–езультат: " + res);
                }
                catch(InputMismatchException e){
                   message();
                }
                break;
            case 2:
                try{
                double res2 = multiplication();
                System.out.println("–езультат: " + res2);
                }
                catch(InputMismatchException e){
                    message();
                }
                break;
            case 3:
                try{
                double res3 = subtraction();
                System.out.println("–езультат: " + res3);
                }
                catch(InputMismatchException e){
                    message();
                }
                break;
            case 4:
                try{
                double res4 = division();
                System.out.println("–езультат: " + res4);
                }
                catch(InputMismatchException e){
                    message();
                }
                catch(Infinity inf){
                     System.err.println("Oшибка: " + inf.getRussianMessage());
                     System.out.println("!!!ƒеление на ноль запрещено");
                }
                break;
        }
    }
    
    public static double addition() throws InputMismatchException{
        System.out.println("¬ведите первое число:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("¬ведите второе число:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a+b; 
    }
    
    public static double multiplication()throws InputMismatchException{
        System.out.println("¬ведите первое число:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("¬ведите второе число:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a*b; 
    }
    
     public static double subtraction()throws InputMismatchException{
        System.out.println("¬ведите уменьшаемое:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("¬ведите вычитаемое:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a-b; 
     }
     
     public static double division()throws InputMismatchException, Infinity{
        System.out.println("¬ведите делимое:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("¬ведите делитель:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        if(b==0){
            throw new Infinity("Ѕесконечность");
        }
        return a/b; 
     }
     
     public static void message(){
         System.out.println("¬ведено не число");
     }
    
    
}
