package domainevoiture;

import java.util.Observable;

/**
 * @author Jp
 * @author Yvan
 */
public class Voiture extends Observable {
	/**
	 * Abscisse.
	 */
	private int myX;
	/**
	 * Ordonnée.
	 */
    private int myY;
	/**
	 * Vitesse.
	 */
	private int vitesseMetreSeconde;
	/**
	 * Direction en degres.
	 */
	private int directionEnDegres;

	/**
	 * Constructeur.
	 * @param x abscisse
	 * @param y ordonnee
	 * @param vitesse vitesse
     */
	public Voiture(final int x,final int y, final int vitesse) {
		this.myX = x;
        this.myY = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

	/**
	 * getteur Y.
	 * @return int
     */
    final public int getY() {
        return myY;
    }

	/**
	 * Mise a jour de la position.
	 */
    final public void miseAJourPosition() {
		miseAJourPositionX();
        miseAJourPositionY();
		notificationObservateur();
	}

	/**
	 * Mise a jour abscisse.
	 */
	private void miseAJourPositionX() {
		if (directionEnDegres == 0) {
			myX += vitesseMetreSeconde;
		} else if (directionEnDegres == 180) {
			myX -= vitesseMetreSeconde;
		} if (myX > 1000) {
			myX = 1000;
		} else if (myX < 0) {
			myX = 0;
		}
	}
	/**
	 * Mise a jour ordonnee.
	 */
    private void miseAJourPositionY() {
        if (directionEnDegres == 270) {
            myY -= vitesseMetreSeconde;
            System.out.println("Y : " + myY);
        } else if (directionEnDegres == 90) {
            myY += vitesseMetreSeconde;
        }
    }

	/**
	 * Notifie l'observeur.
	 */
	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * getteur X
	 * @return int
     */
	public int getX() {
		return myX;
	}

	/**
	 * accelere la voiture.
	 */
	public void accelerer() {
		if (vitesseMetreSeconde < 100) {
			vitesseMetreSeconde += 10;
		}
	}

	/**
	 * getteur vitesse.
	 * @return Object
     */
	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	/**
	 * Setter de vitesse.
	 * @param vitesse vitesse
     */
	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public void setDirection(int angleDirection) {
		this.directionEnDegres = angleDirection;
		
	}
    /**
     * Methode tourner droite.
     */
    public void tournerDroite(){
        directionEnDegres += 270;
        directionEnDegres = directionEnDegres % 360;
    }
    /**
     * Methode tourner gauche.
     */
    public void tournerGauche(){
        directionEnDegres += 90;
        directionEnDegres = directionEnDegres % 360;
    }

	public void inverserDirection() {
		directionEnDegres += 180;
		directionEnDegres = directionEnDegres % 360;
		
	}

	public int getDirection() {
	return directionEnDegres;
	}

	
}
