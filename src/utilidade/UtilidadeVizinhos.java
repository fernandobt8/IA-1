package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UtilidadeVizinhos {

	public static int calculateUtility(Tabuleiro tabuleiro) {
		System.out.println();
		int maxUtilidade = Integer.MIN_VALUE;

		for (int x = 0; x < tabuleiro.HEIGHT; x++) {
			for (int y = 0; y < tabuleiro.WIDTH; y++) {
				int utilidade = 0;
				Token token = tabuleiro.getCasa(x, y).getTipoCasa();

				if (token != Token.BLANK) {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {

							int casaX = x - 1 + i;
							int casaY = y - 1 + j;

							if (casaX >= 0 && casaY >= 0 && casaX < tabuleiro.HEIGHT && casaY < tabuleiro.WIDTH) {
								utilidade += calcularUtilidade(token, tabuleiro.getCasa(casaX, casaY).getTipoCasa());
							}
						}
					}

					utilidade = (int) (Math.pow(10, utilidade) * Math.signum(utilidade));
					tabuleiro.getCasa(x, y).setUtilidade(utilidade);

					if (utilidade > maxUtilidade) {
						maxUtilidade = utilidade;
					}
				}
				System.out.print(utilidade + "\t");
			}
			System.out.println();
		}

		return maxUtilidade;
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
