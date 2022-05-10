package ss06_Inheritance.bai_tap.point_movablepoint;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arrSpeed = new float[2];
        arrSpeed[0] = this.getXSpeed();
        arrSpeed[1] = this.getYSpeed();
        return arrSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint: (" + super.getX() +
                ", " + super.getY() +
                "), speed = (" + getSpeed()[0] +
                ", " + getSpeed()[1] + ")";
    }

    public MovablePoint move() {
        return this;
    }
}
