package models;

import com.google.gson.annotations.SerializedName;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Employees {
    private int id;
    private String name;
    private String degree;
    private Date dateOfBirth;
    @SerializedName("yearEperience")//есть отличие с json
    private int yearExperience;
    private double rate;    
    private ArrayList<String> emails = new ArrayList<>();
    @SerializedName("visible")//есть отличие с json
    private boolean isVisible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy-MM-dd");
        return "\n"+"Employees{" + "id=" + id + ", name=" + name + ", degree=" + 
                degree + ", dateOfBirth=" + formatForDate.format(dateOfBirth)+ ", yearExperience=" + 
                yearExperience + ", rate=" + rate + ", emails=" + emails + 
                ", isVisible=" + isVisible + '}';
    }
    
    
   
 
  
    
    
}
