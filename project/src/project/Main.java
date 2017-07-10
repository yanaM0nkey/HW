package project;

import threads.DownloaderThread;
import threads.ParserThread;
import data.Root;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class Main {
 
    public static final String TYPEXML = "xml";
    public static final String TYPEJSON = "json";
     
    public static void main(String[] args) {
        //переменная для работы с консолью
        boolean isOK = true;
        
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        downloaderThread.setParserThread(parserThread);
        
  
        //цикл будет работать пока пользователь не выберет 1/2(XML/JSON)
        while(isOK){
            try{
                System.out.println("введите 1, чтобы взять данный с XML файла\n" +
                                        "введите 2, чтобы взять данный с JSON файла\n");
                Scanner in = new Scanner(System.in);
                int answ = in.nextInt();
                switch(answ){
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
        HashMap<Integer, Double> listOfSalary = root.getListOfSalary();
        
        isOK = true;
        while(isOK){
            try{
                System.out.println("введите 1, чтобы вывести всю информацию\n" + 
                    "введите 2, чтобы вывести зарплату на экран\n" + 
                    "введите 3, чтобы найти сотрудника по id\n" + 
                    "введите 4, чтобы отсортировать по уровню зарплаты\n" + 
                    "введите 5 для завершения работы\n");
                Scanner in = new Scanner(System.in);
                int answ = in.nextInt();
                switch(answ){
                        case 1:
                            System.out.println(root.toString());
                            break;
                        case 2:
                            //создали хэш-карточку, для красивого вывода на экран
                            Map<Integer, Double> hashMap = listOfSalary;
                            for (Map.Entry entry : hashMap.entrySet()) {
                                System.out.println("id: " + entry.getKey() 
                                    + " salary: " + entry.getValue());
                            }
                            break;
                        case 3:
                            //вспомогательная переменная для работы цикла
                            boolean isOk = true;
                            while(isOk){
                                try{
                                    System.out.println("введите id сотрудника");
                                    Scanner in2 = new Scanner(System.in);
                                    int answ2 = in2.nextInt();
                                    try{
                                        System.out.println(root.find(answ2).toString());
                                        isOk = false;
                                    }catch(NullPointerException ex){
                                        System.out.println(error());
                                    }  
                                }catch(InputMismatchException e){    
                                    System.out.println(error()); 
                                }
                            }
                            break;
                        case 4:
                            //тут должен быть вывод списка с сортировкой
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
    public static String error(){
        return "!!!Неправильный ввод, попробуйте еще раз";
    }
}
