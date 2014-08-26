package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UtilityTest {

	static Tabuleiro board;

	public static void main(String[] args) {
		initBoard();
		calculateUtility();
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

	private static void calculateUtility() {
		System.out.println();

		for (int x = 0; x < board.HEIGHT; x++) {
			for (int y = 0; y < board.WIDTH; y++) {
				int utilidade = 0;
				Token token = board.getCasa(x, y).getTipoCasa();

				if (token != Token.BLANK) {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							int casaX = x - 1 + i;
							int casaY = y - 1 + j;

							if (casaX >= 0 && casaY >= 0 && casaX < board.HEIGHT && casaY < board.WIDTH) {
								utilidade += calcularUtilidade(token, board.getCasa(casaX, casaY).getTipoCasa());
							}
						}
					}

					// utilidade = (int) Math.pow(10, utilidade);
					board.getCasa(x, y).setUtilidade(utilidade);
				}
				System.out.print(utilidade + "\t");
			}
			System.out.println();
		}
	}

	private static int calcularUtilidade(Token tokenCentral, Token tokenAdjacente) {
		if (tokenAdjacente == Token.BLANK) {
			return 0;
		} else if (tokenCentral == tokenAdjacente) {
			return 1;
		}
		return -1;
	}

}
