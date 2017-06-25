package singletone;

public class Var1 {
    
    private static Var1 instance;
   
    private Var1(){}

    //���� ����������� ������������� � ������������ ��������� �������������� ��������
    static{
      try{
        instance = new Var1();
      }catch(Exception e){
        throw new RuntimeException("��� �������� ������� �Singleton� ��������� ������");
      }
    }

    public static Var1 getInstance(){
      return instance;
    } 
}
