package estrutura;

public abstract class Nodo {

	protected Long max;
	protected Long min;
	
	public Nodo(){
		this.max = Long.MAX_VALUE;
		this.min = Long.MIN_VALUE;
	}
	public abstract void putUtilityPoint(Long utilityPoint);
	
	public Long getMax() {
		return max;
	}

	public void setMax(Long max) {
		this.max = max;
	}

	public Long getMin() {
		return min;
	}

	public void setMin(Long min) {
		this.min = min;
	}

}
