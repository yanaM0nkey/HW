package dz12;


public class People {
    private int age;
    private int id;
    private boolean isDegree;
    private String name;
    private String surname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDegree() {
        return isDegree;
    }

    public void setIsDegree(boolean isDegree) {
        this.isDegree = isDegree;
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
    
    @Override
    public String toString() {
        return "People{" + "age=" + age + ", id=" + id + ", isDegree=" + isDegree + ", name=" + name + ", surname=" + surname + '}';
    }
    
    
   /* private String title;
    private String autor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public People(String title, String autor) {
        this.title = title;
        this.autor = autor;
    }
    
    public People(){
        
    }

    @Override
    public String toString() {
        return "People{" + "title=" + title + ", autor=" + autor + '}';
    }*/
 
}
