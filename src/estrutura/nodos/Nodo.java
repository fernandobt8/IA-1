package estrutura.nodos;

import java.util.ArrayList;
import java.util.List;

import estrutura.tabuleiro.Tabuleiro;

public abstract class Nodo {
	protected Long betaMax;
	protected Long alphaMin;
	protected String name;
	protected Nodo parent;
	protected List<Nodo> childs = new ArrayList<>();
	protected int numberChild = 0;

	protected Tabuleiro tabuleiro;

	public abstract void setUtilityPoint(Long utilityPoint);

	public abstract Long getUtilityPoint();

	public abstract Nodo createChild();

	public Long getBetaMax() {
		return this.betaMax;
	}

	public Long getAlphaMin() {
		return this.alphaMin;
	}

	public Long gerarUtilityPoint() {
		long longValue = new Double(Math.random() * 100).longValue();
		// System.out.println(this.name + "- " + longValue);
		return longValue;
	}

	public Nodo(Tabuleiro tabu) {
		this.name = "1";
		this.tabuleiro = tabu;
		this.betaMax = Long.MAX_VALUE;
		this.alphaMin = Long.MIN_VALUE;
	}

	public Nodo(Nodo parent, int colunaJogada) {
		this.name = parent.name + "." + colunaJogada;
		this.parent = parent;
		this.betaMax = parent.betaMax.longValue();
		this.alphaMin = parent.alphaMin.longValue();
		// TODO gerar jogada baseado na coluna q o pai passo
	}

	public boolean trespasso() {
		return this.alphaMin.compareTo(this.betaMax) >= 0;
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

	public Tabuleiro getJogada() {
		for (Nodo nodo : this.childs) {
			if (nodo.getUtilityPoint().equals(this.getUtilityPoint())) {
				return nodo.getTabuleiro();
			}
		}
		return null;
	}

	public boolean hasMoreChild() {
		return this.numberChild < 7;
	}

}
