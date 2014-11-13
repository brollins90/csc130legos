import lejos.nxt.SensorPort;

/**
 * Created by blakerollins on 11/12/14.
 */
public class CanRobot {

    private TimerWatcher timerWatcher;
    private BoundaryDetector boundaryDetector;
    private CollisionDetector collisionDetector;
    private DistanceDetector distanceDetector;
    private HumanInterfaceController humanInterfaceController;
    private RobotMovementController robotMovementController;

    public CanRobot() {
        initializeHardware();
    }

    private void initializeHardware() {
        initializeDetectors();
        startDetectors();
        initializeControllers();
    }

    private void initializeDetectors() {

        timerWatcher = new TimerWatcher(2 * 60);
        boundaryDetector = new BoundaryDetector(SensorPort.S1);
        collisionDetector = new CollisionDetector(SensorPort.S2);
        distanceDetector = new DistanceDetector(SensorPort.S3);

    }

    private void startDetectors() {
        new Thread(timerWatcher).start();
        new Thread(boundaryDetector).start();
        new Thread(collisionDetector).start();
        new Thread(distanceDetector).start();
    }

    private void initializeControllers() {
        humanInterfaceController = new HumanInterfaceController();
        timerWatcher.addObserver(humanInterfaceController);
        boundaryDetector.addObserver(humanInterfaceController);
        collisionDetector.addObserver(humanInterfaceController);
        distanceDetector.addObserver(humanInterfaceController);

        robotMovementController = new RobotMovementController();
    }

    public void startCanRemoval() {
        robotMovementController.changeState(ROBOT_STATE.SEARCHING_FOR_CAN);
    }
}
