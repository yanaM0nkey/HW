package singletone;

public class Var3 {
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static Var3 instance;
 
  private Var3(){}
 
 //synchronized method to control simultaneous access
  synchronized public static Var3 getInstance() {
    if (instance == null) {
      instance = new Var3();
    }
    return instance;
  }
}