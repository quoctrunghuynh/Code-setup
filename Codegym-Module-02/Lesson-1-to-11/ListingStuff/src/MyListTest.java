public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.addElement(1);
        listInteger.addElement(2);
        listInteger.addElement(3);
        listInteger.addElement(3);
        listInteger.addElement(4);

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }
}
