class SharedCounter {
    private static int counter = 0;

    public static synchronized void incrementCounter() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}

class IncrementThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SharedCounter.incrementCounter();
        }
    }
}

public class ConcurrentCounterExample {
    public static void main(String[] args) {
        int numThreads = 5;
        IncrementThread[] threads = new IncrementThread[numThreads];

        // Create and start multiple threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new IncrementThread();
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final counter value
        System.out.println("Final Counter Value: " + SharedCounter.getCounter());
    }
}
