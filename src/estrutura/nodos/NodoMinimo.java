package estrutura.nodos;

public class NodoMinimo extends Nodo {

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

}
