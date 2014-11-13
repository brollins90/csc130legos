/**
 * Created by blakerollins on 11/13/14.
 */
public class RobotMovementController extends Observable implements Observer {

    ROBOT_STATE currentState;
    DriveTrain driveTrain;


    public RobotMovementController() {
        currentState = ROBOT_STATE.STOPPED;
        driveTrain = new DriveTrain();
    }

    @Override
    public void update(LEGO_EVENTS event, String message) {

        System.out.println("MC " + event.name());

        if (event == LEGO_EVENTS.SUCCESS || event == LEGO_EVENTS.FAILURE) {
            driveTrain.stop();
            changeState(ROBOT_STATE.STOPPED);
        }

        switch (currentState) {
            case APPROACHING_CAN:

                switch (event) {
                    case BOUNDARY_DETECTED:
                        driveTrain.turnLeft();
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        driveTrain.forward();
                        changeState(ROBOT_STATE.RETURING_TO_CENTER);
                        break;
                    case COLLISION_DETECTED:
                        driveTrain.stop();
                        driveTrain.forward();
                        changeState(ROBOT_STATE.CONTACT_OBJECT);
                        break;
                    case DISTANCE_DETECTED:
                        // ignore, we already have a can
                        break;
                    case GOAL:
                        driveTrain.forward();
                        changeState(ROBOT_STATE.LEAVING_AREA);
                        break;
                }
                break; // APPROACHING_CAN

            case CONTACT_OBJECT:

                switch (event) {
                    case BOUNDARY_DETECTED:
                        driveTrain.turnLeft();
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        driveTrain.forward();
                        changeState(ROBOT_STATE.RETURING_TO_CENTER);
                        break;
                    case COLLISION_DETECTED:
                        // ignore, we are touching the can already
                        break;
                    case DISTANCE_DETECTED:
                        // ignore, we already have a can
                        break;
                    case GOAL:
                        driveTrain.forward();
                        changeState(ROBOT_STATE.LEAVING_AREA);
                        break;
                }
                break; // CONTACT_OBJECT

            case LEAVING_AREA:

                switch (event) {
                    case BOUNDARY_DETECTED:
                        driveTrain.forward();
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {

                        }
                        driveTrain.stop();
                        changeState(ROBOT_STATE.SUCCEEDED);
                        break;
                    case COLLISION_DETECTED:
                        //
                        break;
                    case DISTANCE_DETECTED:
                        // ignore, we already have a can
                        break;
                    case GOAL:
                        //
                        break;
                }
                break; // LEAVING_AREA

            case RETURING_TO_CENTER:

                switch (event) {
                    case BOUNDARY_DETECTED:
                        driveTrain.turnLeft();
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        driveTrain.forward();
                        changeState(ROBOT_STATE.RETURING_TO_CENTER);
                        break;
                    case COLLISION_DETECTED:
                        driveTrain.stop();
                        driveTrain.forward();
                        changeState(ROBOT_STATE.CONTACT_OBJECT);
                        break;
                    case DISTANCE_DETECTED:
                        // ignore, we dont want to see a can outside of the area
                        break;
                    case GOAL:
                        driveTrain.forward();
                        changeState(ROBOT_STATE.LEAVING_AREA);
                        break;
                }
                break; // RETURING_TO_CENTER

            case SEARCHING_FOR_CAN:
                switch (event) {
                    case BOUNDARY_DETECTED:
                        driveTrain.turnLeft();
                        try {
                            Thread.sleep(100);
                        } catch (Exception e) {

                        }
                        driveTrain.forward();
                        changeState(ROBOT_STATE.RETURING_TO_CENTER);
                        break;
                    case COLLISION_DETECTED:
                        driveTrain.stop();
                        driveTrain.forward();
                        changeState(ROBOT_STATE.CONTACT_OBJECT);
                        break;
                    case DISTANCE_DETECTED:
                        driveTrain.stop();
                        driveTrain.forward();
                        changeState(ROBOT_STATE.APPROACHING_CAN);
                        break;
                    case GOAL:
                        driveTrain.forward();
                        changeState(ROBOT_STATE.LEAVING_AREA);
                        break;
                }

                break; // SEARCHING_FOR_CAN
        }

    }

    public void changeState(ROBOT_STATE state) {
        this.currentState = state;
    }
}
