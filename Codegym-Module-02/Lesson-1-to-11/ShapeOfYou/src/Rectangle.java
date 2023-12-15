public class Rectangle extends Shape implements Resizable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void Resize(double Percentage) {
        double newLength = getLength()+(getLength()*Percentage)/100;
        double newWidth = getWidth()+(getWidth()*Percentage)/100;
        System.out.println("Rectangle: "+Percentage);
        System.out.println("New Rectangle has old width= "+getWidth()+
                " now has new width ="+newWidth);
        System.out.println("New Rectangle has length= "+getLength()+
                " now has new length ="+newLength);
    }
}