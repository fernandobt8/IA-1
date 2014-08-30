package estrutura.tabuleiro;

public class Tabuleiro {

	public int WIDTH;
	public int HEIGHT;

	private Casa[][] casas;

	public Tabuleiro() {
		this.WIDTH = 7;
		this.HEIGHT = 6;

		this.casas = new Casa[this.HEIGHT][this.WIDTH];
		for (int i = 0; i < this.HEIGHT; i++) {
			for (int j = 0; j < this.WIDTH; j++) {
				this.casas[i][j] = new Casa();
			}
		}
	}

	public Tabuleiro(Casa[][] casas, int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		this.casas = casas;
	}

	public void setCasaValue(int i, int j, Token tokenType) {
		this.casas[i][j].setTipoCasa(tokenType);
	}

	public Casa getCasa(int x, int y) {
		return this.casas[x][y];
	}

	public void printBoard() {
		for (int i = 0; i < this.HEIGHT; i++) {
			for (int j = 0; j < this.WIDTH; j++) {
				System.out.print(this.casas[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void jogar(int column) {
		// TODO fazer
	}

	public boolean hasColunaDisponivel(int column) {
		return true;
	}

	public Long gerarUtilityPoint() {
		return new Double(Math.random() * 100).longValue();
	}

	@Override
	public Tabuleiro clone() {
		Casa[][] casas = new Casa[this.HEIGHT][this.WIDTH];
		for (int i = 0; i < this.HEIGHT; i++) {
			for (int j = 0; j < this.WIDTH; j++) {
				casas[i][j] = this.casas[i][j].clone();
			}
		}
		return new Tabuleiro(casas, this.WIDTH, this.HEIGHT);
	}
}
