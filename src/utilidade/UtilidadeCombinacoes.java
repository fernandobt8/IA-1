package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UtilidadeCombinacoes {

	private static Tabuleiro tabuleiro;

	public static int calculateUtilityCombinacoes(Tabuleiro tabuleiro) {
		System.out.println();

		UtilidadeCombinacoes.tabuleiro = tabuleiro;
		int maxUtilidade = Integer.MIN_VALUE;

		for (int x = 0; x < tabuleiro.HEIGHT; x++) {
			for (int y = 0; y < tabuleiro.WIDTH; y++) {
				Token tipoCasaCentral = tabuleiro.getCasa(x, y).getTipoCasa();
				int utilidade = 0;

				if (tipoCasaCentral != Token.BLANK) {
					utilidade = calculateUtilidadeCasa(x, y, tipoCasaCentral);

					if (utilidade > maxUtilidade) {
						maxUtilidade = utilidade;
					}

				}
				tabuleiro.getCasa(x, y).setUtilidade(utilidade);
				System.out.print(utilidade + "\t");
			}
			System.out.println();
		}

		return maxUtilidade;
	}

	private static int calculateUtilidadeCasa(int x, int y, Token tipoCasaCentral) {
		int maxUtilidade = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {

				int utilidade = 1;

				if (i == 0 && j == 0) {
					break;
				}

				for (int v = 0; v < 3; v++) { // Observa até 4 vizinhos na direção indicada;
					int casaX = x + i;
					int casaY = y + j;

					if (casaX >= 0 && casaY >= 0 && casaX < tabuleiro.HEIGHT && casaY < tabuleiro.WIDTH) { // Se for uma casa válida;
						Token tipoCasaAnalisada = tabuleiro.getCasa(casaX, casaY).getTipoCasa();

						if (tipoCasaAnalisada == Token.BLANK) {
							continue;
						} else if (tipoCasaAnalisada != tipoCasaCentral) {
							break;
						} else if (tipoCasaAnalisada == tipoCasaCentral) {
							utilidade *= 10;
						}
					} else {
						break;
					}
				}

				if (utilidade > maxUtilidade) {
					maxUtilidade = utilidade;
				}
			}
		}

		return maxUtilidade;
	}

}
