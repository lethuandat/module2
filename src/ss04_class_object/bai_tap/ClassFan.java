package ss04_class_object.bai_tap;

public class ClassFan {
    public static void main(String[] args) {
        final byte SLOW = 1;
        final byte MEDIUM = 2;
        final byte FAST = 3;
        Fan fan1 = new Fan( FAST,true, 10, "yellow");
        Fan fan2 = new Fan( MEDIUM,false, 5, "blue");
        Fan fan3 = new Fan( SLOW,true, 15, "red");

        System.out.print("Fan 1: " + fan1.toString());
        System.out.print("\nFan 2: " + fan2.toString());
        System.out.print("\nFan 3: " + fan3.toString());
    }

    public static class Fan {
        final byte SLOW = 1;
        final byte MEDIUM = 2;
        final byte FAST = 3;
        private int _speed = SLOW;
        private boolean _on = false;
        private double _radius = 5;
        private String _color = "blue";

        public Fan() {
        }

        public Fan(int _speed, boolean _on, double _radius, String _color) {
            this._speed = _speed;
            this._on = _on;
            this._radius = _radius;
            this._color = _color;
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
            if (_speed == 1) {
                return _speed = this.getSLOW();
            } else if (_speed == 2) {
                return _speed = this.getMEDIUM();
            } else {
                return _speed = this.getFAST();
            }

        }

        public void setSpeed(int _speed) {
            this._speed = _speed;
        }

        public boolean isOn() {
            return _on;
        }

        public void setOn(boolean _on) {
            this._on = _on;
        }

        public double getRadius() {
            return _radius;
        }

        public void setRadius(double _radius) {
            this._radius = _radius;
        }

        public String getColor() {
            return _color;
        }

        public void setColor(String _color) {
            this._color = _color;
        }

        public String toString() {
            if (this.isOn()) {
                return "fan is on\n" +
                        "speed: " + this.getSpeed() +
                        "\ncolor: " + this.getColor() +
                        "\nradius: " + this.getRadius();
            } else {
                return "fan is off";
            }
        }
    }
}
