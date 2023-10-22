package Arvores;

import java.util.*;

public class binaryTreeMain {
	public static void main(String[] args) {
		ArvoreBinaria ab = new ArvoreBinaria();

		// Inser��o e remo��o para 100.000 elementos de forma ordenada
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

		System.out.println("Tempo decorrido (Inser��o - 100K - Ordenado): " + tempoInsercao100KOrdenado + " milissegundos");
		System.out.println("Tempo decorrido (Remo��o - 100K - Ordenado): " + tempoRemocao100KOrdenado + " milissegundos");

		// Inser��o e remo��o para 1.000.000 elementos de forma ordenada
		long startTimeInsercao1MOrdenado = System.currentTimeMillis();
		for (int i = 1; i <= 1000000; i++) {
			ab.inserirIterativo(i);
		}
		long endTimeInsercao1MOrdenado = System.currentTimeMillis();
		long tempoInsercao1MOrdenado = endTimeInsercao1MOrdenado - startTimeInsercao1MOrdenado;

		// Busca por 1.000.001 na �rvore
		
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
			System.out.println("Valor " + valorBuscado + " encontrado na �rvore.");
		} else {
			System.out.println("Valor " + valorBuscado + " n�o encontrado na �rvore.");
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

		System.out.println("Tempo decorrido (Inser��o - 1M - Ordenado): " + tempoInsercao1MOrdenado + " milissegundos");
		System.out.println("Tempo decorrido (Remo��o - 1M - Ordenado): " + tempoRemocao1MOrdenado + " milissegundos");

		// Inser��o e remo��o para 100.000 elementos de forma aleat�ria
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
				"Tempo decorrido (Inser��o - 100K - Aleat�rio): " + tempoInsercao100KAleatorio + " milissegundos");
		System.out.println(
				"Tempo decorrido (Remo��o - 100K - Aleat�rio): " + tempoRemocao100KAleatorio + " milissegundos");

		// Inser��o e remo��o para 1.000.000 elementos de forma aleat�ria
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

		// Busca por 1.000.001 na �rvore aleat�ria
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
			System.out.println("Valor " + valorBuscado1 + " encontrado na �rvore aleat�ria.");
		} else {
			System.out.println("Valor " + valorBuscado1 + " n�o encontrado na �rvore aleat�ria.");
		}
		long endTimeBuscaAleatoria = System.currentTimeMillis();
		long tempoBuscaAleatoria = endTimeBuscaAleatoria - startTimeBuscaAleatoria;
		System.out.println("Tempo decorrido (Busca - Aleat�rio): " + tempoBuscaAleatoria + " milissegundos");

		long startTimeRemocao1MAleatorio = System.currentTimeMillis();
		for (int numero : numeros1M) {
			ab.removerIterativo(numero);
		}
		long endTimeRemocao1MAleatorio = System.currentTimeMillis();
		long tempoRemocao1MAleatorio = endTimeRemocao1MAleatorio - startTimeRemocao1MAleatorio;

		System.out
				.println("Tempo decorrido (Inser��o - 1M - Aleat�rio): " + tempoInsercao1MAleatorio + " milissegundos");
		System.out.println("Tempo decorrido (Remo��o - 1M - Aleat�rio): " + tempoRemocao1MAleatorio + " milissegundos");
	}
}

