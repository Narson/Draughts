import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		Plansza grid = new Plansza(8, 8, 800);
		PionkiRuch ruch = new PionkiRuch(grid);
		Dialogi informacja = new Dialogi(grid);
		ruch.odblokujPionki();
		informacja.PoczatekGry();
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

