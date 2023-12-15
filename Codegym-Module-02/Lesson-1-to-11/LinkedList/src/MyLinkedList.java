import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head;
    private int numNotes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNotes++;
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void addfirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNotes++;
    }
    public void removeFirst(){
        head = head.next;
        numNotes--;
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNotes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void remove(int index) {
        System.out.println("Removing: " + index + ". . .");
        if (index != 1) {
            Node temp = get(index - 1);
            Node tempPlus = temp.next.next;
            temp.next =tempPlus;
            numNotes--;
        }
        else{
            removeFirst();
        }
        printList();
    }
}
