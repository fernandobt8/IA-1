package view;

import estrutura.Arvore;
import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class Jogo {

	private Tabuleiro tabuleiro;
	private Arvore computer;
	private UserViewImpl userView;

	public Jogo() {
		this.tabuleiro = new Tabuleiro();
		this.computer = new Arvore(5);
		this.userView = new UserViewImpl(this);
		this.userView.setVisible(true);
	}

	public void jogar(int row, int col) {
		if (this.tabuleiro.hasColunaDisponivel(col)) {
			this.tabuleiro.setCasaValue(row, col, Token.BLUE);
			Tabuleiro jogada = this.computer.getJogada(this.tabuleiro);
			this.userView.updateTableModel(this.tabuleiro);
		}
	}
}
