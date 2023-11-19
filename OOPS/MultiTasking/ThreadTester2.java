package MultiTasking;

public class ThreadTester2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread2" +Thread.currentThread() + " " + i);
        }
    }
    
}
