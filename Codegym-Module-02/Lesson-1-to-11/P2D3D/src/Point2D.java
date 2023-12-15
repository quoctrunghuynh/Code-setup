public class Point2D {
    private float x = 0.0f;

    private float y = 0.0f;

    public Point2D() {
        System.out.println("Point2D is working");
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
        System.out.println("Point2D with xy is working");
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] xy = {this.x, this.y};
        return xy;
    }

    public String toString() {
        return "X's value is: " + this.x + " and this Y's value is: " + this.y;
    }
}
