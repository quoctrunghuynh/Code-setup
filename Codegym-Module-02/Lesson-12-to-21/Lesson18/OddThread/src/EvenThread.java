public class EvenThread implements Runnable {
    private Thread evenThread;
    private final String threadName;

    public EvenThread(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(" Even number: " + i);
                }
                Thread.sleep(15);
            }
        } catch (InterruptedException ie) {
            System.out.println("Even number has been interrupted! ");
        }
    }

    public void start() {
        System.out.println("Starting " + EvenThread.this);
        if (evenThread == null) {
            evenThread = new Thread(this, threadName);
            evenThread.start();
        }
    }
}
