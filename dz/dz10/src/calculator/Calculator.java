package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("������� 1, ����� ������� 2 �����\n" +
"������� 2, ����� �������� 2 �����\n" + "������� 3, ����� ������� ���� ����� �� �������\n" +
                "������� 4, ����� ��������� ���� ����� �� ������\n");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        switch(ans){
            case 1:
                try{
                double res = addition();
                System.out.println("���������: " + res);
                }
                catch(InputMismatchException e){
                   message();
                }
                break;
            case 2:
                try{
                double res2 = multiplication();
                System.out.println("���������: " + res2);
                }
                catch(InputMismatchException e){
                    message();
                }
                break;
            case 3:
                try{
                double res3 = subtraction();
                System.out.println("���������: " + res3);
                }
                catch(InputMismatchException e){
                    message();
                }
                break;
            case 4:
                try{
                double res4 = division();
                System.out.println("���������: " + res4);
                }
                catch(InputMismatchException e){
                    message();
                }
                catch(Infinity inf){
                     System.err.println("O�����: " + inf.getRussianMessage());
                     System.out.println("!!!������� �� ���� ���������");
                }
                break;
        }
    }
    
    public static double addition() throws InputMismatchException{
        System.out.println("������� ������ �����:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("������� ������ �����:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a+b; 
    }
    
    public static double multiplication()throws InputMismatchException{
        System.out.println("������� ������ �����:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("������� ������ �����:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a*b; 
    }
    
     public static double subtraction()throws InputMismatchException{
        System.out.println("������� �����������:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("������� ����������:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        return a-b; 
     }
     
     public static double division()throws InputMismatchException, Infinity{
        System.out.println("������� �������:");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        System.out.println("������� ��������:");
        Scanner in2 = new Scanner(System.in);
        double b = in2.nextDouble();
        if(b==0){
            throw new Infinity("�������������");
        }
        return a/b; 
     }
     
     public static void message(){
         System.out.println("������� �� �����");
     }
    
    
}
