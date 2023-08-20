package Trabalho3;

import java.util.Random;

public class SelectionSort {
	public static void selectionSort(int array[]) {
	    int min, temp; // Variáveis para armazenar o índice mínimo e auxiliar na troca
	    long comparacoes = 0; 
	    long trocas = 0; 

	    for (int i = 0; i < array.length - 1; i++) {
	        min = i; // Assume que o elemento atual é o mínimo

	        for (int j = i + 1; j < array.length; j++) {
	            comparacoes++; // Incrementa o contador de comparações

	            // Encontra o índice do elemento mínimo no subvetor não ordenado
	            if (array[j] < array[min]) {
	                min = j;
	            }
	        }

	        // Se o índice mínimo for diferente do índice atual, troca os elementos de posição
	        if (min != i) {
	            trocas++; // Incrementa o contador de trocas
	            temp = array[i];
	            array[i] = array[min];
	            array[min] = temp;
	        }
	    }

	    System.out.println("Total de comparações: " + comparacoes);
	    System.out.println("Total de trocas: " + trocas);
	}


    // Métodos auxiliares para gerar vetor aleatório, inverter vetor, testar desempenho e verificar se o vetor está ordenado

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
        long startTime = System.nanoTime();
        selectionSort(array);
        long endTime = System.nanoTime();

        double totalTime = (endTime - startTime) / 1e6;
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
        System.out.println("Selection Sort");

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
