package Grafos;

public class testeDij {
	public static void main(String[] args) {
		//EXERCICIO 2.A
		ListaAdjascencia grafo = new ListaAdjascencia(5, true);

		grafo.adicionarAresta(0, 1, 1);
		grafo.adicionarAresta(0, 3, 3);
		grafo.adicionarAresta(0, 4, 10);
		grafo.adicionarAresta(1, 2, 5);
		grafo.adicionarAresta(2, 4, 1);
		grafo.adicionarAresta(3, 2, 2);
		grafo.adicionarAresta(3, 4, 6);

		grafo.mostrarListaAdjacencias(); // Mostra a lista de adjacências para verificar se está correta

		Dijkstra dijkstra = new Dijkstra(grafo);

		int fonte = 0; // Vértice de origem
		int[] distancias = dijkstra.calcularMenorCaminho(fonte);

		// Exibindo as distâncias mínimas da fonte para todos os vértices
		System.out.println("Distâncias mínimas da fonte " + fonte + " para todos os vértices:");
		for (int i = 0; i < distancias.length; i++) {
			System.out.println("Para o vértice " + i + ": " + distancias[i]);
		}
		
		System.out.println();
		// EXERCICIO 2.2
		int origemCaminho = 1; // Vértice de origem (nó 1)
		int destinoCaminho = 4; // Vértice de destino (nó 4)

		int[] caminho1to4 = dijkstra.calcularMenorCaminho(origemCaminho);
		int pesoCaminho1to4 = caminho1to4[destinoCaminho];
		
		// Exibindo o somatório das distâncias mínimas do vértice 1 ao vértice 4
		System.out.println("Somatório das distâncias mínimas do vértice " + origemCaminho + " ao vértice " + destinoCaminho + ": " + pesoCaminho1to4);
		
	
		//EXERCICIO 2.B
		ListaAdjascencia grafo2 = new ListaAdjascencia(6, true);
		grafo2.adicionarAresta(0, 1, 15);
		grafo2.adicionarAresta(0, 2, 9);
		grafo2.adicionarAresta(1, 3, 2);
		grafo2.adicionarAresta(2, 1, 4);
		grafo2.adicionarAresta(2, 3, 3);
		grafo2.adicionarAresta(2, 4, 16);
		grafo2.adicionarAresta(3, 4, 6);
		grafo2.adicionarAresta(3, 5, 21);
		grafo2.adicionarAresta(4, 5, 7);

		System.out.println();
		ListaAdjascencia grafo5 = new ListaAdjascencia(6, true);
		grafo5.adicionarAresta(0, 1, 15);
		grafo5.adicionarAresta(0, 2, 9);
		grafo5.adicionarAresta(1, 3, 2);
		grafo5.adicionarAresta(2, 1, 4);
		grafo5.adicionarAresta(2, 3, 3);
		grafo5.adicionarAresta(2, 4, 16);
		grafo5.adicionarAresta(3, 4, 6);
		grafo5.adicionarAresta(3, 5, 21);
		grafo5.adicionarAresta(4, 5, 7);

		grafo2.mostrarListaAdjacencias(); // Mostra a lista de adjacências para verificar se está correta

		Dijkstra dijkstra1 = new Dijkstra(grafo5);

		int fontee = 0; // Vértice de origem (nó 1)
		int destino = 5; // Vértice de destino (nó 6)

		int[] distanciass = dijkstra1.calcularMenorCaminho(fonte);

		// Exibindo a distância mínima da fonte para o destino
		System.out.println("Distância mínima do nó " + fontee + " para o nó " + destino + ": " + distanciass[destino]);
		
		
		// EXERCICIO 2.C
		ListaAdjascencia g3 = new ListaAdjascencia(18, false);
		
		g3.adicionarAresta(0, 1, 170);
		g3.adicionarAresta(0, 2, 260);
		
		g3.adicionarAresta(1, 0, 170);
		g3.adicionarAresta(1, 2, 135);
		g3.adicionarAresta(1, 17, 80);
		
		g3.adicionarAresta(2, 0, 260);
		g3.adicionarAresta(2, 1, 135);
		g3.adicionarAresta(2, 3, 50);
		
		g3.adicionarAresta(3, 2, 50);
		g3.adicionarAresta(3, 17, 150);
		g3.adicionarAresta(3, 4, 70);
		g3.adicionarAresta(3, 5, 130);
		
		g3.adicionarAresta(4, 3, 70);
		g3.adicionarAresta(4, 17, 120);
		g3.adicionarAresta(4, 16, 150);
		g3.adicionarAresta(4, 6, 200);
		
		g3.adicionarAresta(5, 3, 130);
		g3.adicionarAresta(5, 15, 70);
		
		g3.adicionarAresta(6, 4, 200);
		g3.adicionarAresta(6, 16, 80);
		g3.adicionarAresta(6, 7, 100);
		g3.adicionarAresta(6, 15, 160);

		g3.adicionarAresta(7, 6, 100);
		g3.adicionarAresta(7, 15, 160);
		g3.adicionarAresta(7, 10, 80);
		g3.adicionarAresta(7, 9, 150);
		g3.adicionarAresta(7, 8, 200);
		
		g3.adicionarAresta(8, 7, 200);
		g3.adicionarAresta(8, 9, 140);
		
		g3.adicionarAresta(9, 9, 140);
		g3.adicionarAresta(9, 10, 110);
		g3.adicionarAresta(9, 7, 150);
		g3.adicionarAresta(9, 11, 120);
		g3.adicionarAresta(9, 12, 100);
		
		g3.adicionarAresta(10, 7, 80);
		g3.adicionarAresta(10, 15, 80);
		g3.adicionarAresta(10, 14, 100);
		g3.adicionarAresta(10, 9, 110);
		
		g3.adicionarAresta(11, 9, 120);
		g3.adicionarAresta(11, 14, 70);
		g3.adicionarAresta(11, 12, 50);
		g3.adicionarAresta(11, 13, 80);
		
		g3.adicionarAresta(12, 13, 50);
		g3.adicionarAresta(12, 9, 100);
		g3.adicionarAresta(12, 11, 50);
		
		g3.adicionarAresta(13, 12, 50);
		g3.adicionarAresta(13, 11, 80);
		
		g3.adicionarAresta(14, 11, 70);
		g3.adicionarAresta(14, 10, 100);
		g3.adicionarAresta(14, 15, 80);
		
		g3.adicionarAresta(15, 5, 70);
		g3.adicionarAresta(15, 6, 100);
		g3.adicionarAresta(15, 7, 160);
		g3.adicionarAresta(15, 10, 80);		
		g3.adicionarAresta(15, 14, 80);
		
		g3.adicionarAresta(16, 4, 150);
		g3.adicionarAresta(16, 17, 100);
		g3.adicionarAresta(16, 6, 80);
		
		g3.adicionarAresta(17, 1, 80);
		g3.adicionarAresta(17, 3, 150);
		g3.adicionarAresta(17, 4, 120);
		g3.adicionarAresta(17, 16, 100);
		
		Dijkstra dijkstraGrafo3 = new Dijkstra(g3);

		int origemGrafo3 = 3; 
		int destinoGrafo3 = 8; 

		int[] distanciasGrafo3 = dijkstraGrafo3.calcularMenorCaminho(origemGrafo3);
		System.out.println("\n A menor distância entre Lisboa e Braga");
		System.out.println("Distância mínima do vértice " + origemGrafo3 + " para o vértice " + destinoGrafo3 + ": " + distanciasGrafo3[destinoGrafo3]);
	}
}