package estrutura;

import java.util.ArrayList;

public class NodoMinimo extends Nodo {

	public NodoMinimo(NodoMaximo parent, int colunaJogada) {
		super(parent, colunaJogada);
	}

	public NodoMinimo() {
		super();
	}

	@Override
	public void putUtilityPoint(Long utilityPoint) {
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

}
