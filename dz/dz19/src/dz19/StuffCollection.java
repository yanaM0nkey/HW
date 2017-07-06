package dz19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StuffCollection<T> {
    private HashMap<String,List<T>> data = new HashMap<>();
 
    private T director;
    
    public void addDirector(T value){
        director = value;
    }

    public T getDirector(){
        return director;
    }

    public void add(String department, T value){
        if(data.containsKey(department)){
            data.get(department).add(value);       
        }else{
            List<T> list = data.get(department);
            if(list==null){
                list = new ArrayList<>();
            }
            list.add(value);
            data.put(department, list);
        }
    }
    
    public void remove(String department, T value){
        if(data.containsKey(department)){
            List<T> list = data.get(department);
            if(list.size()!= 0){
                for(int i = 0; i < list.size(); i++){
                    if(value.equals(list.get(i))){
                        list.remove(i);
                    }else{
                        System.out.println("Нет такого сотрудника");
                    }
                }
            }else{
                System.out.println("Отдел пустой");
            }
        } else{
            System.out.println("Нет такого отдела");
        }
    }
    
    public int getSize(String department){
        if(data.containsKey(department)){
            List<T> list = data.get(department);
            return list.size(); 
        }else{
            System.out.println("Нет такого отдела");
            return 0;
        }
    }

 
    public String getString() {
        return "StuffCollection{" + "data=" + data.toString() + ", director=" + director + '}';
    }  
}
