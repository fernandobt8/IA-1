package estrutura;

public class NodoMaximo extends Nodo {

	@Override
	public void putUtilityPoint(Long utilityPoint) {
		if (utilityPoint > this.min) {
			this.min = utilityPoint;
		}
	}

}
