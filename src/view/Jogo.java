package view;

import estrutura.nodos.Arvore;
import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class Jogo {

	private Tabuleiro tabuleiro;
	private Arvore computer;
	private UserViewImpl userView;

	public Jogo(int dificuldade) {
		this.tabuleiro = new Tabuleiro();
		this.computer = new Arvore(dificuldade);
		this.userView = new UserViewImpl(this);
		this.userView.pack();
		this.userView.setLocationRelativeTo(null);
		this.userView.setVisible(true);
	}

	public void jogar(int row, int col) {
		if (this.tabuleiro.hasColunaDisponivel(col)) {
			this.tabuleiro.jogar(col, Token.BLUE);
			if (!this.tabuleiro.checkWinCondition()) {
				this.tabuleiro = this.computer.getJogada(this.tabuleiro);
				if (this.tabuleiro.checkWinCondition()) {
					this.userView.updateTableModel(this.tabuleiro);
					this.userView.showLoser();
				}
			} else {
				this.userView.updateTableModel(this.tabuleiro);
				this.userView.showWin();
			}
			this.userView.updateTableModel(this.tabuleiro);
		}
	}
}
