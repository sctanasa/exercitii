package ro.stefantanasa.exercitii.threads;

public class PingPongThread extends Thread {
    private final Semaphore.State state;
    private final Semaphore semaphore;
    private int sleepTime;

    public PingPongThread(Semaphore.State state, Semaphore semaphore, int sleepTime) {
        super(state.name());
        this.state = state;
        this.semaphore = semaphore;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while(semaphore.isOn()) {
            synchronized (semaphore) {
                if (state == semaphore.getState()) {
                    System.out.println(state.name().toLowerCase());
                    semaphore.nextState();
                }
            }
            try {
                sleepTime = 100;
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
