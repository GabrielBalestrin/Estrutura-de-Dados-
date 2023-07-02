package Trabalho3;

import java.util.Random;

public class BucketSort {
    public static void bucketSort(int[] array) {
    	
    	// verifica se o vetor tem tamanho 1 para retornar ele mesmo
        if (array.length <= 1) {
            return;
        }

        int valorMinimo = array[0];
        int valorMaximo = array[0];
        int comparacoes = 0; // Contador de comparações
        int trocas = 0; // Contador de trocas

        // Encontrar o valor mínimo e máximo no array
        for (int i = 1; i < array.length; i++) {
            if (array[i] < valorMinimo) {
                valorMinimo = array[i];
            }
            if (array[i] > valorMaximo) {
                valorMaximo = array[i];
            }
        }

        // Determinar a amplitude dos valores e o número de buckets
        int amplitude = valorMaximo - valorMinimo + 1;
        int numBuckets = Math.max(1, array.length);

        // Inicializar o array de buckets
        ListaEncadeada[] buckets = new ListaEncadeada[numBuckets];

        // Distribuição dos valores nos buckets
        for (int i = 0; i < array.length; i++) {
            int indiceBucket = Math.abs((array[i] - valorMinimo) * (numBuckets - 1) / amplitude) % numBuckets;
            if (indiceBucket < 0 || indiceBucket >= numBuckets) {
                throw new ArrayIndexOutOfBoundsException("Índice de bucket inválido: " + indiceBucket);
            }

            if (buckets[indiceBucket] == null) {
                buckets[indiceBucket] = new ListaEncadeada();
            }

            int[] resultado = buckets[indiceBucket].inserirOrdenado(array[i]);
            comparacoes += resultado[0]; // Incrementa a contagem de comparações
            trocas += resultado[1]; // Incrementa a contagem de trocas
        }

        // Combina os elementos dos buckets em uma única lista ordenada
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            if (buckets[i] != null) {
                Nodo aux = buckets[i].getInicio();
                while (aux != null) {
                    array[index++] = aux.getDado();
                    aux = aux.getProx();
                }
            }
        }

        System.out.println("Total de comparações: " + comparacoes);
        System.out.println("Total de trocas: " + trocas);
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt();
        }
        return vetor;
    }

    public int[] inserirOrdenado(int value) {
        int comparacoes = 0; // Contador de comparações
        int trocas = 0; // Contador de trocas
        // Insere o elemento na posição correta dentro do bucket
        // Atualiza as variáveis de comparações e trocas adequadamente
        return new int[] { comparacoes, trocas };
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
        bucketSort(array);
        long endTime = System.nanoTime();

        double tempoTotal = (endTime - startTime) / 1e6;
        System.out.println("Tempo de execução: " + tempoTotal + " ms");
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
        System.out.println("Bucket Sort");

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
