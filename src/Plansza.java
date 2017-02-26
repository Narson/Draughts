import java.awt.*;
import javax.swing.*;

public class Plansza extends JFrame {

	private int rowsGrid; // l. rzedow
	private int colsGrid; // l. kolumn
	private int sizeGrid; // rozmiar szachownicy

	private ImageIcon czarny = new ImageIcon("src/obrazki/czarny.png", "czarny");
	private ImageIcon bialy = new ImageIcon("src/obrazki/bialy.png", "bialy");

	private Pole[][] buttons;
	Container pane = getContentPane();

	// METODA GET BUTTON
	public Pole getButton(int i, int j) {
		return buttons[i][j];
	}// KONIEC METODY

	// KONSTRUKTOR PLANSZA
	public Plansza(int rows, int cols, int size) {

		super("Warcaby"); // nazwa aplikacji

		rowsGrid = rows;
		colsGrid = cols;
		sizeGrid = size;

		setLayout(new GridLayout(rows, cols)); // tworzenie grid layoutu

		buttons = new Pole[rows][cols];

		for (int i = 0; i < rowsGrid; i++) {
			for (int j = 0; j < colsGrid; j++) {
				Pole button = new Pole(i, j);
				buttons[i][j] = button;
				if ((i == 0 || i % 2 == 0) && (j == 0 || j % 2 == 0)
						|| ((i % 2 != 0) && (j % 2 != 0))) {
					button.setBackground(new Color(192, 192, 192)); // ustaw
																	// szare
					if (i < 3)
						button.setIcon(bialy); // dodaj bialy pionek
					else if (i > 4)
						button.setIcon(czarny); // dodaj czarny pionek
				} else {
					button.setBackground(Color.WHITE); // ustaw biale
					button.setPreferredSize(new Dimension(50, 50));
				}
				pane.add(button);
			}

		}

		this.setPreferredSize(new Dimension(sizeGrid, sizeGrid));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}// KONSTRUKTOR KONIEC

}
