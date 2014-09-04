package view;

import estrutura.nodos.Arvore;
import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class Jogo {

	private Tabuleiro tabuleiro;
	private Arvore computer;
	private UserViewImpl userView;

	public Jogo(int dificuldade, int primeiroJogador) {
		this.tabuleiro = new Tabuleiro();
		this.computer = new Arvore(dificuldade);
		this.userView = new UserViewImpl(this);
		this.userView.pack();
		this.userView.setLocationRelativeTo(null);
		this.userView.setVisible(true);

		if (primeiroJogador == 1) {
			this.tabuleiro = this.computer.getJogada(this.tabuleiro);
			this.userView.updateTableModel(this.tabuleiro);
		}
	}

	public void jogar(int col) {
		if (this.tabuleiro.hasColunaDisponivel(col)) {
			this.tabuleiro.jogar(col, Token.BLUE);
			Jogo.this.userView.updateTableModel(Jogo.this.tabuleiro);
			if (!this.tabuleiro.checkWinCondition()) {
				this.tabuleiro = this.computer.getJogada(this.tabuleiro);
				this.userView.updateTableModel(this.tabuleiro);
				if (this.tabuleiro.checkWinCondition()) {
					this.userView.showLoser();
				}
			} else {
				this.userView.showWin();
			}
		}
	}
}
