package dz4;

import java.util.Scanner;


public class Dz4 {

    public static void main(String[] args) {
        Patient [] patients = new Patient[3];
        for(int i = 0; i < patients.length; i++)
            patients[i] = new Patient();
        printIn(patients);
        printOut(patients);
        System.out.println("����� �������� �� �������/�� ��������? (1/2)");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n){
           case 1:
             System.out.println("������� ������� ��� ������: ");
             Scanner in2 = new Scanner(System.in);
             String name = in2.nextLine();
             findName(patients, name);
             break;
           case 2:
             System.out.println("������� ������� ��� ������: ");
             Scanner in3 = new Scanner(System.in);
             int age = in3.nextInt();
             findAge(patients, age);
             break; 
           default:
             System.out.println("���...���-�� ����� �� ���, ���������� ��� ���");
             System.exit(0);
             break;        
       }  
    }
    
    public static void printIn(Patient[] patients){
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String ill;
        System.out.println("������� ������ � ��������");
        for(int i = 0; i < patients.length; i++){
            System.out.println("�������: ");
            patients[i].name = s.nextLine();
            System.out.println("�������: ");
            patients[i].age = s1.nextInt();
            System.out.println("���� �� ����������� �����������: (��/���)");
            ill = s2.nextLine();
            if(ill.equals("��"))
                patients[i].isIll= true;
            else if(ill.equals("���"))
                patients[i].isIll= false;
            else{ 
                System.out.println("���...���-�� ����� �� ���, ���������� ��� ���");
                System.exit(0);
            }
            
        }
    }
    
    public static void printOut(Patient[] patients){
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].isIll == true)
                System.out.println("������� " + patients[i].name + ", �������: " + patients[i].age + " ����� ����. ���."); 
            else 
                System.out.println("������� " + patients[i].name + ", �������: " + patients[i].age + " �� ����� ����. ���.");
        }
    }
    
    public static void findName(Patient[] patients, String name){
        int k = 0;
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].name.equals(name)){
                System.out.println("������� " + patients[i].name + ", �������: " + patients[i].age + " ����� ����. ���."); 
                k++;
            }
        }
        if(k == 0)
                System.out.println("��������� � ����� �������� �� �������");
    }
    
    public static void findAge(Patient[] patients, int age){
        int k = 0;
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].age == age){
                System.out.println("������� " + patients[i].name + ", �������: " + patients[i].age + " ����� ����. ���."); 
                k++;
            }
        }
        if(k == 0)
                System.out.println("��������� ������ �������� �� �������");
    }
    
}
