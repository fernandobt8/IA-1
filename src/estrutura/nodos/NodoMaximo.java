package estrutura.nodos;

import java.util.ArrayList;

import estrutura.tabuleiro.Tabuleiro;

public class NodoMaximo extends Nodo {

	public NodoMaximo(NodoMinimo parent, int colunaJogada) {
		super(parent, colunaJogada);
	}

	public NodoMaximo() {
		super();
	}

	@Override
	public void setUtilityPoint(Long utilityPoint) {
		if (utilityPoint > this.alphaMin) {
			this.alphaMin = utilityPoint;
		}
	}

	@Override
	public Long getUtilityPoint() {
		return this.alphaMin;
	}

	@Override
	public void createChilds() {
		this.childs = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			// TODO verificar se a coluna do tabuleiro ja esta cheia
			// evitar filhos desnecessarios
			this.childs.add(new NodoMinimo(this, i));
		}
	}

	@Override
	public Tabuleiro getJogada() {
		Nodo maximo = this.childs.get(0);
		for (int i = 1; i < 7; i++) {
			Nodo current = this.childs.get(i);
			if (current.getUtilityPoint().compareTo(maximo.getUtilityPoint()) > 0) {
				maximo = current;
			}
		}
		return maximo.getTabuleiro();
	}
}
