package bankomat;


public class UI{
    public void startUi(){
        Bankomat bankomat = new Bankomat(0,0,0);
        bankomat.setUi(new OnBankomatListener() {
            @Override
            public void onGetMoney(boolean isOk) {
                if(isOk){
                    System.out.println("Деньги отправлены на счет");
                } else {
                    System.out.println("Ошибка, обратитесь в банк");
                }
            }

            @Override
            public void onAppMoney(int money) {
                if(money > 0){
                    System.out.println("Деньги получены");
                } else {
                    System.out.println("Ошибка, обратитесь в банк");
                }
            }
        });        
        bankomat.appMoney();
        bankomat.getMoney();
        
    }
    
}
