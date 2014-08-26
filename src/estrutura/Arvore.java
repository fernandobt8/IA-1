package estrutura;

import estrutura.nodos.Nodo;
import estrutura.nodos.NodoMinimo;

public class Arvore {

	private Nodo begin;
	private int profundidade;

	public Arvore(int profundidade) {
		this.begin = new NodoMinimo();
		this.profundidade = profundidade;
	}

	public void jogar() {

	}

	private Long percorrer(Nodo current, int profundidade) {
		current.createChilds();
		if (this.profundidade == profundidade) {
			return current.gerarUtilityPoint();
		} else if (current.trespasso()) {
			return current.getUtilityPoint();
		}
		return null;
	}
}
