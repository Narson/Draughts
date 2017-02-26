import javax.swing.JButton;


public class Pole extends JButton {
	
	private int row;
	private int col;
	
	//GETTER ROW
	public int getRow() {
		return row;
	}
	
	//GETTER COL
	public int getCol() {
		return col;
	}

	
	
	 //KONSTRUKTOR
	public Pole(int row, int col) {
		
		this.row = row;
		this.col = col;
		
	}
	
}
