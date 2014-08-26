package estrutura.nodos;

import java.util.ArrayList;

import estrutura.tabuleiro.Tabuleiro;

public class NodoMinimo extends Nodo {

	public NodoMinimo(NodoMaximo parent, int colunaJogada) {
		super(parent, colunaJogada);
	}

	public NodoMinimo() {
		super();
	}

	@Override
	public void setUtilityPoint(Long utilityPoint) {
		if (utilityPoint < this.betaMax) {
			this.betaMax = utilityPoint;
		}
	}

	@Override
	public Long getUtilityPoint() {
		return this.betaMax;
	}

	@Override
	public void createChilds() {
		this.childs = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			// TODO verificar se a coluna do tabuleiro ja esta cheia
			// evitar filhos desnecessarios
			this.childs.add(new NodoMaximo(this, i));
		}
	}

	@Override
	public Tabuleiro getJogada() {
		Nodo minimo = this.childs.get(0);
		for (int i = 1; i < 7; i++) {
			Nodo current = this.childs.get(i);
			if (current.getUtilityPoint().compareTo(minimo.getUtilityPoint()) < 0) {
				minimo = current;
			}
		}
		return minimo.getTabuleiro();
	}

}
