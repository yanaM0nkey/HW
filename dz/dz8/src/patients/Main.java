package patients;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Main {

    public static void main(String[] args) throws ParseException {
        Patient [] patients = new Patient[3];
        System.out.println("Add inf about patient");
        for(int i = 0; i < patients.length; i++){
            patients[i] = new Patient();
            patients[i].printIn();   
        }
        printOut(patients);
        averageAge(patients); 
    }
    
    public static void averageAge(Patient[] patients){
        int [] ages = new int[patients.length];
        int [] months = new int[patients.length];
        for(int i = 0; i < patients.length; i++){
            Calendar dob = Calendar.getInstance();
            Calendar today = Calendar.getInstance();

            dob.setTime(patients[i].getDateOfBirth());

            ages[i] = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            months[i] = Math.abs(today.get(Calendar.MONTH) - dob.get(Calendar.MONTH));
        }
        int month = 0;
        for (int i = 0; i < ages.length; i++){
            month += ages[i]*12 + months[i];      
        }
        month = month/patients.length;
        int averageYear = month/12;
        int averageMonth = month%12;
        String year1;
        String month1;
        switch(averageYear){
            case 1:
                year1 = "year";
                break;
            default:
                year1 = "years";
                break;
        } 
        switch(averageMonth){
            case 1:
                month1 = "month";
                break;
            default:
                month1 = "months";
                break;
        }
        System.out.println("Average age: " + averageYear + year1 + "  " + averageMonth + month1);
            
    }
    
    public static void printOut(Patient[] patients){
        SimpleDateFormat sf = new SimpleDateFormat();
        sf.applyPattern("dd.MM.yyyy");
        String dateString; 
        for (int i = 0; i < patients.length; i++){
            dateString = sf.format(patients[i].getDateOfBirth());
            System.out.println("patient " + patients[i].getName() + " " + patients[i].getSurname() + " " + dateString);
        }
        
    }
    
    
}
