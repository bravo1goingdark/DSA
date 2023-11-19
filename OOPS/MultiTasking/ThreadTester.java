package MultiTasking;

public class ThreadTester extends Thread {

    public ThreadTester(){
        
    }
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("inside"+Thread.currentThread()+" " + i);
        }
    }
}
