public class NumberGenerator implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Printing the number: " + i + " of " +
                        Thread.currentThread().hashCode() + " thread: " + Thread.currentThread());
                Thread.sleep(500);
            }
        } catch (InterruptedException ie) {
            System.out.println("Simple Thread is being interrupted, close now...");
        }
        System.out.println("My thread is over");
    }
}
