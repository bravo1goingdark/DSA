package MultiTasking;

public class Main {
    public static void main(String[] args) {
        System.out.println("main is starting");
        Thread thread1 = new ThreadTester();
        Thread thread2 = new Thread(new ThreadTester2());
        thread1.start();
        thread2.start();

        System.out.println("main is exiting");
    }
}
