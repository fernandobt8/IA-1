package estrutura.tabuleiro;

import utilidade.UtilidadeCombinacoes;

public class Tabuleiro {
	public int COLUMNS;
	public int ROWS;
	private Casa[][] casas;

	public Tabuleiro() {
		this.COLUMNS = 7;
		this.ROWS = 6;
		this.casas = new Casa[this.ROWS][this.COLUMNS];
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLUMNS; j++) {
				this.casas[i][j] = new Casa();
			}
		}
	}

	public Tabuleiro(Casa[][] casas, int width, int height) {
		this.COLUMNS = width;
		this.ROWS = height;
		this.casas = casas;
	}

	public void setCasaValue(int i, int j, Token tokenType) {
		this.casas[i][j].setTipoCasa(tokenType);
	}

	public Casa getCasa(int x, int y) {
		return this.casas[x][y];
	}

	public void printBoard() {
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLUMNS; j++) {
				System.out.print(this.casas[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void jogar(int column, Token token) {
		for (int i = 0; i < this.ROWS; i++) {
			if (i + 1 >= this.ROWS || !this.casas[i + 1][column].getTipoCasa().equals(Token.BLANK)) {
				this.casas[i][column].setTipoCasa(token);
				return;
			}
		}
	}

	public boolean hasColunaDisponivel(int column) {
		return this.casas[0][column].tipoCasa.equals(Token.BLANK);
	}

	public boolean win() {
		return false;
	}

	public Long gerarUtilityPoint() {
		int utilidade = UtilidadeCombinacoes.calculateUtilityCombinacoes(this);
		return (long) utilidade;
	}

	@Override
	public Tabuleiro clone() {
		Casa[][] casas = new Casa[this.ROWS][this.COLUMNS];
		for (int i = 0; i < this.ROWS; i++) {
			for (int j = 0; j < this.COLUMNS; j++) {
				casas[i][j] = this.casas[i][j].clone();
			}
		}
		return new Tabuleiro(casas, this.COLUMNS, this.ROWS);
	}
}
