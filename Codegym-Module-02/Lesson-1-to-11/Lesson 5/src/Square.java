public class Square extends Rectangle {
    private double side;

    public Square() {
        this.side = 1.0;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "A square with side=" + this.side + ", which is a subclass of " + super.toString();
    }

    public double getArea(double side) {
        this.side = side;
        return Math.pow(this.side, 2);
    }

    public double getPerimeter(double side) {
        return side * 4;
    }
}
