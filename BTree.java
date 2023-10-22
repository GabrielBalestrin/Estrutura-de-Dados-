package Arvores;

import java.util.ArrayList;
import java.util.List;

public class BTree {
	public class No {
	    boolean folha;
	    List<Integer> chaves;
	    List<No> filhos;

	    public No(boolean folha) {
	        this.folha = folha;
	        this.chaves = new ArrayList<>();
	        this.filhos = new ArrayList<>();
	    }
	}
	private No raiz;
	private int t;

	public BTree(int t) {
		this.raiz = new No(true);
		this.t = t;
	}


	public void inserirNaoRecursivo(int chave) {
	    while (true) {
	        if (raiz.chaves.size() == (2 * t - 1)) {
	            No novoNo = new No(false);
	            novoNo.filhos.add(raiz);
	            raiz = novoNo;
	            dividirFilhoIterativo(novoNo, 0);
	        }
	        if (inserirEmNoNaoCheioIterativo(raiz, chave)) {
	            break;
	        }
	    }
	}

	private boolean inserirEmNoNaoCheioIterativo(No no, int chave) {
	    int i;
	    while (true) {
	        i = no.chaves.size() - 1;
	        while (i >= 0 && chave < no.chaves.get(i)) {
	            i--;
	        }
	        i++;
	        if (no.folha) {
	            if (i < no.chaves.size() && chave == no.chaves.get(i)) {
	                return true; 
	            }
	            no.chaves.add(i, chave);
	            return true; 
	        } else {
	            if (i < no.chaves.size() && chave == no.chaves.get(i)) {
	                return true; 
	            }
	            No filho = no.filhos.get(i);
	            if (filho.chaves.size() == (2 * t - 1)) {
	                dividirFilhoIterativo(no, i);
	                if (chave > no.chaves.get(i)) {
	                    i++;
	                }
	            }
	            no = no.filhos.get(i);
	        }
	    }
	}
	
	private void dividirFilhoIterativo(No pai, int indiceFilho) {
	    No filho = pai.filhos.get(indiceFilho);
	    No novoNo = new No(filho.folha);
	    pai.chaves.add(indiceFilho, filho.chaves.get(t - 1));

	    for (int i = 0; i < t - 1; i++) {
	        novoNo.chaves.add(filho.chaves.remove(t));
	    }

	    if (!filho.folha) {
	        for (int i = 0; i < t; i++) {
	            novoNo.filhos.add(filho.filhos.remove(t));
	        }
	    }

	    pai.filhos.add(indiceFilho + 1, novoNo);
	}

	public boolean buscarIterativo(int chave) {
	    No noAtual = raiz;
	    while (noAtual != null) {
	        int i = 0;
	        while (i < noAtual.chaves.size() && chave > noAtual.chaves.get(i)) {
	            i++;
	        }
	        if (i < noAtual.chaves.size() && chave == noAtual.chaves.get(i)) {
	            return true;
	        } else if (noAtual.folha) {
	            return false;
	        } else {
	            noAtual = noAtual.filhos.get(i);
	        }
	    }
	    return false;
	}

	public void removerIte(int chave) {
	    if (raiz != null) {
	        removerIterativo(chave);
	    }
	}

	private void removerIterativo(int chave) {
	    No no = raiz;
	    boolean chaveEncontrada = false;

	    while (no != null) {
	        int indice = encontrarIndiceDaChave(no, chave);

	        if (indice < no.chaves.size() && no.chaves.get(indice) == chave) {
	            chaveEncontrada = true;
	            if (no.folha) {
	                removerDeFolha(no, indice);
	            } else {
	                removerDeNoInterno(no, indice);
	            }
	        } else {
	            if (no.folha) {
	                return;
	            }

	            boolean ultimaChave = (indice == no.chaves.size());
	            No filho = no.filhos.get(indice);

	            if (filho.chaves.size() < t) {
	                preencher(no, indice);
	            }

	            if (ultimaChave && indice > no.chaves.size()) {
	                filho = no.filhos.get(indice - 1);
	            }

	            no = filho;
	        }
	    }

	    if (chaveEncontrada && raiz.chaves.isEmpty() && !raiz.folha) {
	        raiz = raiz.filhos.get(0);
	    }
	}

    
    //NORMAL
	
	public void inserir(int chave) {
		No raizAntiga = raiz;
		if (raiz.chaves.size() == (2 * t - 1)) {
			No novoNo = new No(false);
			novoNo.filhos.add(raiz);
			dividirFilho(novoNo, 0);
			raiz = novoNo;
			inserirEmNoNaoCheio(raiz, chave);
		} else {
			inserirEmNoNaoCheio(raiz, chave);
		}
	}

	private void dividirFilho(No pai, int indiceFilho) {
	    No filho = pai.filhos.get(indiceFilho);
	    No novoNo = new No(filho.folha);
	    pai.chaves.add(indiceFilho, filho.chaves.get(t - 1));

	    int i = 0;
	    for (i = 0; i < t - 1; i++) {
	        novoNo.chaves.add(filho.chaves.get(t));
	        filho.chaves.remove(t);
	    }

	    if (!filho.folha) {
	        for (i = 0; i < t; i++) {
	            novoNo.filhos.add(filho.filhos.get(t));
	            filho.filhos.remove(t);
	        }
	    }

	    pai.filhos.add(indiceFilho + 1, novoNo);
	}

	
	private void inserirEmNoNaoCheio(No no, int chave) {
	    int i = no.chaves.size() - 1;
	    if (no.folha) {
	        while (i >= 0 && chave < no.chaves.get(i)) {
	            i--;
	        }
	      
	        if (i < 0 || chave != no.chaves.get(i)) {
	            no.chaves.add(i + 1, chave);
	        }
	    } else {
	        while (i >= 0 && chave < no.chaves.get(i)) {
	            i--;
	        }
	        i++;
	        No filho = no.filhos.get(i);
	        if (filho.chaves.size() == (2 * t - 1)) {
	            dividirFilho(no, i);
	            if (chave > no.chaves.get(i)) {
	                i++;
	            }
	        }
	        inserirEmNoNaoCheio(no.filhos.get(i), chave);
	    }
	}

	  public void mostrarOrdenado() {
	        if (raiz != null) {
	            mostrarOrdenadoRecursivo(raiz);
	        }
	    }

	  private void mostrarOrdenadoRecursivo(No no) {
		    int i;
		    for (i = 0; i < no.chaves.size(); i++) {
		        if (no.folha) {
		            System.out.print(no.chaves.get(i) + " ");
		        } else {
		            mostrarOrdenadoRecursivo(no.filhos.get(i));
		        }
		    }
		    if (!no.folha) {
		        mostrarOrdenadoRecursivo(no.filhos.get(i));
		    }
		}

	    
	    public void remover(int chave) {
	        if (raiz != null) {
	            removerNaRaiz(raiz, chave);
	            if (raiz.chaves.isEmpty() && !raiz.folha) {
	                raiz = raiz.filhos.get(0);
	            }
	        }
	    }

	    private void removerNaRaiz(No no, int chave) {
	        int indice = encontrarIndiceDaChave(no, chave);

	        if (indice < no.chaves.size() && no.chaves.get(indice) == chave) {
	            if (no.folha) {
	                removerDeFolha(no, indice);
	            } else {
	                removerDeNoInterno(no, indice);
	            }
	        } else {
	            if (no.folha) {
	                System.out.println("Chave não encontrada.");
	                return;
	            }

	            boolean ultimaChave = (indice == no.chaves.size());
	            No filho = no.filhos.get(indice);

	            if (filho.chaves.size() < t) {
	                preencher(filho, indice);
	            }

	            if (ultimaChave && indice > no.chaves.size()) {
	                filho = no.filhos.get(indice - 1);
	            }

	            removerNaRaiz(filho, chave);
	        }
	    }
	    
	    private int encontrarIndiceDaChave(No no, int chave) {
	        int indice = 0;
	        while (indice < no.chaves.size() && chave > no.chaves.get(indice)) {
	            indice++;
	        }
	        return indice;
	    }

	    private void removerDeFolha(No no, int indice) {
	        no.chaves.remove(indice);
	    }

	    private void removerDeNoInterno(No no, int indice) {
	        if (indice >= 0 && indice < no.chaves.size()) {
	            int chave = no.chaves.get(indice);

	            No predecessor = no.filhos.get(indice);
	            while (!predecessor.folha) {
	                predecessor = predecessor.filhos.get(predecessor.filhos.size() - 1);
	            }

	            if (predecessor.chaves.size() > 0) {
	                int predecessorChave = predecessor.chaves.get(predecessor.chaves.size() - 1);
	                removerNaRaiz(predecessor, predecessorChave);
	                no.chaves.set(indice, predecessorChave);
	            }
	        }
	    }


	    private void preencher(No no, int indice) {
	    	if (indice >= 0 && indice < no.filhos.size()) {
	    	    No filho = no.filhos.get(indice);
	    	    if (indice - 1 >= 0 && no.filhos.get(indice - 1).chaves.size() >= t) {
		            pegarAntecessor(no, indice);
		        } else if (indice < no.filhos.size() && no.filhos.get(indice).chaves.size() >= t) {
		            pegarSucessor(no, indice);
		        } else {
		            if (indice < no.filhos.size() - 1 && indice + 1 < no.filhos.size()) {
		                fundirFilhos(no, indice);
		            } else if (indice - 1 >= 0) {
		                fundirFilhos(no, indice - 1);
		            }
		        }
	    	}

	       
	    }


	    
	    private void pegarAntecessor(No no, int indice) {
	        if (indice - 1 >= 0 && no.filhos.size() > 0) {
	            No filho = no.filhos.get(indice);
	            if (indice - 1 < no.filhos.size()) {
	                No antecessor = no.filhos.get(indice - 1);
	                if (antecessor.chaves.size() > 0) {
	                    int chaveAntecessor = encontrarChaveMaxima(antecessor);
	                    removerNaRaiz(antecessor, chaveAntecessor);
	                    no.chaves.set(indice - 1, chaveAntecessor);
	                }
	            }
	        }
	    }



	    private void pegarSucessor(No no, int indice) {
	        No filho = no.filhos.get(indice);
	        No sucessor = no.filhos.get(indice + 1);
	        int chaveSucessor = encontrarChaveMinima(sucessor);
	        removerNaRaiz(sucessor, chaveSucessor);
	        no.chaves.set(indice, chaveSucessor);
	    }
	    
	    
	    private void fundirFilhos(No no, int indice) {
	        No filho = no.filhos.get(indice);
	        No irmao = no.filhos.get(indice + 1);
	        filho.chaves.add(no.chaves.remove(indice));
	        for (int i = 0; i < irmao.chaves.size(); i++) {
	            filho.chaves.add(irmao.chaves.get(i));
	        }
	        if (!filho.folha) {
	            for (int i = 0; i < irmao.filhos.size(); i++) {
	                filho.filhos.add(irmao.filhos.get(i));
	            }
	        }
	        no.filhos.remove(indice + 1);
	    }

	   
	    private int encontrarChaveMaxima(No no) {
	        if (no.chaves.isEmpty()) {
	            return -1; 
	        }

	        while (!no.folha) {
	            int numFilhos = no.filhos.size();
	            if (numFilhos == 0) {
	                return -1; 
	            }
	            no = no.filhos.get(numFilhos - 1); 
	        }

	        int numChaves = no.chaves.size();
	        if (numChaves == 0) {
	            return -1; 
	        }

	        return no.chaves.get(numChaves - 1);
	    }


	    private int encontrarChaveMinima(No no) {
	        if (no.chaves.size() > 0) {
	            while (!no.folha) {
	                if (no.filhos.size() > 0) {
	                    no = no.filhos.get(0);
	                } else {
	                    break;
	                }
	            }
	            return no.chaves.get(0);
	        }
	        return -1; // ou algum valor padrão apropriado
	    }
	    
	    public boolean buscar(int chave) {
	        boolean encontrado = buscarNaArvore(raiz, chave);
	        if (encontrado) {
	            System.out.println("Chave " + chave + " encontrada na árvore.");
	        } else {
	            System.out.println("Chave " + chave + " não encontrada na árvore.");
	        }
	        return encontrado;
	    }


	    private boolean buscarNaArvore(No no, int chave) {
	        if (no == null) {
	            return false; 
	        }

	        int i = 0;
	        while (i < no.chaves.size() && chave > no.chaves.get(i)) {
	            i++;
	        }

	        if (i < no.chaves.size() && chave == no.chaves.get(i)) {
	            return true; 
	        } else if (no.folha) {
	            return false;
	        } else {
	            return buscarNaArvore(no.filhos.get(i), chave); 
	        }
	    }
   
}