package bankomat;

import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        UI ui = new UI();
        System.out.println("введите 1, чтобы взять данный с XML файла\n" +
                                        "введите 2, чтобы взять данный с JSON файла\n");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        ui.startUi(answer);
        
    }
}

