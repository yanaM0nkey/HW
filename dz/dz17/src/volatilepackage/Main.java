package volatilepackage;

//когда один поток должен завершиться по значению переменной отслеживаемой в другом потоке.
//при нажатии кнопки переменная btExit устнавливается в true. 
//Но без volatile поток может пропустить это изменение.

public class Main {
    // вначале попробуйте без volatile
    volatile private boolean btExit = false;
    volatile private boolean isRunning = true;

    // задача для интерфейсного потока
    Runnable gui = new Runnable() {

        @Override
        public void run() {
            int k=-1;
            while (isRunning) {
                try {
                    k = System.in.read() ;
                    btExit = k>=0;
                    System.out.println("gui input: "+k);
                } catch (Exception e) {
                }
            }
            System.out.println("gui thread finished");
        }
    };

    // задача для игрового потока
    Runnable game = new Runnable() {

        @Override
        public void run() {
            int k=1;
            while (!btExit) {
                k+=k;
                k%=100;              
                System.out.print("");
            }
            isRunning=false;
            System.out.println("game thread finished");
        }
    };

    // запуск потоков
    public void start() {
        new Thread(gui).start();
        new Thread(game).start();
    }
   

    public static void main(String[] args) {
        new Main().start();
    }

    
}
