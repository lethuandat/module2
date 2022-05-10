package ss06_Inheritance.bai_tap.point2d_point3d;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] xY = new float[2];
        xY[0] = this.getX();
        xY[1] = this.getY();
        return xY;
    }

    @Override
    public String toString() {
        return "Point 2D có tọa độ (" + getXY()[0] +
                ", " + getXY()[1] + ")";
    }
}
