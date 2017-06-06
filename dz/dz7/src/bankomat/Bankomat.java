package bankomat;

public class Bankomat {
    private int twenties;
    private int fifties;
    private int hundreds;
    
    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    
    public boolean onTouch(Bankomat bankomat, int amount){
        boolean get = listener.getMoney(bankomat, amount);
        if(get == false)
            return false;
        return true;
    }

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
    
}
