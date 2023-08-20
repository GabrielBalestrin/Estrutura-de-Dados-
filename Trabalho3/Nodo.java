package Trabalho3;

public class Nodo {
	private int dado;
	private Nodo prox;
	
	
	 // constructor 
	public Nodo( int dado) {
		this.dado = dado;
	
		this.prox = null;
		
		
	}

	// getters and setters
	
	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public Nodo getProx() {
		return prox;
	}

	public void setProx(Nodo prox) {
		this.prox = prox;
	}
	
	
}

