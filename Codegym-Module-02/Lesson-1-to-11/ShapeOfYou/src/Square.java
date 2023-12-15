public class Square extends Shape implements Resizable{
    private double sides;

    public Square() {
        this.sides = 1;
    }

    public Square(double sides) {
        this.sides = sides;
    }

    public Square(String color, boolean filled, double sides) {
        super(color, filled);
        this.sides = sides;
    }

    public double getSides() {
        return sides;
    }

    public void setSides(double sides) {
        this.sides = sides;
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSides()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void Resize(double Percentage) {
        double newSides = getSides()+(getSides()*Percentage)/100;
        System.out.println("Square: "+Percentage);
        System.out.println("New Square has old sides = "+getSides()+
                " now has new sides= "+newSides);
    }
}
