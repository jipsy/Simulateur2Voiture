package domaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int x;
    private int y;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int x, int y, int vitesse) {
		this.x = x;
        this.y = y;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

    public int getY() {
        return y;
    }

    public void miseAJourPosition() {
		miseAJourPositionX();
        miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres == 0)
			x += vitesseMetreSeconde;
		else if (directionEnDegres == 180)
			x -= vitesseMetreSeconde;
		if (x > 1000)
			x = 1000;
		else if (x < 0)
			x = 0;
	}

    private void miseAJourPositionY() {
        if (directionEnDegres == 270){
            y -= vitesseMetreSeconde;
            System.out.println("Y : " + y);
        }
        else if (directionEnDegres == 90)
            y += vitesseMetreSeconde;
/*
        if (y < 0) {
            y = 0;
        } else if (y>1000) {
            y=1000;
        }*/
    }

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public int getX() {
		return x;
	}

	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

	public Object getVitesse() {
		return vitesseMetreSeconde;
	}

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
        directionEnDegres +=270 ;
        directionEnDegres = directionEnDegres % 360;
    }
    /**
     * Methode tourner gauche.
     */
    public void tournerGauche(){
        directionEnDegres +=90 ;
        directionEnDegres = directionEnDegres % 360;
    }

	public void inverserDirection() {
		directionEnDegres +=180 ;
		directionEnDegres = directionEnDegres % 360;
		
	}

	public int getDirection() {
	return directionEnDegres;
	}

	
}
