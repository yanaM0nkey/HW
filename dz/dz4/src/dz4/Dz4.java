package dz4;

import java.util.Scanner;


public class Dz4 {

    public static void main(String[] args) {
        Patient [] patients = new Patient[3];
        for(int i = 0; i < patients.length; i++)
            patients[i] = new Patient();
        printIn(patients);
        printOut(patients);
        System.out.println("Найти пациента по фамилии/по возрасту? (1/2)");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n){
           case 1:
             System.out.println("Введите фамилию для поиска: ");
             Scanner in2 = new Scanner(System.in);
             String name = in2.nextLine();
             findName(patients, name);
             break;
           case 2:
             System.out.println("Введите возраст для поиска: ");
             Scanner in3 = new Scanner(System.in);
             int age = in3.nextInt();
             findAge(patients, age);
             break; 
           default:
             System.out.println("Упс...что-то пошло не так, попробуйте еще раз");
             System.exit(0);
             break;        
       }  
    }
    
    public static void printIn(Patient[] patients){
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String ill;
        System.out.println("Введите данные о пациенте");
        for(int i = 0; i < patients.length; i++){
            System.out.println("Фамилия: ");
            patients[i].name = s.nextLine();
            System.out.println("Возраст: ");
            patients[i].age = s1.nextInt();
            System.out.println("Есть ли хронические заболевания: (да/нет)");
            ill = s2.nextLine();
            if(ill.equals("да"))
                patients[i].isIll= true;
            else if(ill.equals("нет"))
                patients[i].isIll= false;
            else{ 
                System.out.println("Упс...что-то пошло не так, попробуйте еще раз");
                System.exit(0);
            }
            
        }
    }
    
    public static void printOut(Patient[] patients){
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].isIll == true)
                System.out.println("пациент " + patients[i].name + ", возраст: " + patients[i].age + " имеет хрон. заб."); 
            else 
                System.out.println("пациент " + patients[i].name + ", возраст: " + patients[i].age + " не имеет хрон. заб.");
        }
    }
    
    public static void findName(Patient[] patients, String name){
        int k = 0;
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].name.equals(name)){
                System.out.println("пациент " + patients[i].name + ", возраст: " + patients[i].age + " имеет хрон. заб."); 
                k++;
            }
        }
        if(k == 0)
                System.out.println("пациентов с такой фамилией не найдено");
    }
    
    public static void findAge(Patient[] patients, int age){
        int k = 0;
        for (int i = 0; i < patients.length; i++) {
            if(patients[i].age == age){
                System.out.println("пациент " + patients[i].name + ", возраст: " + patients[i].age + " имеет хрон. заб."); 
                k++;
            }
        }
        if(k == 0)
                System.out.println("пациентов такого возраста не найдено");
    }
    
}
