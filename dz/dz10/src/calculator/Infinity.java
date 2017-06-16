package calculator;


public class Infinity extends Exception{
    private String error;

    public String getRussianMessage() {
        return error;
    }

    public Infinity(String error) {
        this.error = error;
    }
    

      
}
