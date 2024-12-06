package ro.stefantanasa.exercitii.threads;

public class Semaphore {
    public enum State {PING, PONG}
    private int index = 0;
    private boolean isFinishing = false;
    private boolean on = true;

    public State getState() {
        return State.values()[index];
    }

    public void nextState() {
        if (isFinishing && index == State.values().length -1) {
            on = false;
        }
        index++;
        if (index >= State.values().length) {
            index = 0;
        }
    }

    public void finish() {
        isFinishing = true;
    }

    public boolean isOn() {
        return on;
    }
}
