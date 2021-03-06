package estrutura.nodos;

import java.util.ArrayList;
import java.util.List;

import estrutura.tabuleiro.Tabuleiro;

public abstract class Nodo {
	protected Long betaMax;
	protected Long alphaMin;
	public String name;
	protected List<Nodo> childs = new ArrayList<>();
	protected CountChild currentChildNumber;
	protected Tabuleiro tabuleiro;

	public abstract void setUtilityPoint(Long utilityPoint);

	public abstract Long getUtilityPoint();

	public abstract Nodo createChild();

	public Long gerarUtilityPoint() {
		Long gerarUtilityPoint = this.tabuleiro.gerarUtilityPoint();
		this.setUtilityPoint(gerarUtilityPoint);
		return gerarUtilityPoint;
	}

	public boolean checkWinCondition() {
		return this.tabuleiro.checkWinCondition();
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
				// System.out.println(nodo.getUtilityPoint());
				return nodo.tabuleiro;
			}
		}
		return null;
	}

	public boolean setNextChild() {
		if (this.currentChildNumber.hasMoreChild()) {
			int nextChild = this.currentChildNumber.getNextChild();
			while (!this.tabuleiro.hasColunaDisponivel(nextChild)) {
				if (this.currentChildNumber.hasMoreChild()) {
					nextChild = this.currentChildNumber.getNextChild();
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public void printChilds() {
		for (Nodo n : this.childs) {
			System.out.println(n.name + " - " + n.getUtilityPoint());
		}
	}
}
