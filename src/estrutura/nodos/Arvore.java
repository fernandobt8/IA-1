package estrutura.nodos;

import estrutura.tabuleiro.Tabuleiro;

public class Arvore {
	private int profundidade;
	private NodoMinimo begin;
	private Long passos;

	public Arvore(int profundidade) {
		this.profundidade = profundidade;
	}

	public Tabuleiro getJogada(Tabuleiro tabu) {
		this.passos = 0L;
		this.begin = new NodoMinimo(tabu);
		this.begin.setUtilityPoint(this.percorrer(this.begin, 0));
		System.out.println("Número de passos executados: " + this.passos);
		return this.begin.getJogada();
	}

	private Long percorrer(Nodo current, int profundidade) {
		if (this.profundidade <= profundidade || current.checkWinCondition()) {
			return current.gerarUtilityPoint();
		} else {
			int profun = ++profundidade;
			while (current.setNextChild()) {
				if (current.trespasso()) {
					return current.getUtilityPoint();
				}
				current.setUtilityPoint(this.percorrer(current.createChild(), profun));
				this.passos++;
			}
			return current.getUtilityPoint();
		}
	}

	public NodoMinimo getBegin() {
		return this.begin;
	}
}
