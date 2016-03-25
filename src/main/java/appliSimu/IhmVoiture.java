package appliSimu;

import java.awt.*;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import domaineroute.Route;
import domaineVoiture.Voiture;

public class IhmVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
    private Route maRoute;
	private CommandeVoiture maCommandeVoiture;
	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(1000, 1000);
		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);
		this.setVisible(true);
	}
	
	public IhmVoiture(Voiture maVoiture, Route maRoute) {
		super();
		this.maVoiture = maVoiture;
        this.maRoute = maRoute;
        maRoute.addObserver(this);
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IhmVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);

        contexteGraphique.setColor(Color.gray);
        dessinerRouteHorizontale(contexteGraphique, 0, 260);
        contexteGraphique.setColor(Color.gray);
        dessinerRouteVerticale(contexteGraphique, 400, 0);
        contexteGraphique.setColor(Color.red);
        dessinerVoiture(contexteGraphique);

    }


	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        int yMetres = maVoiture.getY();
        int yPixel = calculerPositionPixels(yMetres);
        if((maVoiture.getDirection() == 180) || (maVoiture.getDirection() == 0)) {
            contexteGraphique.fillRect(xPixel, 300-yPixel, 30, 15);
        }
        if((maVoiture.getDirection() == 270) || (maVoiture.getDirection() == 90)) {
            contexteGraphique.fillRect(xPixel, 300-yPixel, 15, 30);
        }

	}

    private void dessinerRouteHorizontale(Graphics contexteGraphique, int x, int y){
        contexteGraphique.fillRect(x, y, this.getSize().width, 60);

        Graphics2D g2d = (Graphics2D) contexteGraphique;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setColor(Color.white);
        g2d.drawLine(0, 290,  this.getSize().width, 290);


    }

    private void dessinerRouteVerticale(Graphics contexteGraphique, int x, int y){
        contexteGraphique.fillRect(x, y, 60, this.getSize().height);
    }

	
}
