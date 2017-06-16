package people;


public class Person {
    private String name;
    private String surname;
    private String nameOfFather;

    public Person(String name, String surname, String nameOfFather) {
        this.name = name;
        this.surname = surname;
        this.nameOfFather = nameOfFather;
    }
    
    public Person() {
        
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

    public String getNameOfFather() {
        return nameOfFather;
    }

    public void setNameOfFather(String nameOfFather) {
        this.nameOfFather = nameOfFather;
    }
    
    
}
