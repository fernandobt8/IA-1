package utilidade;

import view.ViewImpl;
import estrutura.Arvore;
import estrutura.tabuleiro.Tabuleiro;

public class ArvoreTest {

	public static void main(String[] args) {
		ViewImpl viewImpl = new ViewImpl();
		viewImpl.setVisible(true);

		Arvore arvore = new Arvore(2);
		Tabuleiro tabuleiro = new Tabuleiro();
		arvore.jogar(tabuleiro);
		System.out.println(arvore.getBegin().getUtilityPoint());
	}
}
