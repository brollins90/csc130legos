/**
 * Created by blakerollins on 11/12/14.
 */
public class HumanInterfaceController extends Observable implements Observer {


    public HumanInterfaceController() {
        this.addObserver(this);
    }

    @Override
    public void update(LEGO_EVENTS event, String message) {

        System.out.println("HIC " + event.name());

        switch (event) {
            case REVERSE_MOVEMENT:
                playBeeping();
                break;
            case COLLISION_DETECTED:
                playSolidTone();
                break;
            case SUCCESS:
                playHappySong();
                break;
            case FAILURE:
                playSadSong();
                break;
        }

    }

    private void playSadSong() {

    }

    private void playHappySong() {

    }

    private void playSolidTone() {

    }

    private void playBeeping() {

    }
}
