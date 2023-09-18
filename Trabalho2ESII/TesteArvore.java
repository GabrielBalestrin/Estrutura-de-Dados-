package Trabalho2ESII;

public class TesteArvore {
	public static void main(String[] args) {
		ArvoreAVL arvore = new ArvoreAVL();
		System.out.print("�rvore AVL normal \n");
		arvore.inserir(5);
		arvore.inserir(2);
		arvore.inserir(3);
		arvore.inserir(1);
		arvore.inserir(13);
		arvore.mostrarEmOrdem();
		arvore.remover(3); // EXERC�CIO 2 - TESTE
		System.out.println();
		System.out.println("Ap�s a remo��o: ");
		arvore.mostrarEmOrdem();
		arvore.verificaAVL(); // EXERC�CIO 3 - TESTE
		arvore.contarNosPrimos(); // EXERC�CIO 4 - TESTE
		arvore.mostrarNodosNoNivel(2); // EXERC�CIO 6 - TESTE
		arvore.somaNosNiveisImpares(); // EXERC�CIO 7 - TESTE
		
		//EXERC�CIO 5 - TESTE
		ArvoreAVL a1 = new ArvoreAVL();
		System.out.println("\n�rvore AVL Quest�o 5");
		a1.inserirQuest5(5);
		a1.inserirQuest5(2);
		a1.inserirQuest5(3);
		a1.inserirQuest5(1);
		a1.inserirQuest5(1);
		a1.inserirQuest5(1);
		a1.inserirQuest5(1);
		a1.inserirQuest5(13);
		a1.mostrarEmOrdemQuestao5();
		System.out.println();
		a1.contarOcorrencias();
		a1.removerQ5(1); //	Romove apenas 1 por vez
		a1.mostrarEmOrdemQuestao5();
		System.out.println();
		a1.contarOcorrencias();

	}
}