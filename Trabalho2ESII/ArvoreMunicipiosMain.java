package Trabalho2ESII;

public class ArvoreMunicipiosMain {
	public static void main(String[] args) {
		ArvoreMunicipios arvore = new ArvoreMunicipios();

		arvore.inserir(new Municipio("Rio do Sul ", 261, 72587));
		arvore.inserir(new Municipio("Joaçaba", 243.094, 30136));
		arvore.inserir(new Municipio("Sao Paulo", 1521.11, 12300000));

		
		// EXERCÍCIO 8A
		int numeroMunicipios = arvore.contarMunicipios();
		System.out.println("Número de municípios: " + numeroMunicipios);

		// EXERCÍCIO8B
		int habitantesX = 35000;
		System.out.println("Municípios com mais de " + habitantesX + " habitantes:");
		arvore.mostrarMunicipiosComMaisDeXHabitantes(habitantesX);

		// EXERCÍCIO 8C
		System.out.println("Densidade demográfica de cada cidade:");
		arvore.mostrarDensidadeDemografica();

		// EXERCÍCIO 8D
		double territorioNacional = 8515759; // BRASIL
		double porcentagemArea = arvore.somatorioAreaEmRelacaoAoTerritorioNacional(territorioNacional);
		System.out.println("Porcentagem de área em relação ao território nacional: " + porcentagemArea + "%");

		// EXERCÍCIO 8E
		String cidadeMaiorPopulacao = arvore.cidadeComMaiorPopulacao();
		System.out.println("Cidade com a maior população: " + cidadeMaiorPopulacao);
	}
}
