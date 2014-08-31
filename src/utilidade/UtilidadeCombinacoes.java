package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class UtilidadeCombinacoes {

	private static Tabuleiro tabuleiro;

	public static int calculateUtilityCombinacoes(Tabuleiro tabuleiro) {
		System.out.println();

		UtilidadeCombinacoes.tabuleiro = tabuleiro;
		int utilidadeTabuleiro = 0;

		for (int x = 0; x < tabuleiro.ROWS; x++) {
			for (int y = 0; y < tabuleiro.COLUMNS; y++) {
				Token tipoCasaCentral = tabuleiro.getCasa(x, y).getTipoCasa();
				int utilidadeCasa = 0;

				if (tipoCasaCentral != Token.BLANK) {
					utilidadeCasa = calculateUtilidadeCasa(x, y, tipoCasaCentral);
					utilidadeTabuleiro += utilidadeCasa;
				}

				tabuleiro.getCasa(x, y).setUtilidade(utilidadeCasa);
				System.out.print(utilidadeCasa + "\t");
			}
			System.out.println();
		}

		return utilidadeTabuleiro;
	}

	private static int calculateUtilidadeCasa(int x, int y, Token tipoCasaCentral) {
		int maxUtilidade = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {

				int utilidade = 1;

				if (i == 0 && j == 0) {
					break;
				}

				int auxi = i;
				int auxj = j;
				for (int v = 0; v < 3; v++) { // Observa até 4 vizinhos na direção indicada;
					int casaX = x + auxi;
					int casaY = y + auxj;

					if (casaX >= 0 && casaY >= 0 && casaX < tabuleiro.ROWS && casaY < tabuleiro.COLUMNS) { // Se for uma casa válida;
						Token tipoCasaAnalisada = tabuleiro.getCasa(casaX, casaY).getTipoCasa();

						if (tipoCasaAnalisada == Token.BLANK) {
							auxi += i;
							auxj += j;
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

		return tipoCasaCentral == Token.BLUE ? maxUtilidade : -maxUtilidade;
	}

}
