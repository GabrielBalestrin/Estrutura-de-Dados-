package Trabalho3;

import java.util.Random;

public class QuickSort {
    private static long comparacoes = 0; // Contador de comparações
    private static long trocas = 0; // Contador de trocas

    public static void quickSort(int X[], int inicio, int fim) {
        if (inicio < fim) {
            int q = particao(X, inicio, fim);
            quickSort(X, inicio, q); // Chama o quickSort para a primeira metade do array
            quickSort(X, q + 1, fim); // Chama o quickSort para a segunda metade do array
        }
    }

    private static int particao(int X[], int inicio, int fim) {
        Random random = new Random();
        int pivoIndex = random.nextInt(fim - inicio + 1) + inicio; // Escolhe um índice aleatório como pivô
        int pivo = X[pivoIndex]; // Obtém o valor do pivô

        // Trocar o pivô com o último elemento do vetor
        int aux = X[pivoIndex];
        X[pivoIndex] = X[fim];
        X[fim] = aux;

        int i = inicio - 1;
        int j = fim;

        while (true) {
            do {
                j = j - 1;
                comparacoes++; // Incrementa a contagem de comparações
            } while (j >= inicio && X[j] > pivo);

            do {
                i = i + 1;
                comparacoes++; // Incrementa a contagem de comparações
            } while (i <= fim && X[i] < pivo);

            if (i < j) {
                aux = X[i];
                X[i] = X[j];
                X[j] = aux;
                trocas++; // Incrementa a contagem de trocas
            } else {
                break;
            }
        }
        return j; // Retorna o índice onde o pivô está posicionado
    }



	public static int[] gerarVetorAleatorio(int tamanho) {
		int[] vetor = new int[tamanho];
		Random random = new Random();
		for (int i = 0; i < tamanho; i++) {
			vetor[i] = random.nextInt();
		}
		return vetor;
	}

	public static void inverterVetor(int[] vetor) {
		int n = vetor.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = vetor[i];
			vetor[i] = vetor[n - i - 1];
			vetor[n - i - 1] = temp;
		}
	}

	public static long getTrocas() {
		return trocas;
	}

	public static long getComparacoes() {
		return comparacoes;
	}

	public static void testarDesempenho(int[] array) {
		comparacoes = 0;
		trocas = 0;
		long startTime = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		long endTime = System.nanoTime();

		double totalTime = (endTime - startTime) / 1e6;
		System.out.println("Total de comparações: " + comparacoes);
		System.out.println("Total de trocas: " + trocas);
		System.out.println("Tempo de execução: " + totalTime + " ms");
	}

	public static boolean estaOrdenado(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Quick Sort");

		int[] vetorAleatorio100000 = gerarVetorAleatorio(100000);
		int[] vetorAleatorio1000000 = gerarVetorAleatorio(1000000);

		// Testes de desempenho para o vetor aleatório de 100.000 elementos
		System.out.println("Vetor aleatório de 100.000 elementos:");
		testarDesempenho(vetorAleatorio100000);

		// Testando o vetor de 100.000 elementos ordenado
		System.out.println("\nVetor ordenado de 100.000 elementos:");
		if (estaOrdenado(vetorAleatorio100000)) {
			testarDesempenho(vetorAleatorio100000);
		} else {
			System.out.println("Vetor não ordenado");
			testarDesempenho(vetorAleatorio100000);
		}

		// Invertendo o vetor de 100.000 elementos
		inverterVetor(vetorAleatorio100000);

		// Testando o vetor de 100.000 elementos invertido
		System.out.println("\nVetor invertido de 100.000 elementos:");
		testarDesempenho(vetorAleatorio100000);

		// Testes de desempenho para o vetor aleatório de 1.000.000 elementos
		System.out.println("\nVetor aleatório de 1.000.000 elementos:");
		testarDesempenho(vetorAleatorio1000000);

		// Testando o vetor de 1.000.000 elementos ordenado
		System.out.println("\nVetor ordenado de 1.000.000 elementos:");
		if (estaOrdenado(vetorAleatorio1000000)) {
			testarDesempenho(vetorAleatorio1000000);
		} else {
			System.out.println("Vetor não ordenado");
			testarDesempenho(vetorAleatorio1000000);
		}

		// Invertendo o vetor de 1.000.000 elementos
		inverterVetor(vetorAleatorio1000000);

		// Testando o vetor de 1.000.000 elementos invertido
		System.out.println("\nVetor invertido de 1.000.000 elementos:");
		testarDesempenho(vetorAleatorio1000000);
	}
}