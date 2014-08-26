package estrutura.tabuleiro;

public class Tabuleiro {

	public int WIDTH;
	public int HEIGHT;

	private Casa[][] casas;

	public Tabuleiro() {
		WIDTH = 7;
		HEIGHT = 6;

		casas = new Casa[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				casas[i][j] = new Casa();
			}
		}
	}

	public void setCasaValue(int i, int j, Token tokenType) {
		casas[i][j].setTipoCasa(tokenType);
	}

	public Casa getCasa(int x, int y) {
		return casas[x][y];
	}

	public void printBoard() {
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				System.out.print(casas[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
