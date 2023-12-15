public class Cylinder extends Circle {
    private double height;

    public Cylinder(){System.out.println("Cylinder is working here");}
    public Cylinder(double height){
        this.height =height;
        System.out.println("Cylinder with height is working here");
    }

    public double getHeight(){return this.height;}

    public void setHeight(double height){this.height=height;}

    public double getArea(){
        return super.getArea()*getHeight();
    }

    @Override
    public String toString(){
        return "This is Cylinder's Area "+getArea();
    }
}
