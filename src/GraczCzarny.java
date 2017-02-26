import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class GraczCzarny extends Gracz {

	// KONSTRUKTOR
	public GraczCzarny(Plansza plansza) {
		super(plansza);
	}

	// SETTER J
	public void setJ(int j) {
		this.j = j;
	}

	// GETTER J
	public int getJ() {
		return j;
	}

	// METODA RUCHU CZARNEGO PIONKA
	public void ruch(ActionEvent e) {

		if (x) { // zaznaczanie pionka do przesuniecia

			pozycjaStartowa(e, "czarny");

		} else { // pole docelowe pionka do przesuniecia
			pozycjaKoncowa(e, "czarny", "bialy");

		}
	}

}
