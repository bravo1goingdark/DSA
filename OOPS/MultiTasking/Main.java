import ThreadTester.Increment;

public class Main {
    public static void main(String[] args) {
        System.out.println("main is starting");
        Thread[] thread = new Thread[5];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new ThreadTester();
            thread[i].start();
        }
        for (int i = 0; i < thread.length; i++) {
            try {
                thread[i].join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(ThreadTester.Increment.getCount());

        System.out.println("main is exiting");
    }
}
