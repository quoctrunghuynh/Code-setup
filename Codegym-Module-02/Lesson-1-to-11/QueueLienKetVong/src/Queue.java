public class Queue implements Solution {
    private Node front;
    private Node rear;

    @Override
    public void enQueue(int data) {
        Node node = new Node(data);
        if (front == null) {
            front = rear = node;
        } else {
            Node temp = rear;
            temp.link=node;
            rear = node;
            rear.link = front;
        }
    }

    @Override
    public void deQueue() {
        if (front == null) {
            System.out.println("Queue is empty can't deQueue");
        } else {
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.link;
                rear.link = front;
            }
        }
    }

    @Override
    public void displayQueue() {
        System.out.println(front.getData());
        Node temp = front.link;
        while(temp != front ){
            System.out.println(temp.getData());
            temp = temp.link;
        }
    }
}
