package Trabalho3;

import java.util.Random;

public class InsertionSort {
    // M�todo para realizar a ordena��o por Insertion Sort
	public static void insertionSort(int array[]) {
	    long trocas = 0; 
	    long comparacoes = 0; 

	    for (int i = 1; i < array.length; i++) {
	        int pivo = array[i]; // Armazena o valor do elemento atual
	        int j = i - 1; // Inicializa o �ndice do elemento anterior

	        while (j >= 0) {
	            comparacoes++; // Incrementa o contador de compara��es

	            if (array[j] > pivo) {
	                // Se o elemento anterior for maior que o elemento atual,
	                // desloca o elemento anterior para a direita

	                array[j + 1] = array[j]; // Realiza a troca
	                trocas++; // Incrementa o contador de trocas
	                j--; // Move para o elemento anterior
	            } else {
	                break; // Se o elemento anterior for menor ou igual, interrompe o loop
	            }
	        }

	        array[j + 1] = pivo; // Insere o elemento atual na posi��o correta
	    }

	    System.out.println("Total de compara��es: " + comparacoes);
	    System.out.println("Total de trocas: " + trocas);
	}


    // M�todo para gerar um vetor aleat�rio de tamanho especificado, passando por par�metro o tamanho
    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt();
        }
        return vetor;
    }

    // M�todo para inverter a ordem dos elementos em um vetor
    public static void inverterVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - i - 1];
            vetor[n - i - 1] = temp;
        }
    }

    // M�todo para testar o desempenho do algoritmo de ordena��o
    // Chama o m�todo de ordena��o e faz um cron�metro para o tempo total do teste
    public static void testarDesempenho(int[] array) {
        long startTime = System.nanoTime();
        insertionSort(array);
        long endTime = System.nanoTime();

        double totalTime = (endTime - startTime) / 1e6; // Tempo em milissegundos
        System.out.println("Tempo de execu��o: " + totalTime + " ms");
    }

    // M�todo para verificar se um vetor est� ordenado
    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Insertion Sort");

        int[] vetorAleatorio100000 = gerarVetorAleatorio(100000);
        int[] vetorAleatorio1000000 = gerarVetorAleatorio(1000000);

        // Testes de desempenho para o vetor aleat�rio de 100.000 elementos
        System.out.println("Vetor aleat�rio de 100.000 elementos:");
        testarDesempenho(vetorAleatorio100000);

        // Testando o vetor de 100.000 elementos ordenado
        System.out.println("\nVetor ordenado de 100.000 elementos:");
        if (estaOrdenado(vetorAleatorio100000)) {
            testarDesempenho(vetorAleatorio100000);
        } else {
            System.out.println("Vetor n�o ordenado");
            testarDesempenho(vetorAleatorio100000);
        }

        // Invertendo o vetor de 100.000 elementos
        inverterVetor(vetorAleatorio100000);

        // Testando o vetor de 100.000 elementos invertido
        System.out.println("\nVetor invertido de 100.000 elementos:");
        testarDesempenho(vetorAleatorio100000);

        // Testes de desempenho para o vetor aleat�rio de 1.000.000 elementos
        System.out.println("\nVetor aleat�rio de 1.000.000 elementos:");
        testarDesempenho(vetorAleatorio1000000);

        // Testando o vetor de 1.000.000 elementos ordenado
        System.out.println("\nVetor ordenado de 1.000.000 elementos:");
        if (estaOrdenado(vetorAleatorio1000000)) {
            testarDesempenho(vetorAleatorio1000000);
        } else {
            System.out.println("Vetor n�o ordenado");
            testarDesempenho(vetorAleatorio1000000);
        }

        // Invertendo o vetor de 1.000.000 elementos
        inverterVetor(vetorAleatorio1000000);

        // Testando o vetor de 1.000.000 elementos invertido
        System.out.println("\nVetor invertido de 1.000.000 elementos:");
        testarDesempenho(vetorAleatorio1000000);
    }
}

