package utilidade;

import estrutura.Arvore;
import estrutura.tabuleiro.Tabuleiro;

public class ArvoreTest {

	public static void main(String[] args) {
		Arvore arvore = new Arvore(5);
		Tabuleiro tabuleiro = new Tabuleiro();
		arvore.jogar(tabuleiro);
		System.out.println(arvore.getBegin().getUtilityPoint());
	}
}
