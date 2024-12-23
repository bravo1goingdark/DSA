

public class ThreadTester extends Thread {

    public ThreadTester(){
        
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            Increment.incrementCounter();
        }
        System.out.println(Increment.getCount());
    }
    public static class Increment {
        public static int count = 0;


        public static int getCount(){
            return count;
        }

        public static synchronized void incrementCounter(){
            count++;
        }
    }
}
