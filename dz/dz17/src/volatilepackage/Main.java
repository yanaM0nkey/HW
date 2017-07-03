package volatilepackage;

//����� ���� ����� ������ ����������� �� �������� ���������� ������������� � ������ ������.
//��� ������� ������ ���������� btExit �������������� � true. 
//�� ��� volatile ����� ����� ���������� ��� ���������.

public class Main {
    // ������� ���������� ��� volatile
    volatile private boolean btExit = false;
    volatile private boolean isRunning = true;

    // ������ ��� ������������� ������
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

    // ������ ��� �������� ������
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

    // ������ �������
    public void start() {
        new Thread(gui).start();
        new Thread(game).start();
    }
   

    public static void main(String[] args) {
        new Main().start();
    }

    
}
