package Trabalho2ESII;

public class TesteArvore {
	public static void main(String[] args) {
		ArvoreAVL arvore = new ArvoreAVL();
		System.out.print("Árvore AVL normal \n");
		arvore.inserir(5);
		arvore.inserir(2);
		arvore.inserir(3);
		arvore.inserir(1);
		arvore.inserir(13);
		arvore.mostrarEmOrdem();
		arvore.remover(3); // EXERCÍCIO 2 - TESTE
		System.out.println();
		System.out.println("Após a remoção: ");
		arvore.mostrarEmOrdem();
		arvore.verificaAVL(); // EXERCÍCIO 3 - TESTE
		arvore.contarNosPrimos(); // EXERCÍCIO 4 - TESTE
		arvore.mostrarNodosNoNivel(2); // EXERCÍCIO 6 - TESTE
		arvore.somaNosNiveisImpares(); // EXERCÍCIO 7 - TESTE
		
		//EXERCÍCIO 5 - TESTE
		ArvoreAVL a1 = new ArvoreAVL();
		System.out.println("\nÁrvore AVL Questão 5");
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