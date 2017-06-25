package singletone;


public class Var2 {

    private Var2(){}
    
    private static class SingletonHelper{
        private static final Var2 INSTANCE = new Var2();
    }
    
    public static Var2 getInstance(){
        return SingletonHelper.INSTANCE;
    }
}