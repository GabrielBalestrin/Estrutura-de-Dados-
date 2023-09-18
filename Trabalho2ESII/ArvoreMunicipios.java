package Trabalho2ESII;

class Municipio {
	private String nome;
	private double areaKm2;
	private int populacao;

	public Municipio(String nome, double areaKm2, int populacao) {
		this.nome = nome;
		this.areaKm2 = areaKm2;
		this.populacao = populacao;
	}

	public String getNome() {
		return nome;
	}

	public double getAreaKm2() {
		return areaKm2;
	}

	public int getPopulacao() {
		return populacao;
	}

	public double getDensidadeDemografica() {
		return populacao / areaKm2;
	}

	@Override
	public String toString() {
		return nome;
	}
}

public class ArvoreMunicipios {
	private class Nodo {
		private Municipio municipio;
		private Nodo esq, dir;

		public Nodo(Municipio municipio) {
			this.municipio = municipio;
			esq = dir = null;
		}
	}

	private Nodo raiz;

	public ArvoreMunicipios() {
		raiz = null;
	}

	public void inserir(Municipio municipio) {
		raiz = inserirNodo(raiz, municipio);
	}

	private Nodo inserirNodo(Nodo raiz, Municipio municipio) {
		if (raiz == null) {
			return new Nodo(municipio);
		}

		int comparacao = municipio.getNome().compareTo(raiz.municipio.getNome());

		if (comparacao < 0) {
			raiz.esq = inserirNodo(raiz.esq, municipio);
		} else if (comparacao > 0) {
			raiz.dir = inserirNodo(raiz.dir, municipio);
		}

		return raiz;
	}

	// Exercício 8a: Contar o número de municípios
	public int contarMunicipios() {
		return contarNodos(raiz);
	}

	private int contarNodos(Nodo raiz) {
		if (raiz == null) {
			return 0;
		}
		return 1 + contarNodos(raiz.esq) + contarNodos(raiz.dir);
	}

	// Exercício 8b: Mostrar nomes dos municípios com mais de X habitantes
	public void mostrarMunicipiosComMaisDeXHabitantes(int x) {
		mostrarMunicipiosComMaisDeXHabitantes(raiz, x);
	}

	private void mostrarMunicipiosComMaisDeXHabitantes(Nodo raiz, int x) {
		if (raiz == null) {
			return;
		}
		if (raiz.municipio.getPopulacao() > x) {
			System.out.println(raiz.municipio);
		}

		mostrarMunicipiosComMaisDeXHabitantes(raiz.esq, x);
		mostrarMunicipiosComMaisDeXHabitantes(raiz.dir, x);
	}

	// Exercício 8c: Mostrar densidade demográfica de cada cidade
	public void mostrarDensidadeDemografica() {
		mostrarDensidadeDemografica(raiz);
	}

	private void mostrarDensidadeDemografica(Nodo raiz) {
		if (raiz == null) {
			return;
		}

		double densidade = raiz.municipio.getDensidadeDemografica();
		System.out.println(raiz.municipio.getNome() + ": " + densidade);

		mostrarDensidadeDemografica(raiz.esq);
		mostrarDensidadeDemografica(raiz.dir);
	}

	// Exercício 8d: Somatório de área em km2 de todas as cidades em relação ao
	// território nacional (em porcentagem)
	public double somatorioAreaEmRelacaoAoTerritorioNacional(double territorioNacional) {
		double somatorioArea = somatorioArea(raiz);
		return (somatorioArea / territorioNacional) * 100.0;
	}

	private double somatorioArea(Nodo raiz) {
		if (raiz == null) {
			return 0.0;
		}

		double area = raiz.municipio.getAreaKm2();
		return area + somatorioArea(raiz.esq) + somatorioArea(raiz.dir);
	}

	// Exercício 8e: Nome da cidade com a maior população
	public String cidadeComMaiorPopulacao() {
		return cidadeComMaiorPopulacao(raiz);
	}

	private String cidadeComMaiorPopulacao(Nodo raiz) {
		if (raiz == null) {
			return "";
		}
		String cidadeMaiorPopulacao = raiz.municipio.getNome();
		String cidadeEsq = cidadeComMaiorPopulacao(raiz.esq);
		String cidadeDir = cidadeComMaiorPopulacao(raiz.dir);

		if (raiz.esq != null && raiz.esq.municipio.getPopulacao() > raiz.municipio.getPopulacao()) {
			cidadeMaiorPopulacao = cidadeEsq;
		}
		if (raiz.dir != null && raiz.dir.municipio.getPopulacao() > raiz.municipio.getPopulacao()) {
			cidadeMaiorPopulacao = cidadeDir;
		}
		return cidadeMaiorPopulacao;
	}

}
