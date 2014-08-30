package utilidade;

import estrutura.nodos.CountChild;

public class ArvoreTest {

	public static void main(String[] args) {
		CountChild c = new CountChild();
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.getNextChild());
		System.out.println(c.hasMoreChild());

		// Arvore arvore = new Arvore(5);
		// Tabuleiro tabuleiro = new Tabuleiro();
		// arvore.jogar(tabuleiro);
		// System.out.println(arvore.getBegin().getUtilityPoint());
	}
}
