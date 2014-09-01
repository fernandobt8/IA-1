package estrutura.tabuleiro;

public class Casa {

	Token tipoCasa;
	long utilidadeCasa;

	public Casa() {
		this.tipoCasa = Token.BLANK;
		this.utilidadeCasa = 0;
	}

	@Override
	public String toString() {
		return this.tipoCasa.toString();
	}

	public void setUtilidade(long valor) {
		this.utilidadeCasa = valor;
	}

	public long getUtilidade() {
		return this.utilidadeCasa;
	}

	public void setTipoCasa(Token tokenType) {
		this.tipoCasa = tokenType;
	}

	public Token getTipoCasa() {
		return this.tipoCasa;
	}

	@Override
	public Casa clone() {
		Casa casa = new Casa();
		casa.setTipoCasa(this.tipoCasa);
		casa.setUtilidade(this.utilidadeCasa);
		return casa;
	}

}
