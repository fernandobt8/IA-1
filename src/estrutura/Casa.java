package estrutura;

import utilidade.Token;

public class Casa {

	Token tipoCasa;
	int utilidadeCasa;

	public Casa() {
		tipoCasa = Token.BLANK;
		utilidadeCasa = 0;
	}

	@Override
	public String toString() {
		return tipoCasa.toString();
	}

	public void setUtilidade(int valor) {
		utilidadeCasa = valor;
	}

	public int getUtilidade() {
		return utilidadeCasa;
	}

	public void setTipoCasa(Token tokenType) {
		tipoCasa = tokenType;
	}

	public Token getTipoCasa() {
		return tipoCasa;
	}
}
