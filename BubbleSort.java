package Trabalho3;
import java.util.Random;

public class BubbleSort {
	// Método para realizar a ordenação por Bubble Sort
	public static void bubbleSort(int array[]) {
	    int n = array.length; 
	    long trocas = 0; 
	    long comparacoes = 0;

	    for (int i = 0; i < n - 1; i++) {
	        // O loop externo percorre o vetor do início até o penúltimo elemento
	        // A cada iteração, o maior elemento restante "sobe" para a posição correta no final do vetor

	        for (int j = 0; j < n - i - 1; j++) {
	            // O loop interno percorre o vetor da primeira posição até a posição não ordenada atual

	            comparacoes++;

	            if (array[j] > array[j + 1]) {
	                // Se o elemento atual for maior que o próximo elemento,
	                // realiza a troca dos elementos para colocar o maior elemento à direita

	                trocas++;
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }

	    System.out.println("Total de comparações: " + comparacoes);
	    System.out.println("Total de trocas: " + trocas);
	}

    // Método para gerar um vetor aleatório de tamanho especificado, passando por parametro o tamanho
    public static int[] gerarVetorAleatorio(int tamanho) {
    	
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt();
        }
        return vetor;
    }

    // Método para inverter a ordem dos elementos em um vetor
    public static void inverterVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - i - 1];
            vetor[n - i - 1] = temp;
        }
    }

    // Método para testar o desempenho do algoritmo de ordenação
    // Chama o método de ordenação e faz um cronometro para o tempo total do teste
    public static void testarDesempenho(int[] array) {
        long startTime = System.nanoTime();
        bubbleSort(array);
        long endTime = System.nanoTime();

        double totalTime = (endTime - startTime) / 1e6;
        System.out.println("Tempo de execução: " + totalTime + " ms");
    }

    // Método para verificar se um vetor está ordenado
    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Bubble Sort");

        // Gerando vetores aleatórios de tamanho 100.000 e 1.000.000
        int[] vetorAleatorio100000 = gerarVetorAleatorio(100000);
        int[] vetorAleatorio1000000 = gerarVetorAleatorio(1000000);

        // Testes de desempenho para o vetor aleatório de 100.000 elementos
        System.out.println("Vetor aleatório de 100.000 elementos:");
        testarDesempenho(vetorAleatorio100000);

        // Testando o vetor de 100.000 elementos ordenado
        // verifica se está ordenado, se não ele ordena no else
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

