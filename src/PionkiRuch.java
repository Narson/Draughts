import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PionkiRuch implements ActionListener {

	private int tura = 0;

	private Plansza plansza;
	GraczCzarny black;
	GraczBialy white;
	

	// KONSTRUKTOR PIONKI RUCH
	public PionkiRuch(Plansza plansza) {
		this.plansza = plansza;
		this.black = new GraczCzarny(plansza);
		this.white = new GraczBialy(plansza);
		
	}// KONIEC KONSTRUKTORA

	// METODA ODBLOKOWANIA PIONKOW DLA GRACZA
	public void odblokujPionki() { // dodanie listenerow kazdemu polu gry
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (plansza.getButton(i, j).getBackground() != Color.WHITE)
					plansza.getButton(i, j).addActionListener(this);
			}
		}
	}// KONIEC METODY

	// METODA ON ACTION PERFORMED
	public void actionPerformed(ActionEvent e) {
		
		black.setJ(tura);

		if (tura % 2 == 0) {
			black.ruch(e);
			tura = black.getJ();
		} else {
			white.setJ(tura);
			white.ruch(e);
			tura = white.getJ();
		}

	}
}