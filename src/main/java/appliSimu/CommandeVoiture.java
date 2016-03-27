package applisimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domainevoiture.Voiture;

/**
 * @author Jp
 * @author Yvan
 */
public class CommandeVoiture extends JPanel implements ActionListener {
    /**
     * Bouton acceler.
     */
    private JButton boutonAccelerer;
    /**
     * Bouton inverser direction.
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
     * Object voiture.
     */
    private Voiture myVoiture;
    /**
     * Affichage des boutons.
     * @param fenetre fenetre d'affichage
     * @param maVoiture voiture
     */
    public CommandeVoiture(final JFrame fenetre, final Voiture maVoiture) {
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
        this.myVoiture = maVoiture;
    }

    @Override
    final public void actionPerformed(final ActionEvent event) {
        Object bouton = event.getSource();
        if (bouton == boutonAccelerer) {
            myVoiture.accelerer();
        } else if (bouton == boutonInverserDirection) {
            myVoiture.inverserDirection();
        } else if (bouton == boutonTournerDroite) {
            myVoiture.tournerDroite();
        } else if (bouton == boutonTournerGauche) {
            myVoiture.tournerGauche();
        }
    }
}
