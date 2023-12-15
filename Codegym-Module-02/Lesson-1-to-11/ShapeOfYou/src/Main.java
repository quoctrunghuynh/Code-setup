import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Shape[] shapes = new Shape[3];
        shapes[0]= new Circle();
        shapes[1]= new Rectangle();
        shapes[2]= new Square();

        for(Shape shape : shapes){
            if(shape instanceof Resizable ){
                ((Resizable) shape).Resize(random.nextDouble(100));
            }
        }
    }
}
