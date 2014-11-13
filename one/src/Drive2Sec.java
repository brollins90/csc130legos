import lejos.nxt.Motor;

public class Drive2Sec {
    public static void main(String[] args) {
        try{
        System.out.println("Drive Forward for 2 seconds");
        Motor.A.forward();
        Motor.B.forward();
        Thread.sleep(2000);
        Motor.A.backward();
        Motor.B.backward();
        Thread.sleep(2000);
        Motor.A.stop();
        Motor.B.stop();
        } catch (Exception e) {
            
        }
    }

}
