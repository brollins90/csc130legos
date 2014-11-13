import java.util.ArrayList;
import java.util.List;

/**
 * Created by blakerollins on 11/12/14.
 */
public class Observable {

    private List<Observer> observers;

    public void addObserver(Observer o) {
        if (observers == null) {
            observers = new ArrayList<Observer>();
        }
        synchronized (this) {
            observers.add(o);
        }
    }

    public void notifyObservers(LEGO_EVENTS event) {
        notifyObservers(event, "");
    }

    public void notifyObservers(LEGO_EVENTS event, String message) {
        synchronized (this) {
            for (Observer observer : observers) {
                observer.update(event, message);
            }
        }
    }

    public void removeObserver(Observer o) {
        synchronized (this) {
            observers.remove(0);
        }
    }
}
