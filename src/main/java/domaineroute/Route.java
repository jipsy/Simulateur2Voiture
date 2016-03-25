package domaineroute;
import java.util.Observable;
/**
 * Created by jp on 15/03/16.
 */
public class Route extends Observable {
    /**
     *Abscisse.
     */
    private int x;
    /**
     *Ordonnée.
     */
    private int y;
    /**
     * Constructeur route.
     * @param xParam abscisse
     * @param yParam ordonnée
     */
    public Route(final int xParam, final int yParam) {
        this.x = xParam;
        this.y = yParam;
    }
    /**
     * Methode gety.
     * @return abscisse
     */
    public final int getY() {
        return this.y;
    }
    /**
     * Methode getx.
     * @return abscisse
     */
    public final int getX() {
        return this.x;
    }
}
