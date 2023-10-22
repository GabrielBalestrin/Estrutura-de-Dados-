package Arvores;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

public class ArvoreBMain {
    public static void main(String[] args) {

        BTree bTreeOrdenados3 = new BTree(3);
        BTree bTreeOrdenados4 = new BTree(4);
        BTree BTreeAleatorio = new BTree(1);
        
       
        long startTime, endTime;
        long tempoInserir100mil = 0, tempoBuscar100mil = 0, tempoRemover100mil = 0;
        long tempoInserir1milhao = 0, tempoBuscar1milhao = 0, tempoRemover1milhao = 0;
      

        // inserir 100.000 elementos - ORDENADO
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
        	System.out.println("Iserir "+i);
            bTreeOrdenados3.inserir(i);
        }
        endTime = System.currentTimeMillis();
        tempoInserir100mil = endTime - startTime;


        // Busca por 100.001 na árvore
        startTime = System.currentTimeMillis();
        bTreeOrdenados3.buscar(100001);
        endTime = System.currentTimeMillis();
       long tempoBuscar100001 = endTime - startTime;

        endTime = System.currentTimeMillis();
        tempoBuscar100mil = endTime - startTime;

        // remover 100.000 elementos - ORDENADO
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            System.out.println("remover "+i);
        	bTreeOrdenados3.remover(i);
            
        }
        
        endTime = System.currentTimeMillis();
        tempoRemover100mil = endTime - startTime;

    
        // inserir 1.000.000 elementos - ORDENADO 
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
        	System.out.println("inserir "+ i);
            bTreeOrdenados3.inserir(i);
        }
        endTime = System.currentTimeMillis();
        tempoInserir1milhao = endTime - startTime;

        // Busca por 1.000.001 na árvore
        startTime = System.currentTimeMillis();
        bTreeOrdenados3.buscar(1000001);
        endTime = System.currentTimeMillis();
        long tempoBuscar1000001 = endTime - startTime;


        // remover 1.000.000 elementos - ORDENADO
        startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
        	System.out.println("remover "+i);
            bTreeOrdenados3.remover(i);
        }
        endTime = System.currentTimeMillis();
        tempoRemover1milhao = endTime - startTime;
      

        

     //inserir 100.000 elementos - Aleatório
        List<Integer> elementos100k = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            elementos100k.add(i);
        }
        Collections.shuffle(elementos100k); // Embaralha os elementos
        startTime = System.currentTimeMillis();
        for (int num : elementos100k) {
            BTreeAleatorio.inserir(num);
        }
        endTime = System.currentTimeMillis();
        tempoInserir100mil = endTime - startTime;

        // buscar 100.000 elementos - Aleatório
        Collections.shuffle(elementos100k); // Embaralha os elementos novamente
        startTime = System.currentTimeMillis();
        for (int num : elementos100k) {
            BTreeAleatorio.buscar(num);
        }
        endTime = System.currentTimeMillis();
        tempoBuscar100mil = endTime - startTime;

        // remover 100.000 elementos - Aleatório
        Collections.shuffle(elementos100k); // Embaralha os elementos novamente
        startTime = System.currentTimeMillis();
        for (int num : elementos100k) {
            BTreeAleatorio.remover(num);
        }
        endTime = System.currentTimeMillis();
        tempoRemover100mil = endTime - startTime;
   
        
       // inserir 1.000.000 elementos - Aleatório
        List<Integer> elementos1M = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            elementos1M.add(i);
        }
        Collections.shuffle(elementos1M); // Embaralha os elementos
        startTime = System.currentTimeMillis();
        for (int num : elementos1M) {
            BTreeAleatorio.inserir(num);
        }
        endTime = System.currentTimeMillis();
        tempoInserir1milhao = endTime - startTime;

        // buscar 1.000.001 elemento - Aleatório
        Collections.shuffle(elementos1M); // Embaralha os elementos novamente
        startTime = System.currentTimeMillis();
        for (int num : elementos1M) {
        }
        BTreeAleatorio.buscar(1000001);
        endTime = System.currentTimeMillis();
        tempoBuscar1milhao = endTime - startTime;

        // remover 1.000.000 elementos - Aleatório
        Collections.shuffle(elementos1M); // Embaralha os elementos novamente
        startTime = System.currentTimeMillis();
        for (int num : elementos1M) {
           BTreeAleatorio.remover(num);
        }
        endTime = System.currentTimeMillis();
        tempoRemover1milhao = endTime - startTime;
   
        System.out.println("Tempo para inserir 100.000 elementos ORDENADO (GRAU 3) " + tempoInserir100mil + "ms");
        System.out.println("Tempo para buscar o elemento 100.001 ORDENADO (GRAU 3) " + tempoBuscar100001 + "ms");
        System.out.println("Tempo para remover 100.000 elementos ORDENADO (GRAU 3) " + tempoRemover100mil + "ms");
       System.out.println("Tempo para inserir 1.000.000 elementos ORDENADO (GRAU 3) " + tempoInserir1milhao + "ms");
       System.out.println("Tempo para buscar o elemento 1.000.001 ORDENADO (GRAU 3) " + tempoBuscar1000001 + "ms");
        System.out.println("Tempo para remover 1.000.000 elementos ORDENADO (GRAU 3) " + tempoRemover1milhao + "ms");
  
       
        System.out.println("Tempo para inserir 100.000 elementos ALEATÓRIO (GRAU 1) " + tempoInserir100mil + "ms");
       System.out.println("Tempo para buscar 100.000 elementos ALEATÓRIO (GRAU 1) " + tempoBuscar100mil + "ms");
        System.out.println("Tempo para remover 100.000 elementos ALEATÓRIO (GRAU 1) " + tempoRemover100mil + "ms");
       System.out.println("Tempo para inserir 1.000.000 elementos ALEATÓRIO (GRAU 1) " + tempoInserir1milhao + "ms");
        System.out.println("Tempo para buscar 1.000.000 elementos ALEATÓRIO (GRAU 1) " + tempoBuscar1milhao + "ms");
       System.out.println("Tempo para remover 1.000.000 elementos ALEATÓRIO (GRAU 1) " + tempoRemover1milhao + "ms");
        
    }
}

