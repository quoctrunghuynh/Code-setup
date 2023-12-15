public class Runner {
    public static void main(String[] args) {
        NumberGenerator numberGenerator1 = new NumberGenerator();
        NumberGenerator numberGenerator2 = new NumberGenerator();

        Thread thread1 = new Thread(numberGenerator1);
        Thread thread2 = new Thread(numberGenerator2);

        thread1.setPriority(1);
        thread2.setPriority(10);

        thread1.start();
        System.out.println("Genrator 1 :" + thread1.hashCode());
        thread2.start();
        System.out.println("Genrator 2 :" + thread2.hashCode());

    }
}
