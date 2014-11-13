import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;


/**
 * Created by blakerollins on 11/12/14.
 */

public class DistanceDetector extends Observable implements Runnable {

    private UltrasonicSensor ultrasonicSensor;
    private boolean running;

    public DistanceDetector(SensorPort portNum) {
        this.ultrasonicSensor = new UltrasonicSensor(portNum);
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            // foreach detector todo
            int distance = ultrasonicSensor.getDistance();
            if (distance > 1) {
                notifyObservers(LEGO_EVENTS.DISTANCE_DETECTED);
            }
        }
    }
}
