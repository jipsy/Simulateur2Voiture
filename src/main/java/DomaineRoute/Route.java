package DomaineRoute;

import java.util.Observable;

/**
 * Created by jp on 15/03/16.
 */
public class Route extends Observable {

    /* coordonée du h */
    private  int x;
    private int y;


    public Route(int x, int y ){
        this.x = x;
        this.y = y;


    }


    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
