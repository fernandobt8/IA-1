package estrutura.tabuleiro;


public class Tabuleiro {

	private Casa[][] casas;

	public Tabuleiro() {
		casas = new Casa[6][7];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				casas[i][j] = new Casa();
			}
		}
	}

	public void setCasaValue(int i, int j, Token tokenType) {
		casas[i][j].setTipoCasa(tokenType);
	}

	public void printBoard() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(casas[i][j] + " ");
			}
			System.out.println();
		}
	}
}
