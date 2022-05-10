package ss06_Inheritance.bai_tap.point2d_point3d;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] xYZ = new float[3];
        xYZ[0] = super.getXY()[0];
        xYZ[1] = super.getXY()[1];
        xYZ[2] = this.getZ();
        return xYZ;
    }

    @Override
    public String toString() {
        return "Point 3D có tọa độ (" + getXYZ()[0] +
                ", " + getXYZ()[1] +
                ", " + getXYZ()[2] + ")";
    }
}