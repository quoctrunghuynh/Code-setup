public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10.0);
        System.out.println(circle);
        System.out.println(circle.getArea());

        Cylinder cylinder =new Cylinder(2);
        cylinder.setRadius(10);
        System.out.println(cylinder.getArea());
    }
}
