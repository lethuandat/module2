package ss23_behavioral_dp.thuc_hanh.observer;

import javax.security.auth.Subject;

public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
