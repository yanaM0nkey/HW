package people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
        ArrayList<Person> men = new ArrayList<>();
        ArrayList<Person> women = new ArrayList<>();
        
        men.add(new Person("Иван","Иванов","Иванович"));
        men.add(new Person("Петр","Петров","Петрович"));
        men.add(new Person("Егор","Егоров","Егорович"));
        women.add(new Person("Анна","Иванова","Ивановна"));
        women.add(new Person("Алина","Петрова","Сергеевна"));
        women.add(new Person("Мария","Егорова","Михайловна"));
        
        String man = "man";
        String woman = "woman";
        
        HashMap<String,  ArrayList<Person>> hash = new HashMap<>();

        hash.put(man,men);
        hash.put(woman,women);
        
        System.out.println("введите 1, чтобы выбрать man\n" + 
                "введите 2, чтобы выбрать woman\n");
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
                System.out.println(list.toString()); //правда возвращает адреса ФИО
                break;
            }
        }
        
    }
        
    
}
