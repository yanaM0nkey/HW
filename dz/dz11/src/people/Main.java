package people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
        ArrayList<Person> men = new ArrayList<>();
        ArrayList<Person> women = new ArrayList<>();
        
        men.add(new Person("����","������","��������"));
        men.add(new Person("����","������","��������"));
        men.add(new Person("����","������","��������"));
        women.add(new Person("����","�������","��������"));
        women.add(new Person("�����","�������","���������"));
        women.add(new Person("�����","�������","����������"));
        
        String man = "man";
        String woman = "woman";
        
        HashMap<String,  ArrayList<Person>> hash = new HashMap<>();

        hash.put(man,men);
        hash.put(woman,women);
        
        System.out.println("������� 1, ����� ������� man\n" + 
                "������� 2, ����� ������� woman\n");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        switch(ans){
            case 1:
                vyvod(man, hash);
                break;
            case 2:
                vyvod(woman, hash);
                break; 
        }
    }
    
    public static void vyvod(String person, HashMap<String,  ArrayList<Person>> hash){
        for(String key: hash.keySet()){
            if(key.equals(person)){
                ArrayList<Person> list = new ArrayList<>();
                list = hash.get(key);
                System.out.println(list.toString()); //������ ���������� ������ ���
                break;
            }
        }
        
    }
        
    
}
