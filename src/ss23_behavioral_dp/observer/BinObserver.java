package ss23_behavioral_dp.observer;

public class BinObserver extends Observer {
    private Subject subject;

    public BinObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    public void update() {
        System.out.print(" " + Integer.toBinaryString(subject.getState()));
    }
}
