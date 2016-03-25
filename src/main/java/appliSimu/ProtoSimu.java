package appliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domaineVoiture.Voiture;
import domaineroute.Route;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

		final Voiture maVoiture = new Voiture (100, 10,10);
        final Route maRoute = new Route(0,100);
		IhmVoiture monTriangle = new IhmVoiture(maVoiture,maRoute);

        Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		timerAvancer.start();
		while(true){
		}
	}
}
