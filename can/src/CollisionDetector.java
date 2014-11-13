import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;


/**
 * Created by blakerollins on 11/12/14.
 */
public class CollisionDetector extends Observable implements Runnable {

    private TouchSensor touch;
    private boolean running;

    public CollisionDetector(SensorPort portNum) {
        this.touch = new TouchSensor(portNum);
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            // foreach detector todo
            boolean buttonPressed = touch.isPressed();
            if (buttonPressed) {
                notifyObservers(LEGO_EVENTS.COLLISION_DETECTED);
            }
        }
    }
}
