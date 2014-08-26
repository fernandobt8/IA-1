package estrutura;

import estrutura.nodos.Nodo;
import estrutura.nodos.NodoMinimo;
import estrutura.tabuleiro.Tabuleiro;

public class Arvore {

	private Nodo begin;
	private int profundidade;

	public Arvore(int profundidade) {
		this.begin = new NodoMinimo();
		this.profundidade = profundidade;
	}

	public Tabuleiro jogar() {
		this.begin.setUtilityPoint(this
				.percorrer(this.begin, this.profundidade));
		return this.begin.getJogada();
	}

	private Long percorrer(Nodo current, int profundidade) {
		if (this.profundidade == profundidade) {
			return current.gerarUtilityPoint();
		} else if (current.trespasso()) {
			return current.getUtilityPoint();
		}
		current.createChilds();
		return null;
	}
}
