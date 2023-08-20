package Arvores;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
	private class Nodo {
		private int chave;
		private Nodo dir, esq;

		public Nodo(int item) {
			this.chave = item;
			dir = esq = null;
		}
	}

	Nodo raiz = null;

	public void inserir(int chave) {
		raiz = inserirDado(raiz, chave);

	}

	private Nodo inserirDado(Nodo raiz, int chave) {
		if (raiz == null) {
			raiz = new Nodo(chave);
			return raiz;
		}
		if (chave < raiz.chave)
			raiz.esq = inserirDado(raiz.esq, chave);
		else if (chave > raiz.chave)
			raiz.dir = inserirDado(raiz.dir, chave);

		return raiz;
	}

	public void mostrarEmOrdem() {
	    System.out.print("Ordenado: ");
	    mostrarCrescente(raiz);
	    System.out.println(); 
	}

	private void mostrarCrescente(Nodo raiz) {
	    if (raiz != null) {
	        mostrarCrescente(raiz.esq);
	        System.out.print(raiz.chave + " "); 
	        mostrarCrescente(raiz.dir);
	    }
	}
	public void remover(int chave) {
		raiz = removerItem(raiz, chave);
	}

	public void mostrarEmOrdemDecrescente() {
		System.out.print("Decrescente: ");
	    mostrarDecrescente(raiz);
	    System.out.println();
	}

	private void mostrarDecrescente(Nodo raiz) {
	    if (raiz != null) {
	        mostrarDecrescente(raiz.dir);
	        System.out.print(raiz.chave + " "); 
	        mostrarDecrescente(raiz.esq);
	    }
	}

	public void mostrarPorNivel() {
		if (raiz == null) {
			System.out.println("Árvore vazia!");
			return;
		}
		Queue<Nodo> fila = new LinkedList<>();
		fila.add(raiz);

		while (!fila.isEmpty()) {
			int tamanhoNivel = fila.size();
			for (int i = 0; i < tamanhoNivel; i++) {
				Nodo nodoAtual = fila.poll();
				if (nodoAtual != null) {
					System.out.print(nodoAtual.chave + " ");
					fila.add(nodoAtual.esq);
					fila.add(nodoAtual.dir);
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}

	}

	private Nodo removerItem(Nodo raiz, int chave) {
		if (raiz == null) {
			// Node don't found, continue
			return null;
		}
		if (chave < raiz.chave) {
			// key will remove, at left
			raiz.esq = removerItem(raiz.esq, chave);
		} else if (chave > raiz.chave) {
			raiz.dir = removerItem(raiz.dir, chave);
		} else {
			// Find the node will be removed

			if (raiz.esq == null) {
				// Case node doesn't have nobody at left
				return raiz.dir;
			} else if (raiz.dir == null) {
				// Case node doesn't have nobody at right
				return raiz.esq;
			} else {
				// Case node has both leafs
				// Nó sucessor será o menor da subarvore da direita
				Nodo sucessor = encontraSucessor(raiz.dir);
				// changed the value node will be removed for the next
				raiz.chave = sucessor.chave;
				raiz.dir = removerItem(raiz.dir, sucessor.chave);
			}
		}
		return raiz;
	}

	private Nodo encontraSucessor(Nodo nodo) {
		while (nodo.esq != null) {
			nodo = nodo.esq;

		}
		return nodo;
	}

	// Exercicio letra A
	public void mostrarMaiorNumero() {
		if (raiz == null) {
			System.out.println("Árvore vazia!");
			return;
		}

		Nodo nodoAtual = raiz;
		while (nodoAtual.dir != null) {
			nodoAtual = nodoAtual.dir;
		}

		System.out.println("Maior número na árvore: " + nodoAtual.chave);
	}

	// Exercicio letra B
	public void mostrarMenorNumero() {
		if (raiz == null) {
			System.out.println("Árvore vazia!");
			return;
		}

		Nodo nodoAtual = raiz;
		while (nodoAtual.esq != null) {
			nodoAtual = nodoAtual.esq;
		}

		System.out.println("Menor número na árvore: " + nodoAtual.chave);
	}

	// Exercicio letra C
	public void mostrarNo(int nivelDesejado) {
		mostrarNoNivel(raiz, nivelDesejado, 1);
	}

	private void mostrarNoNivel(Nodo raiz, int nivelDesejado, int nivelAtual) {
		if (raiz == null) {
			return;
		}

		if (nivelAtual == nivelDesejado) {
			System.out.println("Nó no nível " + nivelDesejado + ": " + raiz.chave);
		} else {
			mostrarNoNivel(raiz.esq, nivelDesejado, nivelAtual + 1);
			mostrarNoNivel(raiz.dir, nivelDesejado, nivelAtual + 1);
		}
	}

	// Exercicio letra D
	public void mostrarAncestrais(int chave) {
		System.out.print("Ancestrais de " + chave + ": ");
		mostrarAncestraisRecursivo(raiz, chave);
	}

	private boolean mostrarAncestraisRecursivo(Nodo raiz, int chave) {
		if (raiz == null) {
			return false;
		}
		if (raiz.chave == chave) {
			return true;
		}
		if (mostrarAncestraisRecursivo(raiz.esq, chave) || mostrarAncestraisRecursivo(raiz.dir, chave)) {
			System.out.print(raiz.chave + " ");
			return true;
		}
		return false;
	}

	// Exercicio letra E
	public void mostrarDescendentes(int chave) {
		System.out.print("\nDescendentes de " + chave + ": ");
		mostrarDescendentesRecursivo(raiz, chave);
	}

	private boolean mostrarDescendentesRecursivo(Nodo raiz, int chave) {
		if (raiz == null) {
			return false;
		}
		if (raiz.chave == chave) {
			if (raiz.esq != null) {
				mostrarDescendentesRecursivo(raiz.esq, chave);
			}
			if (raiz.dir != null) {
				mostrarDescendentesRecursivo(raiz.dir, chave);
			}
			System.out.print(raiz.chave + " ");
			return true;
		}
		if (mostrarDescendentesRecursivo(raiz.esq, chave) || mostrarDescendentesRecursivo(raiz.dir, chave)) {
			return true;
		}
		return false;
	}

	// Exercicio letra F
	public void mostrarSubArvoreDireita(int chave) {
	    Nodo nodo = buscarNodo(raiz, chave);

	    if (nodo == null) {
	        System.out.println("Nó não encontrado.");
	        return;
	    }
	    System.out.print("\nSubárvore à direita do nó " + chave + ": ");
	    if (nodo.dir != null) {
	        mostrarSubArvore(nodo.dir);
	    } else {
	        System.out.print("Nenhum nó na subárvore à direita.");
	    }
	}

	private Nodo buscarNodo(Nodo raiz, int chave) {
	    if (raiz == null || raiz.chave == chave) {
	        return raiz;
	    }
	    if (chave < raiz.chave) {
	        return buscarNodo(raiz.esq, chave);
	    } else {
	        return buscarNodo(raiz.dir, chave);
	    }
	}

	private void mostrarSubArvore(Nodo raiz) {
	    if (raiz != null) {
	        System.out.print(raiz.chave + " ");
	        mostrarSubArvore(raiz.esq);
	        mostrarSubArvore(raiz.dir);
	    }
	}

	
	// Exercicio letra G
	public void mostrarSubArvoreEsquerda(int chave) {
	    Nodo nodo = buscarNodo(raiz, chave);
	    if (nodo == null) {
	        System.out.println("Nó não encontrado.");
	        return;
	    }
	    System.out.print("\nSubárvore à esquerda do nó " + chave + ": ");
	    if (nodo.esq != null) {
	        mostrarSubArvore(nodo.esq);
	    } else {
	        System.out.println(" Nenhum nó na subárvore à esquerda.");
	    }
	}
	// Exercicio letra H
	public void transformarEmLista() {

		Nodo novaRaiz = transformarEmListaRecursivo(raiz);
		raiz = novaRaiz;
	}

	private Nodo transformarEmListaRecursivo(Nodo raiz) {
		if (raiz == null) {
			return null;
		}
		Nodo esq = transformarEmListaRecursivo(raiz.esq);
		Nodo dir = transformarEmListaRecursivo(raiz.dir);
		raiz.esq = esq;
		raiz.dir = dir;
		Nodo listaEsquerda = esq;
		Nodo listaDireita = dir;
		if (listaEsquerda == null) {
			listaEsquerda = raiz;
		} else {
			Nodo ultimoEsquerda = listaEsquerda;
			while (ultimoEsquerda.dir != null) {
				ultimoEsquerda = ultimoEsquerda.dir;
			}
			ultimoEsquerda.dir = raiz;
			raiz.esq = ultimoEsquerda;
		}
		if (listaDireita == null) {
			listaDireita = raiz;
		} else {
			listaDireita.esq = raiz;
			raiz.dir = listaDireita;
		}
		return listaEsquerda;
	}

	public void imprimirLista() {
		Nodo atual = raiz;
		System.out.print("Arvore em tranformada lista: ");
		while (atual != null) {
			System.out.print(atual.chave + " ");
			atual = atual.dir;
		}
		System.out.println();
	}

	// Exercicio letra I
	public void mostrarNumerosPares() {
		System.out.print("Números pares na árvore: ");
		mostrarNumerosParesRecursivo(raiz);
		System.out.println();
	}

	private void mostrarNumerosParesRecursivo(Nodo raiz) {
		if (raiz != null) {
			mostrarNumerosParesRecursivo(raiz.esq);
			if (raiz.chave % 2 == 0) {
				System.out.print(raiz.chave + " ");
			}
			mostrarNumerosParesRecursivo(raiz.dir);
		}
	}

	// Exercicio letra J
	public void mostrarNivelDoNodo(int chave) {
		String mensagem = mostrarNivelRecursivo(raiz, chave, 1);

		System.out.println(mensagem);
	}

	private String mostrarNivelRecursivo(Nodo raiz, int chave, int nivelAtual) {
		if (raiz == null) {
			return "\nNó com chave " + chave + " não encontrado.";
		}
		if (raiz.chave == chave) {
			return "\nNível do nó com chave " + chave + ": " + nivelAtual;
		}
		String mensagemEsquerda = mostrarNivelRecursivo(raiz.esq, chave, nivelAtual + 1);
		if (!mensagemEsquerda.contains("não encontrado")) {
			return mensagemEsquerda;
		}
		String mensagemDireita = mostrarNivelRecursivo(raiz.dir, chave, nivelAtual + 1);
		return mensagemDireita;
	}

	// Exercicio letra K
	public int calcularAltura() {
		return calcularAlturaRecursivo(raiz, true);
	}

	private int calcularAlturaRecursivo(Nodo raiz, boolean imprimir) {
		if (raiz == null) {
			return 0;
		}

		int alturaEsquerda = calcularAlturaRecursivo(raiz.esq, false);
		int alturaDireita = calcularAlturaRecursivo(raiz.dir, false);
		int altura = Math.max(alturaEsquerda, alturaDireita) + 1;
		if (imprimir) {
			System.out.println("Altura da árvore: " + altura);
		}
		return altura;
	}

	// Exercicio letra L
	public int calcularTamanho() {
		return calcularTamanhoRecursivo(raiz, true);
	}

	private int calcularTamanhoRecursivo(Nodo raiz, boolean imprimir) {
		if (raiz == null) {
			return 0;
		}

		int tamanhoEsquerda = calcularTamanhoRecursivo(raiz.esq, false);
		int tamanhoDireita = calcularTamanhoRecursivo(raiz.dir, false);
		int tamanho = tamanhoEsquerda + tamanhoDireita + 1;
		if (imprimir) {
			System.out.println("Tamanho da árvore: " + tamanho);
		}
		return tamanho;
	}

	// exercicio Letra M
	public void inserirNaoRecursivo(int chave) {
		Nodo novoNodo = new Nodo(chave);
		if (raiz == null) {
			raiz = novoNodo;
			return;
		}
		Nodo nodoAtual = raiz;
		Nodo pai;
		while (true) {
			pai = nodoAtual;
			if (chave < nodoAtual.chave) {
				nodoAtual = nodoAtual.esq;
				if (nodoAtual == null) {
					pai.esq = novoNodo;
					return;
				}
			} else {
				nodoAtual = nodoAtual.dir;
				if (nodoAtual == null) {
					pai.dir = novoNodo;
					return;
				}
			}
		}
	}
}
