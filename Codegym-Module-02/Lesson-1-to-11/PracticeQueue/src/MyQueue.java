public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;

    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add more User!!" +
                    " This user will not be added: " + item);
        } else {
            tail++;
            if (tail == capacity - 1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("User " + item + " is pushed to the queue !");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove any work !!!");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop operation done !" +
                        " Remove " + queueArr[head - 1] + " succeed");
                head = 0;
            } else {
                System.out.println("Pop operation done !" +
                        " Remove " + queueArr[head - 1] + " succeed");
            }
            currentSize--;
        }
    }
}
