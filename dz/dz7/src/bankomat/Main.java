package bankomat;

import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        UI ui = new UI();
        System.out.println("������� 1, ����� ����� ������ � XML �����\n" +
                                        "������� 2, ����� ����� ������ � JSON �����\n");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        ui.startUi(answer);
        
    }
}

