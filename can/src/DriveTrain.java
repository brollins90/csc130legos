import lejos.nxt.Motor;

/**
 * Created by blakerollins on 11/13/14.
 */
public class DriveTrain {

    public DriveTrain() {
    }

    public void forward() {
        Motor.A.forward();
        Motor.B.forward();
    }

    public void backward() {
        Motor.A.backward();
        Motor.B.backward();
    }

    public void turnLeft() {
        Motor.A.backward();
        Motor.B.forward();
    }

    public void turnRight() {
        Motor.A.forward();
        Motor.B.backward();
    }

    public void stop() {
        Motor.A.stop();
        Motor.B.stop();
    }
}
