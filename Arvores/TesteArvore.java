package Arvores;

public class TesteArvore {
	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		
		arvore.inserir(30);
		arvore.inserir(25);
		arvore.inserir(21);
		arvore.inserir(12);
		arvore.inserir(40);
		arvore.inserir(27);
		arvore.inserir(45);
		arvore.inserir(45);
		arvore.inserir(10);
		arvore.inserir(11);
		arvore.inserir(26);
		arvore.inserir(28);
		arvore.inserirNaoRecursivo(100); //Letra M
		arvore.inserirNaoRecursivo(1); //Letra M
		
		arvore.mostrarEmOrdem();
		arvore.mostrarEmOrdemDecrescente();
		arvore.mostrarPorNivel();
		
		// Exercicios
		arvore.mostrarMenorNumero(); //Letra A
		
		arvore.mostrarMaiorNumero(); //Letra B
		
		arvore.mostrarNumerosPares(); //Letra I
		
		arvore.mostrarNo(2);	//Letra C
		
		arvore.mostrarAncestrais(27); // Letra D
		
		arvore.mostrarDescendentes(27);  //Letra E
		
		arvore.mostrarSubArvoreDireita(10); // letra F
		arvore.mostrarSubArvoreEsquerda(10); // Letra G
		
		arvore.mostrarNivelDoNodo(30);  //Letra J
		
		arvore.calcularAltura();  //Letra K
		
		arvore.calcularTamanho(); // Letra L
		arvore.transformarEmLista();  //Letra H
		arvore.imprimirLista();

	}
}