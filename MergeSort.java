package Trabalho3;

import java.util.Random;

public class MergeSort {
	private long comparacoes = 0;
	private long trocas = 0;

	public void mergeSort(int array[], int inicio, int fim) {
	    if (inicio < fim) {
	        int meio = (inicio + fim) / 2;

	        // Divide o array em duas metades e chama o mergeSort recursivamente para cada metade
	        mergeSort(array, inicio, meio);
	        mergeSort(array, meio + 1, fim);

	        // Combina as duas metades ordenadas usando o método merge
	        merge(array, inicio, meio, fim);
	    }
	}

	private void merge(int array[], int inicio, int meio, int fim) {
	    int n1 = meio - inicio + 1; // Tamanho do subarray esquerdo
	    int n2 = fim - meio; // Tamanho do subarray direito

	    // Cria os subarrays temporários para armazenar os elementos
	    int L[] = new int[n1]; // Subarray esquerdo
	    int R[] = new int[n2]; // Subarray direito

	    // Copia os elementos para os subarrays temporários
	    for (int i = 0; i < n1; ++i)
	        L[i] = array[inicio + i];
	    for (int j = 0; j < n2; ++j)
	        R[j] = array[meio + 1 + j];

	    int i = 0, j = 0;
	    int k = inicio;

	    // Combina os subarrays em ordem crescente
	    while (i < n1 && j < n2) {
	        comparacoes++; // Conta o número de comparações

	        // Se o elemento do subarray esquerdo for menor ou igual ao elemento do subarray direito,
	        // coloca o elemento do subarray esquerdo no array final e incrementa o índice do subarray esquerdo
	        if (L[i] <= R[j]) {
	            array[k] = L[i];
	            i++;
	        }
	        // Caso contrário, coloca o elemento do subarray direito no array final e incrementa o índice do subarray direito
	        else {
	            array[k] = R[j];
	            j++;
	            trocas++; // Conta o número de trocas
	        }
	        k++; // Incrementa o índice do array final
	    }

	    // Copia os elementos restantes do subarray esquerdo, se houver
	    while (i < n1) {
	        array[k] = L[i];
	        i++;
	        k++;
	    }

	    // Copia os elementos restantes do subarray direito, se houver
	    while (j < n2) {
	        array[k] = R[j];
	        j++;
	        k++;
	    }
	}


	public long getTrocas() {
	    return trocas;
	}

	public long getComparacoes() {
	    return comparacoes;
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

	public static void testarDesempenho(int[] array) {
	    MergeSort mergeSortInstance = new MergeSort();
	    long startTime = System.nanoTime();
	    mergeSortInstance.mergeSort(array, 0, array.length - 1);
	    long endTime = System.nanoTime();

	    double totalTime = (endTime - startTime) / 1e6;
	    System.out.println("Total de comparações: " + mergeSortInstance.getComparacoes());
	    System.out.println("Total de trocas: " + mergeSortInstance.getTrocas());
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
	    System.out.println("Merge Sort");

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
