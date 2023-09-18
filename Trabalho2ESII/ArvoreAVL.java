package Trabalho2ESII;

import java.util.HashMap;
import java.util.Map;

public class ArvoreAVL {
	
	private class Nodo {
	    private int dado;
	    private int count; // Número de ocorrências
	    private int altd, alte;
	    private Nodo dir, esq;

	    public Nodo(int dado) {
	        this.dado = dado;
	        dir = esq = null;
	        altd = alte = 0;
	        count = 1; // Inicializa o contador com 1
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
		int fb = raiz.altd - raiz.alte;
		int fbSubArv;
		if (fb == 2) {
			fbSubArv = raiz.dir.altd - raiz.dir.alte;
			if (fbSubArv >= 0) {
				raiz = rotacaoEsquerda(raiz);
			} else {
				raiz.dir = rotacaoDireita(raiz.dir);
				raiz = rotacaoEsquerda(raiz);
			}
		} else if (fb == -2) {
			fbSubArv = raiz.esq.altd - raiz.esq.alte;
			if (fbSubArv <= 0) {
				raiz = rotacaoDireita(raiz);
			} else {
				raiz.esq = rotacaoEsquerda(raiz.esq);
				raiz = rotacaoDireita(raiz);
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

	//EXERCÍCIO 5
	public void inserirQuest5(int dado) {
	    raiz = inserirQuest5Dado(raiz, dado);
	}

	private Nodo inserirQuest5Dado(Nodo raiz, int dado) {
	    if (raiz == null) {
	        raiz = new Nodo(dado);
	        return raiz;
	    }

	    if (dado == raiz.dado) {
	        // Se a chave já existe na árvore, apenas incrementa o contador
	        raiz.count++;
	        return raiz; // Return after incrementing the count
	    } else if (dado < raiz.dado) {
	        raiz.esq = inserirQuest5Dado(raiz.esq, dado);
	        if (raiz.esq.altd > raiz.esq.alte) {
	            raiz.alte = raiz.esq.altd + 1;
	        } else {
	            raiz.alte = raiz.esq.alte + 1;
	        }
	        raiz = balanceamento(raiz);
	    } else {
	        raiz.dir = inserirQuest5Dado(raiz.dir, dado);
	        if (raiz.dir.altd > raiz.dir.alte) {
	            raiz.altd = raiz.dir.altd + 1;
	        } else {
	            raiz.altd = raiz.dir.alte + 1;
	        }
	        raiz = balanceamento(raiz);
	    }
	    return raiz;
	}


	public void mostrarEmOrdemQuestao5() {
		mostrarOrdenadoQuestao5(raiz);
	}

	public void mostrarOrdenadoQuestao5(Nodo raiz) {
	    if (raiz != null) {
	        mostrarOrdenadoQuestao5(raiz.esq);
	        System.out.print(raiz.dado + " "); // Print the node's value only once
	        mostrarOrdenadoQuestao5(raiz.dir);
	    }
	}


	public void contarOcorrencias() {
		Map<Integer, Integer> map = new HashMap<>();
		contarOcorrenciasRecursivo(raiz, map);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Número: " + entry.getKey() + ", Ocorrências: " + entry.getValue());
		}
	}

	private void contarOcorrenciasRecursivo(Nodo raiz, Map<Integer, Integer> map) {
	    if (raiz == null) {
	        return;
	    }

	    map.put(raiz.dado, raiz.count); 

	    contarOcorrenciasRecursivo(raiz.esq, map);
	    contarOcorrenciasRecursivo(raiz.dir, map);
	}
	
	//EXERCÍO 5 - REMOÇÃO
	public void removerQ5(int dado) {
		raiz = removerNodoQ5(raiz, dado);
	}

	private Nodo removerNodoQ5(Nodo raiz, int dado) {
	    if (raiz == null) {
	        return raiz;
	    }

	    if (dado < raiz.dado) {
	        raiz.esq = removerNodoQ5(raiz.esq, dado);
	    } else if (dado > raiz.dado) {
	        raiz.dir = removerNodoQ5(raiz.dir, dado);
	    } else {
	        if (raiz.count > 1) {
	            raiz.count--;
	            return raiz; 
	        }
	        if ((raiz.esq == null) || (raiz.dir == null)) {
	            Nodo temp = null;
	            if (temp == raiz.esq) {
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
	            Nodo temp = encontrarMenorNodoQ5(raiz.dir);
	            raiz.dado = temp.dado;
	            raiz.dir = removerNodoQ5(raiz.dir, temp.dado);
	        }
	    }
	    if (raiz == null) {
	        return raiz;
	    }
	    raiz.alte = calcularAlturaQ5(raiz.esq);
	    raiz.altd = calcularAlturaQ5(raiz.dir);
	    raiz = balanceamento(raiz);

	    return raiz;
	}

	private Nodo encontrarMenorNodoQ5(Nodo nodo) {
		Nodo atual = nodo;
		while (atual.esq != null) {
			atual = atual.esq;
		}
		return atual;
	}

	private int calcularAlturaQ5(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}
		return Math.max(nodo.alte, nodo.altd) + 1;
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
}
