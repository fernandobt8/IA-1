package estrutura;

import estrutura.nodos.Nodo;
import estrutura.nodos.NodoMaximo;
import estrutura.tabuleiro.Tabuleiro;

public class Arvore {
	private int profundidade;
	private NodoMaximo begin;

	public Arvore(int profundidade) {
		this.profundidade = profundidade;
	}

	public Tabuleiro jogar(Tabuleiro tabu) {
		this.begin = new NodoMaximo(tabu);
		this.begin.setUtilityPoint(this.percorrer(this.begin, 0));
		return this.begin.getJogada();
	}

	private Long percorrer(Nodo current, int profundidade) {
		if (this.profundidade <= profundidade) {
			return current.gerarUtilityPoint();
		} else {
			int profun = ++profundidade;
			while (current.hasMoreChild()) {
				if (current.trespasso()) {
					return current.getUtilityPoint();
				}
				current.setUtilityPoint(this.percorrer(current.createChild(), profun));
			}
			return current.getUtilityPoint();
		}
	}

	public NodoMaximo getBegin() {
		return this.begin;
	}
}
