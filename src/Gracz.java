import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

abstract public class Gracz {

	// POLA DLA KLAS DZIEDZICZACYCH GRACZ CZARNY I BIALY
	protected Pole moveFrom = null;
	protected Pole moveTo = null;
	protected boolean x = true;
	protected ImageIcon pawn;
	protected boolean pozwolenie = true;
	private Plansza plansza;
	protected int j = 0;
	Dialogi dialog;
	
	// KONSTRUKTOR GRACZA
	public Gracz(Plansza plansza) {
		this.plansza = plansza;
		this.dialog = new Dialogi(plansza);
	}

	// GETTER PLANSZY
	public Plansza getPlansza() {
		return plansza;
	}

	//METODA POZYCJA STRARTOWA PIONKA
	protected void pozycjaStartowa(ActionEvent e, String gracz) {
		
		moveFrom = (Pole) e.getSource();

		if (moveFrom.getIcon() != null) {
			if (((ImageIcon) moveFrom.getIcon()).getDescription().equals(gracz)) {

				moveFrom.setBackground(new Color(155, 155, 155));
				pawn = (ImageIcon) moveFrom.getIcon();

				x = !x;

			}
		}
	}
	
	// METODA POZYCJA KONCOWA PIONKA
	protected void pozycjaKoncowa(ActionEvent e, String gracz, String przeciwnik) {
		
		moveFrom.setBackground(new Color(192, 192, 192));
		moveTo = (Pole) e.getSource();
		if (Math.abs(moveFrom.getRow() - moveTo.getRow()) == 2
				&& Math.abs(moveFrom.getCol() - moveTo.getCol()) == 2) {

			int bicieRow = (moveFrom.getRow() + moveTo.getRow()) / 2;
			int bicieCol = (moveFrom.getCol() + moveTo.getCol()) / 2;
			Pole biciePole = this.getPlansza()
					.getButton(bicieRow, bicieCol);
			if (((ImageIcon) biciePole.getIcon()).getDescription().equals(
					przeciwnik)) {
				moveTo.setIcon(pawn);
				moveFrom.setIcon(null);
				biciePole.setIcon(null);

				
				moveFrom = moveTo;
				moveFrom.setBackground(new Color(155, 155, 155));
				pozwolenie = false;
			}
		
		} else if (Math.abs(moveFrom.getRow() - moveTo.getRow()) == 1
				&& Math.abs(moveFrom.getCol() - moveTo.getCol()) == 1
				&& wiekszeMniejsze(gracz) && pozwolenie == true) {

			if (moveTo.getBackground() != Color.WHITE
					&& moveTo.getIcon() == null
					&& moveFrom.getIcon() != null) {

				moveTo.setIcon(pawn);
				moveFrom.setIcon(null);
				x = !x;

				j++;
				dialog.KoniecGry();
				dialog.TwojRuch(przeciwnik);

			} else {

				x = !x;

			}

		} else {

			x = !x;
			if (pozwolenie == false) {
				j++;
				dialog.KoniecGry();
				dialog.TwojRuch(przeciwnik);
				pozwolenie = true;
			}

		}
	
	}

	// METODA WARUNKU RUCHU KAZDEGO GRACZA
	public boolean wiekszeMniejsze(String gracz){
		
		boolean a;
		
		if(gracz.equals("czarny")){
			a = (moveFrom.getRow() > moveTo.getRow());
		} else {
			a = (moveFrom.getRow() < moveTo.getRow());
		}
		return a;
	}
	
	// ABSTRAKCYJNA METODA  RUCHU IMPLEMENTOWANA W KAZDEJ PODKLASIE
	abstract public void ruch(ActionEvent e);

}
