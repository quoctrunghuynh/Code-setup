public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
        System.out.println("Point3D is working");
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ(){
        return this.z;
    }
    public void setZ(float z){
        this.z =z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x,y);
        this.z=z;
    }

    public float[] getXYZ() {
        float[] s ={super.getX(),super.getY(),getZ()};
        return s;
    }
    @Override
    public String toString(){
        return "This is Point 3D return x= "+super.getX()+", y= "+super.getY()+" z="+getZ();
    }
}
