package dz18;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        
        MyTest myTest = new MyTest();
        
        Class clas = myTest.getClass(); 
        
        System.out.println(clas.getSimpleName());
        System.out.println(clas.getName());
        
        
        
        int mode = clas.getModifiers();
        if(Modifier.isPublic(mode)){
            System.out.println("класс публичный "); 
        }
        
        Field[] fields = clas.getDeclaredFields();
        for(Field f: fields){
            System.out.println("переменная " + f.getName());
            try {
                f.setAccessible(true);
                Object obj = f.get(myTest);
                if(obj instanceof String){
                    System.out.println("value " + (String)obj);
                    f.set(myTest, "java");
                    System.out.println("value " + (String)f.get(myTest) );
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
}
