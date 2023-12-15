public class MoveAblePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        System.out.println("x,y,xSpeed,ySpeed are operating");
    }

    public MoveAblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        System.out.println("x,y are operating");

    }

    public MoveAblePoint() {
        System.out.println("MoveAblePoint operating");
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] s = {xSpeed, ySpeed};
        return s;
    }

    public MoveAblePoint move(){
        float x = getX();
        float y = getY();
        x += xSpeed;
        y += ySpeed;
        super.setXY(x,y);
        return this;
    }
    @Override
    public String toString() {
        return "This is MAP returning x and y their position located at:"+super.getX()+" & "+super.getY()+" at speed: "+getxSpeed()+" & "+getySpeed();
    }
}
