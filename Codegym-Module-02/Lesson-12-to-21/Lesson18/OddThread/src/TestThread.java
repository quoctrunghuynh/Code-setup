public class TestThread {
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread("evenThread");
        evenThread.start();

        OddThread oddThread = new OddThread("oddThread");
        oddThread.start();
    }
}
