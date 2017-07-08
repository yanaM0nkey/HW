package project;

import java.util.ArrayList;


public class Root {
    private String name;
    private String location;
    private int baseSalary;
    private ArrayList<Employees> employees;

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
        return "Root{" + "name=" + name + ", location=" + location + ", baseSalary=" + baseSalary + "\n" + employees.toString() + '}';
    }
    
    

   
    
}
