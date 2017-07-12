package view;

import controllers.Main;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import models.DownloaderThread;
import models.ParserThread;
import controllers.Root;
import java.text.SimpleDateFormat;
import java.util.TreeSet;
import models.Employees;


public class UI implements Listener{
    
    public static final String TYPEXML = "xml";
    public static final String TYPEJSON = "json";
    
    public void startUi(){
        
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        downloaderThread.setParserThread(parserThread);
        Main main = new Main();
        //грубо говоря вызов консоли
        int answer = main.startInMain();//возвратит ответ выбора типа файла
        boolean isOK = true;
        while(isOK){
            switch(answer){
                case 1:
                    downloaderThread.setTypeOfFile(TYPEXML);
                    parserThread.setTypeOfFile(TYPEXML);
                    isOK = false;
                    break;
                case 2:
                    downloaderThread.setTypeOfFile(TYPEJSON);
                    parserThread.setTypeOfFile(TYPEJSON);
                    isOK = false;
                    break;
                default:
                    System.out.println(error());
                    answer = main.startInMain();
                    break;
            }
        }
        
        //далее запустим потоки скачки и парсинга
        downloaderThread.start();
        parserThread.start();
        
        //ждем завершения потоков
        try {
            parserThread.join();
            downloaderThread.join();
        } catch (InterruptedException ex) {
            System.out.println("!!!Ошибка " + ex.getMessage());
        }
        
        Root root =  Root.getInstance();
        root.setUi(this);
        
        isOK = true;
        while(isOK){
            try{
                //вызываем метод start который возратит ответ с консоли о дальнейших действиях
                int answ = root.start();
                switch(answ){
                        case 1:
                            //вывод всей информации
                            root.print();
                            break;
                        case 2:
                            //вывод зарплаты
                            root.printSalary();
                            break;
                        case 3:
                            //поиск сотрудника
                            root.printEmployee();
                            break;
                        case 4:
                            //сортированный список сотрудников по ФИО
                            root.printSort();
                            break;
                        case 5:
                            isOK = false;
                            break;
                        default:
                            System.out.println(error());
                            break;
                    }
            }
            catch(InputMismatchException e){
                System.out.println(error()); 
            }
        }   
    }
    public String error(){
        return "!!!Неправильный ввод, попробуйте еще раз";
    }
        
    @Override
    public void onPrint(Root root) {
        if(root != null)
            System.out.println(root.toString());
        else
            System.out.println("!!!Ошибка");
    }

    @Override
    public void onPrintSalary(Root root) {
        if(root != null){
            //создали хэш-карточку, для красивого вывода на экран
            HashMap<Integer, Double> listOfSalary = root.getListOfSalary();
            Map<Integer, Double> hashMap = listOfSalary;
            for (Map.Entry entry : hashMap.entrySet()) {
                System.out.println("id: " + entry.getKey() 
                    + " salary: " + entry.getValue());
            }
        }
        else
            System.out.println("!!!Ошибка");
    }

    @Override
    public void onPrintEmployee(Root root, int answer) {   
        if(answer != -1){
            try{
                System.out.println(root.find(answer).toString());
            }catch(NullPointerException ex){
                System.out.println(error());
                root.printEmployee();
            } 
        }
        else{
            System.out.println(error());
            root.printEmployee();
        }
    }
    
    @Override
    public void onPrintSort(TreeSet<Employees> employees) {
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd");
        for(Employees e : employees) {
            System.out.println("\n"+"Employees{" + "name=" + e.getName() + ", id=" + e.getId() + ", degree=" + 
                e.getDegree() + ", dateOfBirth=" + formatForDate.format(e.getDateOfBirth())+ ", yearExperience=" + 
                e.getYearExperience() + ", rate=" + e.getRate() + ", emails=" + e.getEmails() + 
                ", isVisible=" + e.isIsVisible() + '}');
        }
        
    }
     
}

