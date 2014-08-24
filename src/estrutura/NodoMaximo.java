package estrutura;

public class NodoMaximo extends Nodo{

	@Override
	public void putUtilityPoint(Long utilityPoint) {
		this.min = utilityPoint;
	}

}
