public class test {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(11);
        queue.enQueue(12);
        queue.deQueue();
        queue.enQueue(13);
        queue.enQueue(14);
        queue.enQueue(15);
        queue.enQueue(16);
        queue.displayQueue();
        queue.deQueue();
        queue.deQueue();
        queue.displayQueue();
    }
}
