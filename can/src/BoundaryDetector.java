import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;


/**
 * Created by blakerollins on 11/12/14.
 */

public class BoundaryDetector extends Observable implements Runnable {

    private LightSensor lightSensor;
    private boolean running;

    public BoundaryDetector(SensorPort portNum) {
        this.lightSensor = new LightSensor(portNum);
        running = true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while(running) {
            // foreach detector todo
            int lightAmount = lightSensor.readNormalizedValue();
            if (lightAmount > 1) {
                notifyObservers(LEGO_EVENTS.BOUNDARY_DETECTED);
            }
        }
    }
}
