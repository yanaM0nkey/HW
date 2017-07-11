package view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import models.DownloaderThread;
import models.ParserThread;
import controllers.Root;


public class UI implements Listener{
    
    public static final String TYPEXML = "xml";
    public static final String TYPEJSON = "json";
    
    public void startUi(int answer){
        //переменная для работы с консолью
        boolean isOK = true;
        
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        downloaderThread.setParserThread(parserThread);
        
        //цикл будет работать пока пользователь не выберет 1/2(XML/JSON)
        while(isOK){
            try{
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
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println(error()); 
            }
        }
        
        downloaderThread.start();
        parserThread.start();
        
        try {
            parserThread.join();
            downloaderThread.join();
        } catch (InterruptedException ex) {
            System.out.println("!!!Ошибка " + ex.getMessage());
        }
        //System.out.println("-------------------------------------------------");
        
        Root root =  Root.getInstance();
        root.setUi(this);
        
        isOK = true;
        while(isOK){
            try{
                int answ = root.start();
                switch(answ){
                        case 1:
                            root.print();
                            break;
                        case 2:
                            root.printSalary();
                            break;
                        case 3:
                            root.printEmployee();
                            break;
                        case 4:
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
            //вспомогательная переменная для работы цикла
            boolean isOk = true;
            while(isOk){
                if(answer != -1){
                    try{
                        System.out.println(root.find(answer).toString());
                        isOk = false;
                    }catch(NullPointerException ex){
                        System.out.println(error());
                    } 
                }
                else{
                    System.out.println(error());
                    root.printEmployee();
            }
        }
    }
     

    @Override
    public void onPrintSort() {
        
    }
     
}

