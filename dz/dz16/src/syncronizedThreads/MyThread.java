package syncronizedThreads;




public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 50; i++){
            Main.print10(getName());
        }
    }
    
    
}
