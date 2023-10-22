package Arvores;

import java.util.Stack;

public class ArvoreAVL {
	private class Nodo {
		private int dado, altd, alte;
		private Nodo dir, esq;

		public Nodo(int dado) {
			this.dado = dado;
			dir = esq = null;
			altd = alte = 0;
		}
	}

	Nodo raiz;

	public ArvoreAVL() {
		raiz = null;
	}

	public void inserir(int dado) {
		raiz = inserirDado(raiz, dado);
	}

	private Nodo inserirDado(Nodo raiz, int dado) {
		if (raiz == null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if (dado < raiz.dado) {
			raiz.esq = inserirDado(raiz.esq, dado);
			if (raiz.esq.altd > raiz.esq.alte) {
				raiz.alte = raiz.esq.altd + 1;
			} else {
				raiz.alte = raiz.esq.alte + 1;
			}
			raiz = balanceamento(raiz);
		} else if (dado > raiz.dado) {
			raiz.dir = inserirDado(raiz.dir, dado);
			if (raiz.dir.altd > raiz.dir.alte) {
				raiz.altd = raiz.dir.altd + 1;
			} else {
				raiz.altd = raiz.dir.alte + 1;
			}
			raiz = balanceamento(raiz);
		}
		return raiz;
	}

	private Nodo balanceamento(Nodo raiz) {
	    if (raiz == null) 
	        return null;
	    int fb = raiz.altd - raiz.alte;
	    int fbSubArv;
	    if (fb == 2) {
	        if (raiz.dir != null) {
	            fbSubArv = raiz.dir.altd - raiz.dir.alte;
	            if (fbSubArv >= 0) {
	                raiz = rotacaoEsquerda(raiz);
	            } else if (raiz.dir.esq != null) {
	                raiz.dir = rotacaoDireita(raiz.dir);
	                raiz = rotacaoEsquerda(raiz);
	            }
	        }
	    } else if (fb == -2) {
	        if (raiz.esq != null) {
	            fbSubArv = raiz.esq.altd - raiz.esq.alte;
	            if (fbSubArv <= 0) {
	                raiz = rotacaoDireita(raiz);
	            } else if (raiz.esq.dir != null) {
	                raiz.esq = rotacaoEsquerda(raiz.esq);
	                raiz = rotacaoDireita(raiz);
	            }
	        }
	    }
	    return raiz;
	}


	private Nodo rotacaoEsquerda(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.dir;
		aux2 = aux1.esq;
		raiz.dir = aux2;
		aux1.esq = raiz;
		if (raiz.dir == null) {
			raiz.altd = 0;
		} else if (raiz.dir.alte > raiz.dir.altd) {
			raiz.altd = raiz.dir.alte + 1;
		} else {
			raiz.altd = raiz.dir.altd + 1;
		}
		if (aux1.esq.alte > aux1.esq.altd) {
			aux1.alte = aux1.esq.alte + 1;
		} else {
			aux1.alte = aux1.esq.altd + 1;
		}
		return aux1;
	}

	private Nodo rotacaoDireita(Nodo raiz) {
		Nodo aux1, aux2;
		aux1 = raiz.esq;
		aux2 = aux1.dir;
		raiz.esq = aux2;
		aux1.dir = raiz;
		if (raiz.esq == null) {
			raiz.alte = 0;
		} else if (raiz.esq.alte > raiz.esq.altd) {
			raiz.alte = raiz.esq.alte + 1;
		} else {
			raiz.alte = raiz.esq.altd + 1;
		}
		if (aux1.dir.alte > aux1.dir.altd) {
			aux1.altd = aux1.dir.alte + 1;
		} else {
			aux1.altd = aux1.dir.altd + 1;
		}
		return aux1;
	}

	public void mostrarEmOrdem() {
		mostrarOrdenado(raiz);
	}

	public void mostrarOrdenado(Nodo raiz) {
		if (raiz != null) {
			mostrarOrdenado(raiz.esq);
			System.out.print(raiz.dado + " ");
			mostrarOrdenado(raiz.dir);
		}
	}

	// Exercício 2
	public void remover(int dado) {
		raiz = removerNodo(raiz, dado);
	}

	private Nodo removerNodo(Nodo raiz, int dado) {
		if (raiz == null) {
			return raiz;
		}

		if (dado < raiz.dado) {
			raiz.esq = removerNodo(raiz.esq, dado);
		} else if (dado > raiz.dado) {
			raiz.dir = removerNodo(raiz.dir, dado);
		} else {
			if (raiz.esq == null || raiz.dir == null) {
				Nodo temp = null;
				if (raiz.esq == null) {
					temp = raiz.dir;
				} else {
					temp = raiz.esq;
				}

				if (temp == null) {
					temp = raiz;
					raiz = null;
				} else {
					raiz = temp;
				}
			} else {
				Nodo temp = encontrarMenorNodo(raiz.dir);
				raiz.dado = temp.dado;
				raiz.dir = removerNodo(raiz.dir, temp.dado);
			}

			if (raiz != null) {
				raiz.alte = calcularAltura(raiz.esq);
				raiz.altd = calcularAltura(raiz.dir);
				raiz = balanceamento(raiz);
			}
		}

		return raiz;
	}

	private Nodo encontrarMenorNodo(Nodo nodo) {
		Nodo atual = nodo;
		while (atual.esq != null) {
			atual = atual.esq;
		}
		return atual;
	}

	private int calcularAltura(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}
		return Math.max(nodo.alte, nodo.altd) + 1;
	}

	// EXERCÍCIO 3 - FEITO DEPOIS DA CONSTRUÇÃO E ANTES DO BALANCEAMENTO
	public boolean verificaAVL() {
		boolean isAVL = verificaAVL(raiz);
		System.out.println("\nÉ uma árvore AVL: " + isAVL);
		return isAVL;
	}

	private boolean verificaAVL(Nodo raiz) {
		if (raiz == null) {
			return true;
		}
		int alturaEsquerda = altura(raiz.esq);
		int alturaDireita = altura(raiz.dir);
		if (Math.abs(alturaEsquerda - alturaDireita) > 1) {
			return false;
		}
		return verificaAVL(raiz.esq) && verificaAVL(raiz.dir);
	}

	private int altura(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}
		return Math.max(altura(nodo.esq), altura(nodo.dir)) + 1;
	}

	// EXERCÍCIO 4
	public int contarNosPrimos() {
		int quantidade = contarNosPrimos(raiz);
		System.out.println("Total de números primos é de " + quantidade);
		return quantidade;
	}

	private int contarNosPrimos(Nodo raiz) {
		if (raiz == null) {
			return 0;
		}
		int quantidade = 0;
		if (isPrimo(raiz.dado)) {
			quantidade++;
		}
		quantidade += contarNosPrimos(raiz.esq);
		quantidade += contarNosPrimos(raiz.dir);
		return quantidade;
	}

	private boolean isPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(numero); i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;
	}

	// EXERCÍCIO 6
	public void mostrarNodosNoNivel(int nivel) {
		System.out.print("Esses são nodos do nivel " + nivel + ": ");
		mostrarNodosNoNivel(raiz, nivel, 1);
	}

	private void mostrarNodosNoNivel(Nodo raiz, int nivelAlvo, int nivelAtual) {
		if (raiz == null) {
			return;
		}
		if (nivelAtual == nivelAlvo) {
			System.out.print(raiz.dado + " ");
		} else if (nivelAtual < nivelAlvo) {
			mostrarNodosNoNivel(raiz.esq, nivelAlvo, nivelAtual + 1);
			mostrarNodosNoNivel(raiz.dir, nivelAlvo, nivelAtual + 1);
		}
	}

	// EXERCÍCIO 7
	public int somaNosNiveisImpares() {
		int soma = somarNosNiveisImpares(raiz, 1);
		System.out.println("\nEssa é a soma total: " + soma);
		return soma;
	}

	private int somarNosNiveisImpares(Nodo raiz, int nivelAtual) {
		if (raiz == null) {
			return 0;
		}
		int soma = 0;
		if (nivelAtual % 2 == 1) {
			soma += raiz.dado;
		}
		soma += somarNosNiveisImpares(raiz.esq, nivelAtual + 1);
		soma += somarNosNiveisImpares(raiz.dir, nivelAtual + 1);
		return soma;
	}
	
	public boolean buscar(int valor) {
	    boolean encontrado = buscarValor(raiz, valor);
	    if (encontrado) {
	        System.out.println("Valor " + valor + " encontrado na árvore.");
	    } else {
	        System.out.println("Valor " + valor + " não encontrado na árvore.");
	    }
	    return encontrado;
	}

	private boolean buscarValor(Nodo raiz, int valor) {
	    if (raiz == null) {
	        return false; 
	    }

	    if (valor == raiz.dado) {
	        return true; 
	    } else if (valor < raiz.dado) {
	        return buscarValor(raiz.esq, valor); 
	    } else {
	        return buscarValor(raiz.dir, valor); 
	    }
	}

	
	public void insertIterative(int key) {
	    if (raiz == null) {
	        raiz = new Nodo(key);
	        return;
	    }
	    
	    Stack<Nodo> path = new Stack<>();
	    Nodo current = raiz;
	    
	    while (current != null) {
	        path.push(current);
	        if (current.dado > key) {
	            if (current.esq == null) {
	                current.esq = new Nodo(key);
	                break;
	            } else {
	                current = current.esq;
	            }
	        } else {
	            if (current.dir == null) {
	                current.dir = new Nodo(key);
	                break;
	            } else {
	                current = current.dir;
	            }
	        }
	    }
	    
	    while (!path.isEmpty()) {
	        current = path.pop();
	        current = balanceamento(current);
	        
	        if (!path.isEmpty()) {
	            Nodo parent = path.peek();
	            if (parent.esq == current) {
	                parent.esq = current;
	            } else {
	                parent.dir = current;
	            }
	        } else {
	            raiz = current;
	        }
	    }
	}

	public Nodo buscarIterativo(int valor) {
	    Nodo atual = raiz;

	    while (atual != null) {
	        if (valor < atual.dado) {
	            atual = atual.esq;
	        } else if (valor > atual.dado) {
	            atual = atual.dir;
	        } else {
	            return atual; 
	        }
	    }

	    return null; 
	}

	
	
}

