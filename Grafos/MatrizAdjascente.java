package Grafos;

public class MatrizAdjascente {
	private int[][] G;
	private int numVertices;
	private boolean ponderado;
	private boolean direcionado;

	public MatrizAdjascente(int numVertices, boolean ponderado, boolean direcionado) {
		this.numVertices = numVertices;
		this.direcionado = direcionado;
		this.ponderado = ponderado;
		G = new int[numVertices][numVertices];
	}

	public void inserirAresta(int vertice1, int vertice2) {
		if (!ponderado) {
			G[vertice1][vertice2] = 1;
			if (!direcionado) {
				G[vertice2][vertice1] = 1;
			}
		} else {
			System.out.println("Grafo ponderado. Necessita de peso da aresta");
		}
	}

	public void inserirAresta(int vertice1, int vertice2, int peso) {
		if (ponderado) {
			G[vertice1][vertice2] = peso;
			if (!direcionado) {
				G[vertice2][vertice1] = peso;
			}
		} else {
			System.out.println("Grafo não ponderado. Arestas nao possuem pesos");
		}
	}

	public void removerAresta(int vertice1, int vertice2) {
		G[vertice1][vertice2] = 0;
		if (!direcionado) {
			G[vertice2][vertice1] = 0;
		}
	}
	
	public void mostrarMatrizAdjacentes() {
		for (int i = 0; i < numVertices; i++) {
			for (int j= 0; j < numVertices; j++) {
				System.out.print(G[i][j]+" ");	
			}
				System.out.println();
		}
	}

	public boolean verificaAdjascencia(int vertice1, int vertice2) {
		return G[vertice1][vertice2] != 0;
		 
	}
	
	// LETRA A
	public void removerVertice(int vertice) {
	    int[][] novaMatriz = new int[numVertices - 1][numVertices - 1];

	    for (int i = 0, iNovo = 0; i < numVertices; i++) {
	        if (i == vertice) continue; // Pula o vértice a ser removido

	        for (int j = 0, jNovo = 0; j < numVertices; j++) {
	            if (j == vertice) continue; // Pula o vértice a ser removido

	            novaMatriz[iNovo][jNovo] = G[i][j];
	            jNovo++;
	        }
	        iNovo++;
	    }

	    G = novaMatriz;
	    numVertices--;
	}
	
	// LETRA B
	public boolean isConexo() {
	    boolean[] visitado = new boolean[numVertices];
	    dfs(0, visitado);

	    for (boolean v : visitado) {
	        if (!v) return false;
	    }
	    return true;
	}

	private void dfs(int vertice, boolean[] visitado) {
	    visitado[vertice] = true;
	    for (int i = 0; i < numVertices; i++) {
	        if (G[vertice][i] != 0 && !visitado[i]) {
	            dfs(i, visitado);
	        }
	    }
	}

 //LETRA C
	public boolean isCompleto() {
	    for (int i = 0; i < numVertices; i++) {
	        for (int j = 0; j < numVertices; j++) {
	            if (i != j && G[i][j] == 0) return false;
	        }
	    }
	    return true;
	}


}
