public class Circle extends Shape {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
        System.out.println(this.radius);
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "A circle with radius = " + this.radius + ", which is a subclass of " + super.toString();
    }
}
