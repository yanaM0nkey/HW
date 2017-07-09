package project;

import java.util.ArrayList;
import java.util.HashMap;


public class Root {
    private String name;
    private String location;
    private int baseSalary;
    private ArrayList<Employees> employees;
    
    //реализация Singletone
    private static Root root;

    private Root() {
    }
    
    public static Root getInstance(){
        if(root == null){
            root = new Root();
        }
        return root;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Root{" + "name=" + name + ", location=" + location + ", baseSalary=" + baseSalary + employees.toString() + '}';
    }
    
    public HashMap<Integer, Double> getListOfSalary(){
        ListOfSalary listOfSalary = new ListOfSalary();
        HashMap<Integer, Double> list = new HashMap<>();
        for(Employees empl: employees) {
            list.put(empl.getId(), listOfSalary.getSalary(empl));      
        }
        listOfSalary.setListOfSalary(list);
        return list;
    }
    
    class ListOfSalary implements Salary{
        private HashMap<Integer, Double> listOfSalary;

        public HashMap<Integer, Double> getListOfSalary() {
            return listOfSalary;
        }

        public void setListOfSalary(HashMap<Integer, Double> listOfSalary) {
            this.listOfSalary = listOfSalary;
        }

        @Override
        public double getSalary(Employees employee) {
           return baseSalary*employee.getRate()+baseSalary*employee.getYearExperience()/100; 
        }
    }  
}
