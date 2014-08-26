package estrutura.nodos;

public class NodoMinimo extends Nodo {

	@Override
	public void putUtilityPoint(Long utilityPoint) {
		if (utilityPoint < this.max) {
			this.max = utilityPoint;
		}
	}

}
