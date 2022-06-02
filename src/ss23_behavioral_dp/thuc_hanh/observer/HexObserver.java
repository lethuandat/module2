package ss23_behavioral_dp.thuc_hanh.observer;

public class HexObserver extends Observer {
    private Subject subject;

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    public void update() {
        System.out.print(" " + Integer.toHexString(subject.getState()));
    }
}
