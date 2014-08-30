package estrutura.nodos;

import java.util.ArrayList;
import java.util.List;

import estrutura.tabuleiro.Tabuleiro;

public abstract class Nodo {
	protected Long betaMax;
	protected Long alphaMin;
	protected String name;
	protected List<Nodo> childs = new ArrayList<>();
	protected CountChild currentChildNumber;

	protected Tabuleiro tabuleiro;

	public abstract void setUtilityPoint(Long utilityPoint);

	public abstract Long getUtilityPoint();

	public abstract Nodo createChild();

	public Long gerarUtilityPoint() {
		return this.tabuleiro.gerarUtilityPoint();
	}

	public Nodo(Tabuleiro tabu) {
		this.name = "1";
		this.tabuleiro = tabu.clone();
		this.betaMax = Long.MAX_VALUE;
		this.alphaMin = Long.MIN_VALUE;
		this.currentChildNumber = new CountChild();
	}

	public Nodo(Nodo parent, int colunaJogada) {
		this.name = parent.name + "." + colunaJogada;
		this.tabuleiro = parent.tabuleiro.clone();
		this.tabuleiro.jogar(colunaJogada);
		this.betaMax = parent.betaMax.longValue();
		this.alphaMin = parent.alphaMin.longValue();
		this.currentChildNumber = new CountChild();
	}

	public boolean trespasso() {
		return this.alphaMin.compareTo(this.betaMax) >= 0;
	}

	public Tabuleiro getJogada() {
		for (Nodo nodo : this.childs) {
			if (nodo.getUtilityPoint().equals(this.getUtilityPoint())) {
				return nodo.tabuleiro;
			}
		}
		return null;
	}

	public boolean hasMoreChild() {
		return this.currentChildNumber.hasMoreChild();
	}

}
