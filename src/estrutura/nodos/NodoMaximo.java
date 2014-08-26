package estrutura.nodos;

public class NodoMaximo extends Nodo {

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

}
