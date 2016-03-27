package applisimu;

//import java.awt.*;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import domaineroute.Route;
import domainevoiture.Voiture;

/**
 * @author Jp
 * @author Yvan
 */
public class IhmVoiture extends JFrame implements Observer {
    /**
	 * Conversion de Pixels.
	 */
    static final private double paramatreConversionMetresPixels = 0.5;
    /**
     * Voiture.
     */
	private Voiture myVoiture;
    /**
     * Route.
     */
    private Route maRoute;
    /**
     * Commande de voiture.
     */
	private CommandeVoiture maCommandeVoiture;
    /**
     * Initialisation de la fenêtre.
     */
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(1000, 1000);
		this.maCommandeVoiture = new CommandeVoiture(this, myVoiture);
		this.setVisible(true);
	}
    /**
     * Constructeur IhmVoiture.
     * @param maRoute route
     * @param maVoiture voiture
     */
	public IhmVoiture(Voiture maVoiture, final Route maRoute) {
		super();
		this.myVoiture = maVoiture;
        this.maRoute = maRoute;
        maRoute.addObserver(this);
		maVoiture.addObserver(this);
		initGraphique();
	}
    /**
     * Constructeur IhmVoiture.
     */
	public IhmVoiture() {
		super();
		initGraphique();
		this.myVoiture = null;
	}
    /**
     * Place le point x sur la fenêtre.
     * @param xMetres xMetres
     * @return int
     */
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(final Observable arg0, final Object arg1) {
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
		int xMetres = myVoiture.getX();
		int xPixel = calculerPositionPixels(xMetres);
        int yMetres = myVoiture.getY();
        int yPixel = calculerPositionPixels(yMetres);
        if((myVoiture.getDirection() == 180) || (myVoiture.getDirection() == 0)) {
            contexteGraphique.fillRect(xPixel, 300-yPixel, 30, 15);
        }
        if((myVoiture.getDirection() == 270) || (myVoiture.getDirection() == 90)) {
            contexteGraphique.fillRect(xPixel, 300-yPixel, 15, 30);
        }

	}

    private void dessinerRouteHorizontale(final Graphics contexteGraphique, int x, int y) {
        contexteGraphique.fillRect(x, y, this.getSize().width, 60);
        Graphics2D g2d = (Graphics2D) contexteGraphique;
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.setColor(Color.white);
        g2d.drawLine(0, 290,  this.getSize().width, 290);
    }

    private void dessinerRouteVerticale(final Graphics contexteGraph, int x, int y) {
        contexteGraph.fillRect(x, y, 60, this.getSize().height);
    }
}
