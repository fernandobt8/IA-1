package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UtilityTest {

	static Tabuleiro board;

	public static void main(String[] args) {
		initBoard();
		System.out.println("Utilidade total com vizinhos:    " + UtilidadeVizinhos.calculateUtilityVizinhos(board));
		System.out.println("Utilidade total com combinações: " + UtilidadeCombinacoes.calculateUtilityCombinacoes(board));
	}

	private static void initBoard() {
		board = new Tabuleiro();

		for (int i = 0; i < board.HEIGHT; i++) {
			for (int j = 0; j < board.WIDTH; j++) {
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
