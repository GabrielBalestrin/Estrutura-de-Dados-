package Grafos;

public class TesteListaAdjacencias {
	public static void main(String[] args) {
		ListaAdjascencia grafo = new ListaAdjascencia(4, false);

		grafo.adicionarAresta(0, 1, 2);
		grafo.adicionarAresta(0, 2, 1);
		grafo.adicionarAresta(1, 2, 3);
		grafo.adicionarAresta(2, 3, 4);

		System.out.println("Lista de Adjacências Inicial:");
		grafo.mostrarListaAdjacencias();

		// LETRA A
		grafo.removerVertice(0);

		System.out.println("\nÁpos remover: ");
		grafo.mostrarListaAdjacencias();

		// LETRA B
		grafo.isConexo();

		// LETRA C
		grafo.isCompleto();

		// LETRA E e F
		grafo.verificarEuleriano();
		grafo.isHamiltoniano();
		grafo.isSemiHamiltoniano();

		System.out.println();
		ListaAdjascencia grafo2 = new ListaAdjascencia(4, false);
		grafo2.adicionarAresta(0, 1, 1);
		grafo2.adicionarAresta(0, 2, 1);
		grafo2.adicionarAresta(0, 3, 1);
		grafo2.adicionarAresta(1, 2, 1);
		grafo2.adicionarAresta(1, 3, 1);
		grafo2.adicionarAresta(2, 3, 1);
		grafo2.adicionarAresta(1, 0, 1);

		System.out.println("Lista de Adjacências Grafo 2:");
		grafo2.mostrarListaAdjacencias();
		// LETRA B
		grafo2.isConexo();
		// LETRA C
		grafo2.isCompleto();
		// LETRA E e F
		grafo2.verificarEuleriano();

		grafo2.isHamiltoniano();
		grafo2.isSemiHamiltoniano();
	}
}
