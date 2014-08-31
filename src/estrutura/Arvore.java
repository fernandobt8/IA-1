package estrutura;

import estrutura.nodos.Nodo;
import estrutura.nodos.NodoMinimo;
import estrutura.tabuleiro.Tabuleiro;

public class Arvore {
	private int profundidade;
	private NodoMinimo begin;

	public Arvore(int profundidade) {
		this.profundidade = profundidade;
	}

	public Tabuleiro getJogada(Tabuleiro tabu) {
		this.begin = new NodoMinimo(tabu);
		this.begin.setUtilityPoint(this.percorrer(this.begin, 0));
		this.begin.printChilds();
		return this.begin.getJogada();
	}

	private Long percorrer(Nodo current, int profundidade) {
		if (this.profundidade <= profundidade) {
			return current.gerarUtilityPoint();
		} else {
			int profun = ++profundidade;
			while (current.setNextChild()) {
				if (current.trespasso()) {
					return current.getUtilityPoint();
				}
				current.setUtilityPoint(this.percorrer(current.createChild(), profun));
			}
			return current.getUtilityPoint();
		}
	}

	public NodoMinimo getBegin() {
		return this.begin;
	}
}
