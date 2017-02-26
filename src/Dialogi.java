import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Dialogi {

	private Plansza plansza;

	public Dialogi(Plansza plansza) {
		this.plansza = plansza;
	}

	// METODA POKAZUJACA PRZYWITANIE DO GRY
	public void PoczatekGry() {
		JOptionPane.showMessageDialog(null,
				"Witamy w grze w warcaby.\nGraczu czarny, twoj ruch!",
				"Warcaby", JOptionPane.INFORMATION_MESSAGE);
	}

	// METODA POKAZUJACA DIALOG DLA GRACZA
	public void TwojRuch(String przeciwnik) {

		if (przeciwnik.equals("czarny")) {

			JOptionPane.showMessageDialog(null, "Graczu czarny, twoj ruch!",
					"Warcaby", JOptionPane.INFORMATION_MESSAGE);

		} else {

			JOptionPane.showMessageDialog(null, "Graczu bialy, twoj ruch!",
					"Warcaby", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	// METODA POKAZUJACA DIALOG POD KONIEC GRY
	public void KoniecGry() {
		
		String zwyciezca = "nikt";
		int b = 0, c = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ImageIcon ii = ((ImageIcon) plansza.getButton(i, j).getIcon());
				if (ii != null && ii.getDescription().equals("bialy"))
					b++;
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ImageIcon ii = ((ImageIcon) plansza.getButton(i, j).getIcon());
				if (ii != null && ii.getDescription().equals("bialy"))
					c++;
			}
		}
		
		if (b == 0){
			zwyciezca = "czarny";
		} else if (c == 0){
			zwyciezca = "bialy";
		}
		
		if (zwyciezca.equals("czarny")) {

			JOptionPane.showMessageDialog(null, "Wygral gracz czarny!",
					"Warcaby", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (zwyciezca.equals("bialy")){

			JOptionPane.showMessageDialog(null, "Wygral gracz bialy!",
					"Warcaby", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}
