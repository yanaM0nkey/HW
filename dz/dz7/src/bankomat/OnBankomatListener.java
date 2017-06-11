package bankomat;


public interface OnBankomatListener {
     public void onGetMoney(boolean isOk);
     public void onAppMoney(int value);
    
}
