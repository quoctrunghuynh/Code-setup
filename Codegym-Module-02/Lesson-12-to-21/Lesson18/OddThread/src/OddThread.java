public class OddThread implements Runnable {
    private Thread oddThread;
    private final String threadName;

    public OddThread(String name) {
        threadName = name;
        System.out.println("Creating thread " + threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("Odd number: " + i);
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException ie) {
            System.out.println("Odd number has been interrupted");
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (oddThread == null) {
            oddThread = new Thread(this, threadName);
            oddThread.start();
        }
    }
}
