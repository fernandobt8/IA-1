package utilidade;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class CalculoUtilidade {

	private static Tabuleiro tabuleiro;

	public static long calculateUtilityCombinacoes(Tabuleiro tabuleiro) {
		// System.out.prlongln();

		CalculoUtilidade.tabuleiro = tabuleiro;
		long utilidadeTabuleiro = 0;

		for (int x = 0; x < tabuleiro.ROWS; x++) {
			for (int y = 0; y < tabuleiro.COLUMNS; y++) {
				Token tipoCasaCentral = tabuleiro.getCasa(x, y).getTipoCasa();
				long utilidadeCasa = 0;

				if (tipoCasaCentral != Token.BLANK) {
					utilidadeCasa = calculateUtilidadeCasa(x, y, tipoCasaCentral);
					utilidadeTabuleiro += utilidadeCasa;
				}

				tabuleiro.getCasa(x, y).setUtilidade(utilidadeCasa);
				// System.out.prlong(utilidadeCasa + "\t");
			}
			// System.out.prlongln();
		}

		return utilidadeTabuleiro;
	}

	private static long calculateUtilidadeCasa(int x, int y, Token tipoCasaCentral) {
		long maxUtilidade = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {

				long utilidade = 1;

				if (i == 0 && j == 0) {
					continue;
				}

				int auxi = i;
				int auxj = j;
				for (int v = 1; v <= 3; v++) { // Observa até 4 vizinhos na direção indicada;
					int casaX = x + v * auxi;
					int casaY = y + v * auxj;

					if (casaX >= 0 && casaY >= 0 && casaX < tabuleiro.ROWS && casaY < tabuleiro.COLUMNS) { // Se for uma casa válida;
						Token tipoCasaAnalisada = tabuleiro.getCasa(casaX, casaY).getTipoCasa();

						if (tipoCasaAnalisada == Token.BLANK) {
							auxi += i;
							auxj += j;
							continue;
						} else if (tipoCasaAnalisada != tipoCasaCentral) {
							utilidade = 0;
							break;
						} else if (tipoCasaAnalisada == tipoCasaCentral) {
							utilidade = calcularUtilidade(utilidade);
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
		// return maxUtilidade;
	}

	private static long calcularUtilidade(long utilidade) {
		long length = (long) Math.log10(utilidade);
		return (long) Math.pow(10, length + 3);
	}

}
