package Grafos;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    private ListaAdjascencia grafo;

    public Dijkstra(ListaAdjascencia grafo) {
        this.grafo = grafo;
    }

    public int[] calcularMenorCaminho(int fonte) {
        int nVertices = grafo.getNumeroVertices();
        int[] distancias = new int[nVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[fonte] = 0;

        PriorityQueue<Aresta> pq = new PriorityQueue<>((a, b) -> a.peso - b.peso);
        pq.add(new Aresta(fonte, fonte, 0));

        while (!pq.isEmpty()) {
            Aresta atual = pq.poll();
            int u = atual.destino;

            for (Aresta aresta : grafo.getAdjacencias(u)) {
                int v = aresta.destino;
                int peso = aresta.peso;

                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    pq.add(new Aresta(u, v, distancias[v]));
                }
            }
        }

        return distancias;
    }
    
  
}


