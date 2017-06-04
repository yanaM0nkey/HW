package bankomat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Bankomat bankomat  = new Bankomat(0,0,0);
        addMoney(bankomat,10,10,10);
        //addMoney(bankomat,10,2,3);
        System.out.println("20:" + bankomat.getTwenties() + " 50:" + bankomat.getFifties() + " 100:" + bankomat.getHundreds());
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
            boolean get = getMoney(bankomat, amount);
            if (get == false)
                System.out.println("It's impossible to give out such an amount of money");
        }
        System.out.println("After getMoney 20:" + bankomat.getTwenties() + " 50:" + bankomat.getFifties() + " 100:" + bankomat.getHundreds());    
    }
    public static boolean getMoney(Bankomat bankomat, int amount){
        int h = 0;
        int f = 0;
        int tw = 0;
        if(amount%10 != 0)
            return false;
        int sum = 100*bankomat.getHundreds() + 50*bankomat.getFifties() + 20*bankomat.getTwenties();
        if(amount > sum)
            return false;
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
        //System.out.println("20:" + tw + " 50:" + f + " 100:" + h);
        
        if(h > bankomat.getHundreds()){
            h-=bankomat.getHundreds();
            int f2 = f+2*h;
            if(f2 > bankomat.getFifties()){
                h-= bankomat.getFifties()/2;
                f+= 2*(bankomat.getFifties()/2);
                tw+=5*h;
                h=0;
            }
            else
                f+=2*h;
        }
        if(f > bankomat.getFifties())
            return false;
        if(tw > bankomat.getTwenties())
            return false;
        System.out.println("Get 20:" + tw + " 50:" + f + " 100:" + h);
        bankomat.setTwenties(bankomat.getTwenties() - tw);
        bankomat.setFifties(bankomat.getFifties() - f);
        bankomat.setHundreds(bankomat.getHundreds() - h);
        return true;    
    }
    
    public static void addMoney(Bankomat bankomat, int twenties, int fifties, int hundreds){
       bankomat.setTwenties(bankomat.getTwenties() + twenties);
       bankomat.setFifties(bankomat.getFifties() + fifties);
       bankomat.setHundreds(bankomat.getHundreds() + hundreds);
    }
}

