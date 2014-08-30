package estrutura.nodos;

public class CountChild {
	private int currentMore;// 0-1-2-3-4-5-6
	private int currentLess;// 0-1-2-3-4-5-6
	private MoreOrLess operacao;

	public CountChild() {
		this.currentMore = 3;
		this.currentLess = 4;
		this.operacao = MoreOrLess.LESS;
	}

	public int getNextChild() {
		if (this.operacao.equals(MoreOrLess.MORE)) {
			this.operacao = MoreOrLess.LESS;
			return this.currentMore += 1;
		} else {
			this.operacao = MoreOrLess.MORE;
			return this.currentLess += -1;
		}
	}

	public boolean hasMoreChild() {
		return this.currentLess > 0 || this.currentMore < 6;
	}

	public enum MoreOrLess {
		MORE,
		LESS;
	}

}
