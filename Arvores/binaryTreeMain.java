package Arvores;

import java.util.*;

public class binaryTreeMain {
	public static void main(String[] args) {
		ArvoreBinaria ab = new ArvoreBinaria();

		// Inserção e remoção para 100.000 elementos de forma ordenada
		long startTimeInsercao100KOrdenado = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			ab.inserirIterativo(i);
		}
		long endTimeInsercao100KOrdenado = System.currentTimeMillis();
		long tempoInsercao100KOrdenado = endTimeInsercao100KOrdenado - startTimeInsercao100KOrdenado;

		long startTimeRemocao100KOrdenado = System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			ab.removerIterativo(i);
		}
		long endTimeRemocao100KOrdenado = System.currentTimeMillis();
		long tempoRemocao100KOrdenado = endTimeRemocao100KOrdenado - startTimeRemocao100KOrdenado;

		System.out.println("Tempo decorrido (Inserção - 100K - Ordenado): " + tempoInsercao100KOrdenado + " milissegundos");
		System.out.println("Tempo decorrido (Remoção - 100K - Ordenado): " + tempoRemocao100KOrdenado + " milissegundos");

		// Inserção e remoção para 1.000.000 elementos de forma ordenada
		long startTimeInsercao1MOrdenado = System.currentTimeMillis();
		for (int i = 1; i <= 1000000; i++) {
			ab.inserirIterativo(i);
		}
		long endTimeInsercao1MOrdenado = System.currentTimeMillis();
		long tempoInsercao1MOrdenado = endTimeInsercao1MOrdenado - startTimeInsercao1MOrdenado;

		// Busca por 1.000.001 na árvore
		
		int valorBuscado = 1000001;
		long startTimeBusca = System.currentTimeMillis();
		ab.buscar(1000001);
		boolean encontrado = false;
		for (int i = 1; i <= 1000000; i++) {
			if (i == valorBuscado) {
				encontrado = true;
				break;
			}
		}
		if (encontrado) {
			System.out.println("Valor " + valorBuscado + " encontrado na árvore.");
		} else {
			System.out.println("Valor " + valorBuscado + " não encontrado na árvore.");
		}
		long endTimeBusca = System.currentTimeMillis();
		long tempoBusca = endTimeBusca - startTimeBusca;
		System.out.println("Tempo decorrido (Busca): " + tempoBusca + " milissegundos");

		long startTimeRemocao1MOrdenado = System.currentTimeMillis();
		for (int i = 1; i <= 1000000; i++) {
			ab.removerIterativo(i);
		}
		long endTimeRemocao1MOrdenado = System.currentTimeMillis();
		long tempoRemocao1MOrdenado = endTimeRemocao1MOrdenado - startTimeRemocao1MOrdenado;

		System.out.println("Tempo decorrido (Inserção - 1M - Ordenado): " + tempoInsercao1MOrdenado + " milissegundos");
		System.out.println("Tempo decorrido (Remoção - 1M - Ordenado): " + tempoRemocao1MOrdenado + " milissegundos");

		// Inserção e remoção para 100.000 elementos de forma aleatória
		List<Integer> numeros100K = new ArrayList<>();
		for (int i = 1; i <= 100000; i++) {
			numeros100K.add(i);
		}
		Collections.shuffle(numeros100K);

		long startTimeInsercao100KAleatorio = System.currentTimeMillis();
		for (int numero : numeros100K) {
			ab.inserirIterativo(numero);
		}
		long endTimeInsercao100KAleatorio = System.currentTimeMillis();
		long tempoInsercao100KAleatorio = endTimeInsercao100KAleatorio - startTimeInsercao100KAleatorio;

		long startTimeRemocao100KAleatorio = System.currentTimeMillis();
		for (int numero : numeros100K) {
			ab.removerIterativo(numero);
		}
		long endTimeRemocao100KAleatorio = System.currentTimeMillis();
		long tempoRemocao100KAleatorio = endTimeRemocao100KAleatorio - startTimeRemocao100KAleatorio;

		System.out.println(
				"Tempo decorrido (Inserção - 100K - Aleatório): " + tempoInsercao100KAleatorio + " milissegundos");
		System.out.println(
				"Tempo decorrido (Remoção - 100K - Aleatório): " + tempoRemocao100KAleatorio + " milissegundos");

		// Inserção e remoção para 1.000.000 elementos de forma aleatória
		List<Integer> numeros1M = new ArrayList<>();
		for (int i = 1; i <= 1000000; i++) {
			numeros1M.add(i);
		}
		Collections.shuffle(numeros1M);

		long startTimeInsercao1MAleatorio = System.currentTimeMillis();
		for (int numero : numeros1M) {
			ab.inserirIterativo(numero);
		}
		long endTimeInsercao1MAleatorio = System.currentTimeMillis();
		long tempoInsercao1MAleatorio = endTimeInsercao1MAleatorio - startTimeInsercao1MAleatorio;

		// Busca por 1.000.001 na árvore aleatória
		ab.buscar(1000001);
		int valorBuscado1 = 1000001;
		long startTimeBuscaAleatoria = System.currentTimeMillis();
		boolean encontrado1 = false;
		for (int numero : numeros1M) {
			if (numero == valorBuscado1) {
				encontrado1 = true;
				break;
			}
		}
		if (encontrado1) {
			System.out.println("Valor " + valorBuscado1 + " encontrado na árvore aleatória.");
		} else {
			System.out.println("Valor " + valorBuscado1 + " não encontrado na árvore aleatória.");
		}
		long endTimeBuscaAleatoria = System.currentTimeMillis();
		long tempoBuscaAleatoria = endTimeBuscaAleatoria - startTimeBuscaAleatoria;
		System.out.println("Tempo decorrido (Busca - Aleatório): " + tempoBuscaAleatoria + " milissegundos");

		long startTimeRemocao1MAleatorio = System.currentTimeMillis();
		for (int numero : numeros1M) {
			ab.removerIterativo(numero);
		}
		long endTimeRemocao1MAleatorio = System.currentTimeMillis();
		long tempoRemocao1MAleatorio = endTimeRemocao1MAleatorio - startTimeRemocao1MAleatorio;

		System.out
				.println("Tempo decorrido (Inserção - 1M - Aleatório): " + tempoInsercao1MAleatorio + " milissegundos");
		System.out.println("Tempo decorrido (Remoção - 1M - Aleatório): " + tempoRemocao1MAleatorio + " milissegundos");
	}
}

