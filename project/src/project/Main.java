package project;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
 
    public static final String TYPEXML = "xml";
    public static final String TYPEJSON = "json";
     
    public static void main(String[] args) {
        //переменная для работы с консолью
        boolean isOK = true;
        
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        downloaderThread.setParserThread(parserThread);
        Root root =  Root.getInstance();
  
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
                        System.out.println("!!!Неправильный ввод ответа, попробуйте еще раз");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("!!!Неправильный ввод ответа, попробуйте еще раз"); 
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
        root = parserThread.getRoot();
        //System.out.println("-------------------------------------------------");
        
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
                            
                            break;
                        case 4:
                            break;
                        case 5:
                            isOK = false;
                            break;
                        default:
                            System.out.println("!!!Неправильный ввод ответа, попробуйте еще раз");
                            break;
                    }
            }
            catch(InputMismatchException e){
                System.out.println("!!!Неправильный ввод ответа, попробуйте еще раз"); 
            }
        }
         
    }
}
