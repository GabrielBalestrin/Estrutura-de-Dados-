package Grafos;

public class testeMatrizAdjascencia {
	public static void main(String[] args) {
		
		int numVertices = 3;
		MatrizAdjascente grafo = new MatrizAdjascente(numVertices, false, false);
		
		grafo.inserirAresta(0, 1);
		grafo.inserirAresta(0, 2);
		grafo.inserirAresta(1, 2);
		
		grafo.mostrarMatrizAdjacentes();
		
		System.out.println();
		MatrizAdjascente grafo2 = new MatrizAdjascente(numVertices, true, true);
		grafo2.inserirAresta(0, 1, 3);
		grafo2.inserirAresta(1, 2, 5);
		grafo2.inserirAresta(2, 0, 1);
		grafo2.mostrarMatrizAdjacentes();
		
		
		grafo.removerVertice(1);
		
		
		
		
		
		
	}
}
