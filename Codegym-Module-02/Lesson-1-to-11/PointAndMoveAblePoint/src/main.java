public class main {
    public static void main(String[] args) {
        Point point = new Point();
        point.setXY(10,4);
        System.out.println(point);

        MoveAblePoint MAP = new MoveAblePoint();
        MAP.setXY(9,9);
        MAP.setSpeed(10,11);
        MAP.move();
        System.out.println(MAP);
    }
}
