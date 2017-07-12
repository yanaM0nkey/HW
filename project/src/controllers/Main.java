package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;
import view.UI;

public class Main {
 
    public static void main(String[] args){
        UI ui = new UI();
        ui.startUi();
    }
   
    public int startInMain(){
        //переменная для работы с консолью
        boolean isOK = true;
        //цикл будет работать пока пользователь не выберет 1/2(XML/JSON)
        while(isOK){
            try{
                System.out.println("введите 1, чтобы взять данный с XML файла\n" +
                                                "введите 2, чтобы взять данный с JSON файла\n");
                Scanner in = new Scanner(System.in);
                int answer = in.nextInt();
                if(answer !=1 && answer !=2)
                    throw new InputMismatchException();
                else{
                    isOK = false;
                    return answer;
                }
            }
            catch(InputMismatchException e){
                return 0;
            }
        }
        return 0;
    }
}
