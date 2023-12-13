package Grafos;

import java.util.*;

class Aresta {
	int origem;
	int destino;
	int peso;

	public Aresta(int origem, int destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
}

public class ListaAdjascencia {
	private int nVertices;
	private List<List<Aresta>> adjacencias;
	private boolean direcioanado;

	public ListaAdjascencia(int nVertices, boolean direcionado) {
		this.nVertices = nVertices;
		this.direcioanado = direcionado;
		this.adjacencias = new ArrayList<>(nVertices);
		for (int i = 0; i < nVertices; i++) {
			adjacencias.add(new ArrayList<Aresta>());
		}
	}

	public int getNumeroVertices() {
		return nVertices;
	}

	public List<Aresta> getAdjacencias(int vertice) {
		return adjacencias.get(vertice);
	}

	public void adicionarAresta(int u, int v, int peso) {
		Aresta aresta = new Aresta(u, v, peso);
		adjacencias.get(u).add(aresta);
		if (!direcioanado) {
			Aresta arestaInvertida = new Aresta(v, u, peso);
			adjacencias.get(v).add(arestaInvertida);
		}
	}

	public void AdiconarAresta(int u, int v) {
		adicionarAresta(u, v, 1);
	}

	public void mostrarListaAdjacencias() {
		for (int i = 0; i < nVertices; i++) {
			System.out.print("Vertice " + i + ": ");
			for (Aresta aresta : adjacencias.get(i)) {
				System.out.print("(" + aresta.destino + ", peso: " + aresta.peso + ")");
			}
			System.out.println();
		}

	}

	public void removerAresta(int u, int v) {
		List<Aresta> arestaU = adjacencias.get(u);
		for (Aresta aresta : arestaU) {
			if (aresta.destino == v) {
				arestaU.remove(aresta);
				break;
			}
		}
		if (!direcioanado) {
			List<Aresta> arestaV = adjacencias.get(v);
			for (Aresta aresta : arestaV) {
				if (aresta.destino == u) {
					arestaV.remove(aresta);
					break;
				}
			}
		}
	}

	public boolean saoAdjacentes(int u, int v) {
		for (Aresta aresta : adjacencias.get(u)) {
			if (aresta.destino == v) {
				return true;
			}
		}
		return false;
	}

	public void mostrarLADV(int vertice) {
		System.out.println("vertice " + vertice + ": ");
		for (Aresta aresta : adjacencias.get(vertice)) {
			System.out.println("(" + aresta.destino + " peso: " + aresta.peso + ")");
		}
		System.out.println();
	}

	// a) Remover um vértice
	public void removerVertice(int vertice) {
		for (List<Aresta> lista : adjacencias) {
			lista.removeIf(aresta -> aresta.origem == vertice || aresta.destino == vertice);
		}

		adjacencias.remove(vertice);
		nVertices--;
		System.out.println("Vertice removido!");
	}

	// b) Verificar se um grafo é conexo
	private void dfs(int vertice, boolean[] visitado) {
		visitado[vertice] = true;
		for (Aresta aresta : adjacencias.get(vertice)) {
			if (!visitado[aresta.destino]) {
				dfs(aresta.destino, visitado);
			}
		}
	}

	public boolean isConexo() {
		boolean[] visitado = new boolean[nVertices];
		dfs(0, visitado);

		for (boolean v : visitado) {
			if (!v) {
				System.out.println("O grafo não é conexo.");
				return false;
			}
		}
		System.out.println("O grafo é conexo.");
		return true;
	}

	// c) Verificar se um grafo é completo
	public boolean isCompleto() {
		for (List<Aresta> lista : adjacencias) {
			if (lista.size() != nVertices - 1) {
				System.out.println("O grafo não é completo.");
				return false;
			}
		}
		System.out.println("O grafo é completo.");
		return true;
	}

	// LETRA E
	public enum TipoGrafo {
	    EULERIANO, SEMIEULERIANO, NAOEULERIANO
	}

	public TipoGrafo verificarEuleriano() {
	    int oddCount = 0;
	    for (List<Aresta> lista : adjacencias) {
	        if (lista.size() % 2 != 0)
	            oddCount++;
	    }
	    TipoGrafo resultado;
	    if (oddCount == 0) {
	        resultado = TipoGrafo.EULERIANO;
	    } else if (oddCount == 2) {
	        resultado = TipoGrafo.SEMIEULERIANO;
	    } else {
	        resultado = TipoGrafo.NAOEULERIANO;
	    }
	    
	    System.out.println("Tipo de Grafo Euleriano: " + resultado);
	    return resultado;
	}

	// LETRA F
	public boolean isHamiltoniano() {
		int[] caminho = new int[nVertices];
		Arrays.fill(caminho, -1);
		caminho[0] = 0;
		boolean resultado = isHamiltonianoUtil(caminho, 1);

		if (resultado) {
			System.out.println("O grafo é Hamiltoniano.");
		} else {
			System.out.println("O grafo não é Hamiltoniano.");
		}

		return resultado;
	}

	private boolean isHamiltonianoUtil(int caminho[], int pos) {
		if (pos == nVertices) {
			return saoAdjacentes(caminho[pos - 1], caminho[0]);
		}

		for (int v = 1; v < nVertices; v++) {
			if (podeSerAdicionado(v, caminho, pos)) {
				caminho[pos] = v;
				if (isHamiltonianoUtil(caminho, pos + 1))
					return true;
				caminho[pos] = -1; // Backtrack
			}
		}

		return false;
	}

	private boolean podeSerAdicionado(int v, int caminho[], int pos) {
		// Verifica se o vértice 'v' é adjacente ao último vértice do 'caminho'
		if (!saoAdjacentes(caminho[pos - 1], v))
			return false;

		// Verifica se o vértice 'v' já está no 'caminho'
		for (int i = 0; i < pos; i++) {
			if (caminho[i] == v)
				return false;
		}

		return true;
	}

	public boolean isSemiHamiltoniano() {
	    int[] caminho = new int[nVertices];
	    Arrays.fill(caminho, -1);

	    // Teste para cada vértice se ele é o início de um caminho semi-Hamiltoniano
	    for (int i = 0; i < nVertices; i++) {
	        caminho[0] = i; // Comece do vértice i
	        if (isSemiHamiltonianoUtil(caminho, 1)) {
	            System.out.println("O grafo é Semi-Hamiltoniano.");
	            return true;
	        }
	    }

	    System.out.println("O grafo não é Semi-Hamiltoniano.");
	    return false;
	}

	// Função auxiliar para verificar se é semi-Hamiltoniano
	private boolean isSemiHamiltonianoUtil(int caminho[], int pos) {
		if (pos == nVertices) {
			// Verifica se todos os vértices foram visitados exatamente uma vez
			return true;
		}

		for (int v = 0; v < nVertices; v++) {
			if (podeSerAdicionado(v, caminho, pos)) {
				caminho[pos] = v;
				if (isSemiHamiltonianoUtil(caminho, pos + 1))
					return true;
				caminho[pos] = -1; // Backtrack
			}
		}

		return false;
	}

	/*
	 * Para o algoritmo que verifica se o grafo é hamiltoniano, a estratégia
	 * utilizada é a técnica de backtracking. A função isHamiltonianoUtil realiza
	 * uma busca recursiva explorando todas as possíveis permutações de vértices
	 * para formar um ciclo Hamiltoniano. A cada iteração, a função verifica se o
	 * vértice atual pode ser adicionado ao caminho, garantindo que seja adjacente
	 * ao último vértice do caminho e ainda não tenha sido visitado. O algoritmo
	 * utiliza a estratégia de backtracking para retroceder e tentar outras
	 * combinações quando necessário. No caso do Semi-Hamiltoniano, o backtracking
	 * também é empregado para explorar diferentes caminhos semi-Hamiltonianos,
	 * seguindo a mesma lógica de busca e retrocesso.
	 */
}
