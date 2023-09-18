package Trabalho2ESII;

public class ArvoreMunicipiosMain {
	public static void main(String[] args) {
		ArvoreMunicipios arvore = new ArvoreMunicipios();

		arvore.inserir(new Municipio("Rio do Sul ", 261, 72587));
		arvore.inserir(new Municipio("Joa�aba", 243.094, 30136));
		arvore.inserir(new Municipio("Sao Paulo", 1521.11, 12300000));

		
		// EXERC�CIO 8A
		int numeroMunicipios = arvore.contarMunicipios();
		System.out.println("N�mero de munic�pios: " + numeroMunicipios);

		// EXERC�CIO8B
		int habitantesX = 35000;
		System.out.println("Munic�pios com mais de " + habitantesX + " habitantes:");
		arvore.mostrarMunicipiosComMaisDeXHabitantes(habitantesX);

		// EXERC�CIO 8C
		System.out.println("Densidade demogr�fica de cada cidade:");
		arvore.mostrarDensidadeDemografica();

		// EXERC�CIO 8D
		double territorioNacional = 8515759; // BRASIL
		double porcentagemArea = arvore.somatorioAreaEmRelacaoAoTerritorioNacional(territorioNacional);
		System.out.println("Porcentagem de �rea em rela��o ao territ�rio nacional: " + porcentagemArea + "%");

		// EXERC�CIO 8E
		String cidadeMaiorPopulacao = arvore.cidadeComMaiorPopulacao();
		System.out.println("Cidade com a maior popula��o: " + cidadeMaiorPopulacao);
	}
}
