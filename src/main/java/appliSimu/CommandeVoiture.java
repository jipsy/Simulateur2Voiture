package appliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domaineVoiture.Voiture;

/**
 * @author Jp
 * @author Yvan
 */
public class CommandeVoiture extends JPanel implements ActionListener {
    /**
     * Bouton acceler
     */
    private JButton boutonAccelerer;
    /**
     * Bouton inverser direction
     */
    private JButton boutonInverserDirection;
    /**
     * Bouton tourner a droite.
     */
    private JButton boutonTournerDroite;
    /**
     * Bouton tourner a gauche.
     */
    private JButton boutonTournerGauche;
    /**
     * Object voiture
     */
    private Voiture maVoiture;

	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		
		super();
		this.setLayout(new FlowLayout());

        boutonTournerDroite = new JButton("Tourner a droite");
        boutonTournerDroite.addActionListener(this);
        this.add(boutonTournerDroite);

        boutonTournerGauche = new JButton("Tourner a gauche");
        boutonTournerGauche.addActionListener(this);
        this.add(boutonTournerGauche);

		boutonAccelerer = new JButton("Accelerer");
		boutonAccelerer.addActionListener(this);
		this.add(boutonAccelerer);

		boutonInverserDirection = new JButton("Changer direction");
		boutonInverserDirection.addActionListener(this);
		this.add(boutonInverserDirection);

		fenetre.add(this);
		this.maVoiture = maVoiture;


	}


	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
		else if(bouton == boutonInverserDirection )
			maVoiture.inverserDirection();
        else if(bouton == boutonTournerDroite)
            maVoiture.tournerDroite();
        else if(bouton == boutonTournerGauche)
            maVoiture.tournerGauche();
	}
	

}
