public class MyStack {
    private int arr[];
    private int size;
    private int index;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {
        if (isFull()) {
            throw new StackOverflowError("It's full");
        }
        arr[index] = element;
        index++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Nothing to pop");
        }
        return arr[--index];
    }

    public int size(){
        return this.size;
    }
    private boolean isFull() {
        return index == size;
    }

    private boolean isEmpty() {
        return index == 0;
    }

}
