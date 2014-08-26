package estrutura.nodos;

import java.util.List;

import estrutura.tabuleiro.Tabuleiro;

public abstract class Nodo {

	protected Long alphaMin;
	protected Long betaMax;
	protected Nodo parent;
	protected List<Nodo> childs;

	protected Tabuleiro tabuleiro;

	public abstract void putUtilityPoint(Long utilityPoint);

	public abstract Long getUtilityPoint();

	public abstract void createChilds();

	public Long gerarUtilityPoint() {
		return null;
	}

	public List<Nodo> getChilds() {
		return this.childs;
	}

	public Nodo() {
		this.betaMax = Long.MAX_VALUE;
		this.alphaMin = Long.MIN_VALUE;
	}

	public Nodo(Nodo parent, int colunaJogada) {
		this.parent = parent;
		this.betaMax = parent.betaMax;
		this.alphaMin = parent.alphaMin;
		// TODO gerar jogada baseado na coluna q o pai passo
	}

	public boolean trespasso() {
		return this.alphaMin.compareTo(this.betaMax) >= 0;
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

}
