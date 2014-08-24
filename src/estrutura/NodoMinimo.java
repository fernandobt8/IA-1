package estrutura;

public class NodoMinimo extends Nodo {

	@Override
	public void putUtilityPoint(Long utilityPoint) {
		this.max = utilityPoint;
	}

}
