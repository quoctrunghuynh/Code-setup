public class Circle {
    private double radius;

    public Circle() {
        this.radius=1.0;
        System.out.println("Circle is working here. . .");
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        System.out.println("this is Circle area: "+ Math.pow(getRadius(), 2) * Math.PI);
        return Math.pow(getRadius(), 2) * Math.PI;
    }
    @Override
    public String toString(){
        return "This is the circle with radius= "+this.radius;
    }
}
