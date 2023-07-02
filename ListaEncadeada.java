package Trabalho3;

public class ListaEncadeada {
	private Nodo inicio;
	private Nodo fim;
	
	// Construtor da lista encadeada
	public ListaEncadeada() {
		inicio = null;
		fim = null;
	}
	
	// Método para inserir um valor ordenado na lista encadeada
	public int[] inserirOrdenado(int valor) {
	    int comparacoes = 0;
	    int trocas = 0;

	    Nodo novoNodo = new Nodo(valor);
	    if (inicio == null) { // Se a lista está vazia
	        inicio = novoNodo;
	        fim = novoNodo;
	        trocas++;
	    } else {
	        Nodo atual = inicio;
	        Nodo anterior = null;
	        while (atual != null && atual.getDado() < valor) { // Percorre a lista procurando a posição correta
	            comparacoes++;
	            anterior = atual;
	            atual = atual.getProx();
	        }

	        if (anterior == null) { // Insere o novo nodo no início da lista
	            novoNodo.setProx(inicio);
	            inicio = novoNodo;
	            trocas++;
	        } else { // Insere o novo nodo no meio ou final da lista
	            novoNodo.setProx(anterior.getProx());
	            anterior.setProx(novoNodo);
	            if (atual == null) { // Se o novo nodo foi inserido no final da lista
	                fim = novoNodo;
	            }
	            trocas++;
	        }
	    }

	    return new int[] {comparacoes, trocas};
	}
	
	// Verifica se a lista está vazia
	public boolean estaVazia() {
		return inicio == null;
	}
	
	// Retorna o nodo inicial da lista
	public Nodo getInicio() {
		return inicio;
	}
	
	// Retorna o nodo final da lista
	public Nodo getFim() {
		return fim;
	}
}
