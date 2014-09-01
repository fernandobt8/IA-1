package estrutura.nodos;

import estrutura.tabuleiro.Tabuleiro;
import estrutura.tabuleiro.Token;

public class NodoMaximo extends Nodo {

	public NodoMaximo(NodoMinimo parent, int colunaJogada) {
		super(parent, colunaJogada);
		this.tabuleiro.jogar(colunaJogada, Token.RED);
	}

	public NodoMaximo(Tabuleiro tabu) {
		super(tabu);
	}

	@Override
	public void setUtilityPoint(Long utilityPoint) {
		if (utilityPoint.compareTo(this.alphaMin) > 0) {
			this.alphaMin = utilityPoint.longValue();
			// System.out.println(this.name + "max: " + this.alphaMin + " / " + this.betaMax);
		}
	}

	@Override
	public Long getUtilityPoint() {
		return this.alphaMin.longValue();
	}

	@Override
	public Nodo createChild() {
		NodoMinimo nodoMinimo = new NodoMinimo(this, this.currentChildNumber.getCurrentChild());
		this.childs.add(nodoMinimo);
		return nodoMinimo;
	}
}
