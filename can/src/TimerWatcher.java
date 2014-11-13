/**
 * Created by blakerollins on 11/12/14.
 */
public class TimerWatcher extends Observable implements Runnable {

    private long endTime;
    private long startTime;
    private boolean running;

    // endTime in seconds
    public TimerWatcher(long endTime) {
        this.startTime = System.currentTimeMillis();
        this.endTime = startTime + endTime * 1000;
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            if (System.currentTimeMillis() > this.endTime) {
                notifyObservers(LEGO_EVENTS.TIME_UP);
            }
        }
    }
}
