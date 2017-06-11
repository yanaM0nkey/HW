package bankomat;


public class UI implements OnBankomatListener{
    public void startUi(){
        Bankomat bankomat = new Bankomat(0,0,0);
        bankomat.setUi(this);        
        bankomat.appMoney();
        bankomat.getMoney();
        
    }
    
    @Override
    public void onAppMoney(int money){
        if(money > 0){
            System.out.println("������ ��������");
        } else {
            System.out.println("������, ���������� � ����");
        }
    }
    
    @Override
    public void onGetMoney(boolean isOk){
        if(isOk){
            System.out.println("������ ���������� �� ����");
        } else {
            System.out.println("������, ���������� � ����");
        }
    }
    
}
