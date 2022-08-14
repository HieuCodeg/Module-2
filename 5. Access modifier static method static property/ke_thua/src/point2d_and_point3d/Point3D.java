package point2d_and_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        this.z = z;
    }
    public float[] getXYZ() {
        return new float[]{super.getX(),super.getY(),getZ()};
    }

    @Override
    public String toString() {
        return Arrays.toString(getXYZ());
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D.toString());
    }
}
