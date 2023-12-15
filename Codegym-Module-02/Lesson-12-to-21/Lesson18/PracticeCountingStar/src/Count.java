public class Count implements Runnable {
    private final Thread myThread;

    public Count() {
        myThread = new Thread(this, "My runnable thread");
        System.out.println("My thread created " + myThread);
        myThread.start();
    }

    public Thread getMyThread() {
        return myThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 11; i++) {
                System.out.println("Print the number : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            System.out.println("My thread interrupted");
        }
        System.out.println("My thread is done");
    }
}
