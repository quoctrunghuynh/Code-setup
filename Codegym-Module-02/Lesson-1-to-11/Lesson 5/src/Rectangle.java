public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(double height, double width) {
        this.height = height;
        this.width = width;
        return this.height * this.width;
    }

    public double getPerimeter(double height, double width) {
        this.height = height;
        this.width = width;
        return (this.width + this.height) * 2;
    }
}
