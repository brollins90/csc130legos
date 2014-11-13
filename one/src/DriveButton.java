import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class DriveButton {
    public static void main(String[] args) {
        try{
        System.out.println("Drive Forward until button press5");

            TouchSensor touch = new TouchSensor(SensorPort.S1);
            boolean previousTouchState = false;
            boolean forward = true;
            boolean running = true;

            // Loop here...
            while(running) {

            // check for key,
                boolean buttonPressed = touch.isPressed();
                // if the button is pressed and we have not acted on it
                if (buttonPressed && previousTouchState != buttonPressed){
                    System.out.println("Pressed");
                    forward = !forward;
                    System.out.println(forward);
                }
                
                if (forward) {
//                    System.out.println("Forward");
                    Motor.A.forward();
                    Motor.B.forward();
                } else {
//                    System.out.println("Backward");
                    Motor.A.backward();
                    Motor.B.backward();
                }
                previousTouchState = buttonPressed;
            }

        } catch (Exception e) {

        }
    }



}
