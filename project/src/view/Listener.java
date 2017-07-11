package view;

import controllers.Root;
import java.util.HashMap;


public interface Listener {
     public void onPrint(Root root);
     public void onPrintSalary(Root root);
     public void onPrintEmployee(Root root, int answer);
     public void onPrintSort();
    
}
