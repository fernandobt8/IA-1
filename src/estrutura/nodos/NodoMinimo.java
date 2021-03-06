package estrutura.nodos;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class NodoMinimo extends Nodo {

	public NodoMinimo(NodoMaximo parent, int colunaJogada) {
		super(parent, colunaJogada);
		this.tabuleiro.jogar(colunaJogada, Token.BLUE);
	}

	public NodoMinimo(Tabuleiro tabu) {
		super(tabu);
	}

	@Override
	public void setUtilityPoint(Long utilityPoint) {
		if (utilityPoint.compareTo(this.betaMax) < 0) {
			this.betaMax = utilityPoint.longValue();
			// System.out.println(this.name + "min: " + this.alphaMin + " / " + this.betaMax);
		}
	}

	@Override
	public Long getUtilityPoint() {
		return this.betaMax.longValue();
	}

	@Override
	public Nodo createChild() {
		NodoMaximo nodoMaximo = new NodoMaximo(this, this.currentChildNumber.getCurrentChild());
		this.childs.add(nodoMaximo);
		return nodoMaximo;
	}
}
