package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Files {
    
    //private static String text = "This new text";
    private static String fileName = "E://CW/CW10/src/files/file2.txt";
    
    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner in = new Scanner(System.in);
        String text;
        System.out.println("New text: ");
        text= in.nextLine();*/
        File file = new File(fileName);
        Student [] students = new Student[3];
        for(int i = 0; i < students.length; i++){
            students[i] = new Student();
        }
        
        //write(fileName, text,file);
        //Чтение файла
        read(fileName, file, students);
        for(int i = 0; i < students.length; i++){
            System.out.println(i + students[i].getName() + students[i].getAge() + students[i].isIsZaochnik());
        }
    }
    
    public static void write(String fileName, String text, File file) {
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void read(String fileName, File file, Student [] students) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                int k = 0;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    
                    String textFromFile = sb.toString();
                    String[] isbnParts = textFromFile.split("&");
                    for(int i = 0; i < isbnParts.length; i++){
                        System.out.println(isbnParts[i]);
                    }
                    String name2 = isbnParts[1+3*k];
                    System.out.println("------" + name2);
                    int age2 = Integer.valueOf(isbnParts[2+3*k]);
                    System.out.println("------" + age2);
                    boolean isZaochnik2 = Boolean.valueOf(isbnParts[3+3*k]);
                    System.out.println("------" + isZaochnik2);
                    
                    students[k].setName(name2);
                    students[k].setAge(age2);
                    students[k].setIsZaochnik(isZaochnik2);
                    sb.append("\n");
                    k++;
                    
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    //проверка на существование файла
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
}
    
    public static class Student{
        private String name;
        private int age;
        private boolean isZaochnik;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isIsZaochnik() {
            return isZaochnik;
        }

        public void setIsZaochnik(boolean isZaochnik) {
            this.isZaochnik = isZaochnik;
        }
        
    }
}











