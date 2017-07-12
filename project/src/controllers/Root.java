package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;
import models.Employees;
import view.Listener;


public class Root {
    private String name;
    private String location;
    private int baseSalary;
    private ArrayList<Employees> employees;
    private Listener ui = null;
    
    //реализация Singleton
    private static Root root;

    private Root() {
    }
    
    public static Root getInstance(){
        if(root == null){
            root = new Root();
        }
        return root; 
    }

    public void setUi(Listener ui) {
        this.ui = ui;
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
    
    //метод для получения списка зарплат
    public HashMap<Integer, Double> getListOfSalary(){
        ListOfSalary listOfSalary = new ListOfSalary();
        HashMap<Integer, Double> list = new HashMap<>();
        for(Employees empl: employees) {
            list.put(empl.getId(), listOfSalary.getSalary(empl));      
        }
        listOfSalary.setListOfSalary(list);
        return list;
    }
    
    //метод для поиска сотрудника по id
    public Employees find(int id){
        for(Employees empl: employees){
            if(id == empl.getId())
                return empl;
        }
        return null;
    }
    
    //метод для выбора след. операции
    public int start(){
        System.out.println("введите 1, чтобы вывести всю информацию\n" + 
                    "введите 2, чтобы вывести зарплату на экран\n" + 
                    "введите 3, чтобы найти сотрудника по id\n" + 
                    "введите 4, чтобы отсортировать по ФИО\n" + 
                    "введите 5 для завершения работы\n");
        Scanner in = new Scanner(System.in);
        int answ = in.nextInt();
        return answ;
    }
    
    //метод вывода всех сотрудников
    public void print(){
        ui.onPrint(root);
    }
    
    //метод вывода зарплаты
    public void printSalary(){
        ui.onPrintSalary(root);
    }
    
    //метод поиска сотрудника(консоль)
    public void printEmployee(){
        try{
            System.out.println("введите id сотрудника");
            Scanner in = new Scanner(System.in);
            int answer = in.nextInt();
            ui.onPrintEmployee(root, answer);
        }catch(InputMismatchException e){    
            ui.onPrintEmployee(root, -1);    
        } 
    }
    
    //метод сортировки списка сотрудников
    public void printSort(){
        TreeSet<Employees> employeeSort = new TreeSet<>();
        ArrayList<Employees> employeeNotSort = root.getEmployees();
        for(Employees empl: employeeNotSort){
            employeeSort.add(empl);
        }
        ui.onPrintSort(employeeSort);
    }
    
    //внутренний класс со списком зарплат
    //создан для выполнения всех пунктов итогового задания
    class ListOfSalary implements Salary{
        private HashMap<Integer, Double> listOfSalary;

        public HashMap<Integer, Double> getListOfSalary() {
            return listOfSalary;
        }

        public void setListOfSalary(HashMap<Integer, Double> listOfSalary) {
            this.listOfSalary = listOfSalary;
        }

        
        //метод из интерфейса Salary, подразумевается что в разных компаниях
        //зарплату считают по-разному
        @Override
        public double getSalary(Employees employee) {
           return baseSalary*employee.getRate()+baseSalary*employee.getYearExperience()/100; 
        }
    }  
}
