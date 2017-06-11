package patients;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Patient {
    
    private String name;
    private String surname;
    private Date dateOfBirth;

    public Patient() {
    }

    public Patient(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public void printIn() throws ParseException{
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String dateOfBirth1;
        System.out.println("Name: ");
        name = s.nextLine();
        System.out.println("Surname: ");
        surname = s1.nextLine();
        System.out.println("Date of birth: day.month.year");
        dateOfBirth1 = s2.nextLine();
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        dateOfBirth = format.parse(dateOfBirth1);  
    }
    
  
}
