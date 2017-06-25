package singletone;

public class Var1 {
    
    private static Var1 instance;
   
    private Var1(){}

    //блок статической инициализации с возможностью обработки исключительных ситуаций
    static{
      try{
        instance = new Var1();
      }catch(Exception e){
        throw new RuntimeException("При создании объекта «Singleton» произошла ошибка");
      }
    }

    public static Var1 getInstance(){
      return instance;
    } 
}
