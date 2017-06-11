package bankomat;

import java.util.Scanner;

public class Bankomat {
    private int twenties;
    private int fifties;
    private int hundreds;
    private OnBankomatListener ui = null;

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public Bankomat(int twenties, int fifties, int hundreds) {
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }
    

    public void setUi(OnBankomatListener ui) {
        this.ui = ui;
    }
    
    public int sum(){
        return getTwenties()*20 + getFifties()*50 + getHundreds()*100;
                
    }
    public void appMoney(){
        int sum0 = sum(); 
        System.out.println("Do you want to set money? (yes/no)");
        Scanner in = new Scanner(System.in);
        String ans = in.nextLine();
        if(ans.equals("yes")){
            System.out.println("Enter sum of twenties");
            Scanner in2 = new Scanner(System.in);
            int tw = in2.nextInt();
            System.out.println("Enter sum of fifties");
            Scanner in3 = new Scanner(System.in);
            int fift = in3.nextInt();
            System.out.println("Enter sum of hundreds");
            Scanner in4 = new Scanner(System.in);
            int hund = in4.nextInt();
            setTwenties(getTwenties() + tw);
            setFifties(getFifties() + fift);
            setHundreds(getHundreds() + hund);            
        }     
        System.out.println("20:" + getTwenties() + " 50:" + getFifties() + " 100:" + getHundreds());
        int sum1 = sum();
        ui.onAppMoney(sum1-sum0);
        
    }
    
    public void getMoney(){
        boolean isOk = true;
        System.out.println("Do you want to get money? (yes/no)");
        Scanner in = new Scanner(System.in);
        String ans = /*"yes";*/in.nextLine();
        if(ans.equals("yes")){
            System.out.println("Enter amount of money");
            Scanner in2 = new Scanner(System.in);
            int amount = in2.nextInt();
            if(amount == 10 || amount == 30){
                System.out.println("There is no such amount");
                System.exit(0);
            }
            int h = 0;
            int f = 0;
            int tw = 0;
            if(amount%10 != 0)
                isOk = false;
            int sum = sum();
            if(amount > sum)
                isOk = false;
            while(amount != 0){
                if(amount >= 200){
                    amount-=100;
                    h++;
                }else{
                    int ost = amount%100;
                    switch(ost){
                        case 10:
                            f++;
                            tw+=3;
                            amount-=110;
                            break;
                        case 30:
                            f++;
                            tw+=4;
                            amount-=130;
                            break;
                        case 60:
                            tw+=3;
                            amount-=60;
                            break;
                        case 80:
                            tw+=4;
                            amount-=80;
                            break;
                        default:
                            int k = amount/100;
                            h+=k;
                            amount-=k*100;
                            k = amount/50;
                            f+=k;
                            amount-=k*50;
                            k = amount/20;
                            tw+=k;
                            amount-=k*20;
                            break;
                    }       
                }
            }
            

            if(h > getHundreds()){
                h-=getHundreds();
                int f2 = f+2*h;
                if(f2 > getFifties()){
                    h-= getFifties()/2;
                    f+= 2*(getFifties()/2);
                    tw+=5*h;
                    h=0;
                }
                else
                    f+=2*h;
            }
            if(f > getFifties())
                isOk = false;
            if(tw > getTwenties())
                isOk = false;
            System.out.println("Get 20:" + tw + " 50:" + f + " 100:" + h);
            setTwenties(getTwenties() - tw);
            setFifties(getFifties() - f);
            setHundreds(getHundreds() - h);
        }
        System.out.println("After getMoney 20:" + getTwenties() + " 50:" + getFifties() + " 100:" + getHundreds());
       ui.onGetMoney(isOk);
    }
    
    
    
    
    
    
    
    
}
