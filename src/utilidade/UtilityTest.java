package utilidade;

import estrutura.Tabuleiro;

public class UtilityTest {

	public static void main(String[] args) {
		Tabuleiro board = new Tabuleiro();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				double rand = Math.random();
				if (rand < 0.25) {
					board.setCasaValue(i, j, Token.BLUE);
				} else if (rand < 0.5) {
					board.setCasaValue(i, j, Token.GREEN);
				} else {
					board.setCasaValue(i, j, Token.BLANK);
				}
			}
		}

		board.printBoard();
	}
}
