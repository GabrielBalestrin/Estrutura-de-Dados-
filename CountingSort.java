package Trabalho3;

import java.util.Random;

public class CountingSort {
	public static int countingSort(int[] array) {
	    int n = array.length;
	    int[] saida = new int[n];
	    int trocas = 0;

	    int minVal = array[0];
	    int maxVal = array[0];
	    for (int i : array) {
	        if (i < minVal) {
	            minVal = i; // Encontra o menor valor no array
	        }
	        if (i > maxVal) {
	            maxVal = i; // Encontra o maior valor no array
	        }
	    }

	    int[] contadorPositivo = new int[maxVal + 1]; // Contagem para números positivos
	    int[] contadorNegativo = new int[Math.abs(minVal) + 1]; // Contagem para números negativos

	    for (int i = 0; i < n; ++i) {
	        if (array[i] >= 0) {
	            ++contadorPositivo[array[i]]; // Conta a ocorrência de elementos positivos
	        } else {
	            ++contadorNegativo[Math.abs(array[i])]; // Conta a ocorrência de elementos negativos
	        }
	    }

	    for (int i = 1; i < contadorNegativo.length; ++i) {
	        contadorNegativo[i] += contadorNegativo[i - 1]; // Soma as contagens anteriores para obter as posições corretas dos elementos negativos
	    }

	    for (int i = 1; i < contadorPositivo.length; ++i) {
	        contadorPositivo[i] += contadorPositivo[i - 1]; // Soma as contagens anteriores para obter as posições corretas dos elementos positivos
	    }

	    for (int i = n - 1; i >= 0; i--) {
	        if (array[i] >= 0) {
	            saida[contadorPositivo[array[i]] - 1] = array[i]; // Coloca o elemento na posição correta na saída
	            --contadorPositivo[array[i]]; // Decrementa a contagem do elemento positivo
	        } else {
	            saida[contadorNegativo[Math.abs(array[i])] - 1] = array[i]; // Coloca o elemento na posição correta na saída
	            --contadorNegativo[Math.abs(array[i])]; // Decrementa a contagem do elemento negativo
	        }
	        trocas++; // Incrementa o contador de trocas
	    }

	    for (int i = 0; i < n; ++i) {
	        array[i] = saida[i]; // Copia os elementos ordenados de volta para o array original
	    }

	    return trocas; // Retorna o número de trocas realizadas
	}


	public static int[] gerarVetorAleatorio(int tamanho) {
	    int[] vetor = new int[tamanho];
	    Random random = new Random();
	    int min = -100000000;
	    int max =  100000000;
	    for (int i = 0; i < tamanho; i++) {
	        vetor[i] = random.nextInt(max - min + 1) + min;
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
	    long startTime = System.nanoTime();
	    int trocas = countingSort(array);
	    long endTime = System.nanoTime();

	    double totalTime = (endTime - startTime) / 1e6;
	    System.out.println("Tempo de execução: " + totalTime + " ms");
	    System.out.println("Trocas: " + trocas);
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
	    System.out.println("Counting Sort");

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
