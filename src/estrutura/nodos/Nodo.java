package estrutura.nodos;

import java.util.List;

public abstract class Nodo {

	protected Long alphaMin;
	protected Long betaMax;
	protected Nodo parent;
	protected List<Nodo> childs;
	
	public Nodo(){
		this.betaMax = Long.MAX_VALUE;
		this.alphaMin = Long.MIN_VALUE;
	}

	public Nodo(Nodo parent){
		this.parent = parent;
		this.betaMax = parent.betaMax;
		this.alphaMin = parent.alphaMin;
	}
	
	public abstract void putUtilityPoint(Long utilityPoint);
	
	public abstract Long getUtilityPoint();
}
