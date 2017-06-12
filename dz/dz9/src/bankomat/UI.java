package bankomat;


public class UI{
    public void startUi(){
        Bankomat bankomat = new Bankomat(0,0,0);
        bankomat.setUi(new OnBankomatListener() {
            @Override
            public void onGetMoney(boolean isOk) {
                if(isOk){
                    System.out.println("������ ���������� �� ����");
                } else {
                    System.out.println("������, ���������� � ����");
                }
            }

            @Override
            public void onAppMoney(int money) {
                if(money > 0){
                    System.out.println("������ ��������");
                } else {
                    System.out.println("������, ���������� � ����");
                }
            }
        });        
        bankomat.appMoney();
        bankomat.getMoney();
        
    }
    
}
