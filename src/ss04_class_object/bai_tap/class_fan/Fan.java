package ss04_class_object.bai_tap.class_fan;

public class Fan {
    final byte SLOW = 1;
    final byte MEDIUM = 2;
    final byte FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public byte getSLOW() {
        return SLOW;
    }

    public byte getMEDIUM() {
        return MEDIUM;
    }

    public byte getFAST() {
        return FAST;
    }

    public int getSpeed() {
        if (speed == 1) {
            return speed = this.getSLOW();
        } else if (speed == 2) {
            return speed = this.getMEDIUM();
        } else {
            return speed = this.getFAST();
        }

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (this.isOn()) {
            return "fan is on\n" +
                    "speed: " + this.getSpeed() +
                    "\ncolor: " + this.getColor() +
                    "\nradius: " + this.getRadius();
        } else {
            return "fan is off" +
                    "\ncolor: " + this.getColor() +
                    "\nradius: " + this.getRadius();
        }
    }
}
