package array;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        vvod(list);
        vyvod(list);
        removeA(list);
        vyvod(list);
        duplicate(list);
        vyvod(list); 
    }
    
    public static void vvod(ArrayList<String> list){
        boolean i = true;
        String symbol = "@";
        while(i){
            System.out.println("введите букву:");
            Scanner in = new Scanner(System.in);
            String ans = in.nextLine();
            if(ans.equals(symbol)){
                i = false;
                continue;
            }
            list.add(ans);
        }
    }
    
    public static void vyvod(ArrayList<String> list){
        for(String text: list){
            System.out.print(text + " ");
        }
        System.out.println();
    }
    
    public static void removeA(ArrayList<String> list){
        /*for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("a")){
                list.remove(i);
            }
        }*/
        //код выше - если а на нулевом месте то не удаляется
        ArrayList <String> a = new ArrayList<>();
        a.add("a");
        list.removeAll(a);
    }
    
    public static void duplicate(ArrayList<String> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){
               if(list.get(i).equals(list.get(j))){
                list.remove(j);
                j--;
                } 
            }
            
        }
        
    }
    
}
