import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class GraczBialy extends Gracz {

	// KONSTRUKTOR
	public GraczBialy(Plansza plansza) {
		super(plansza);
	}

	// SETTER I
	public void setJ(int j) {
		this.j = j;
	}

	//GETTER I
	public int getJ() {
		return j;
	}

	// METODA RUCHU BIALEGO PIONKA
	public void ruch(ActionEvent e) {

		if (x) { // zaznaczanie pionka do przesuniecia

			pozycjaStartowa(e, "bialy");

		} else { // pole docelowe pionka do przesuniecia

			pozycjaKoncowa(e, "bialy", "czarny");

		}
	}
	
}
