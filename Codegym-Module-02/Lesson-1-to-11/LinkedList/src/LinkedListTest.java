public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList Pachi = new MyLinkedList(0);
        Pachi.add(1,1);
        Pachi.add(2,2);
        Pachi.add(3,3);
        Pachi.add(4,4);
        Pachi.add(5,5);
        Pachi.add(6,6);
        Pachi.add(7,7);
        Pachi.add(8,8);
        Pachi.add(9,9);

        Pachi.printList();
        System.out.println();
        Pachi.removeFirst();
        Pachi.printList();
    }
}
