package project;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
 
    public static final String TYPEXML = "xml";
    public static final String TYPEJSON = "json";
     
    public static void main(String[] args) {
        boolean isOK = false;
        DownloaderThread downloaderThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();
        downloaderThread.setParserThread(parserThread);
        Root root = new Root();
        
        //цикл будет работать пока пользователь не выберет 1/2(XML/JSON)
        while(isOK == false){
            try{
                System.out.println("введите 1, чтобы взять данный с XML файла\n" +
                                        "введите 2, чтобы взять данный с JSON файла\n");
                Scanner in = new Scanner(System.in);
                int answ = in.nextInt();
                switch(answ){
                    case 1:
                        downloaderThread.setTypeOfFile(TYPEXML);
                        parserThread.setTypeOfFile(TYPEXML);
                        isOK = true;
                        break;
                    case 2:
                        downloaderThread.setTypeOfFile(TYPEJSON);
                        parserThread.setTypeOfFile(TYPEJSON);
                        isOK = true;
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
        
        //parserThread.setDownloaderThread(downloaderThread);
        
        downloaderThread.start();
        parserThread.start();
        
        try {
            parserThread.join();
            downloaderThread.join();
        } catch (InterruptedException ex) {
            System.out.println("!!!Ошибка " + ex.getMessage());
        }
        root = parserThread.getRoot();
        System.out.println("-------------------------------------------------");
        System.out.println(root.toString());
        
       
        
    }
}
