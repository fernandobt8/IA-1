package estrutura;

import java.util.ArrayList;

public class NodoMaximo extends Nodo {

	public NodoMaximo(NodoMinimo parent, int colunaJogada) {
		super(parent, colunaJogada);
	}

	public NodoMaximo() {
		super();
	}

	@Override
	public void putUtilityPoint(Long utilityPoint) {
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

}
