package tiso;


import java.util.Random;
/*

/**
 * 
 * @author WillianS
 * Objeto que gera randômicamente o tamanho da variável e o conteúdo da variável a ser alocada.
 */

public class GeradorDeRequisitos{
	//private int buffer; // tamanho max da fila circular
	//private int itens; // nº de itens não consumidos
	private int max; //Tamanho máximo da variável.
	private int min; //Tamanho mínimo da variável
	private int req_geradas;
	private int tamanho_variavel;
	private int contador;
	Random gerador = new Random();

	//Construtor da classe.
	public GeradorDeRequisitos(int mx, int mn){
		this.max = mx;
		this.min = mn;
		this.req_geradas = 0;
		this.contador=0;
	}

	//Geração do tamanho da variavel e instancia de uma nova requisição.
	public Requisicao gerarRequisicao(){
		// Requisicao req = new Requisicao(gerador.nextInt(max) + min);
		tamanho_variavel = (int)Math.floor(Math.random()*(max-min+1)+min);
		Requisicao req = new Requisicao(tamanho_variavel, contador, gerarConteudo());
		contador++;
		req_geradas++;
		return req; 
	}

	//Geração de multiplas requisições.
	public Requisicao[] gerarRequisicoes(int quantidade)
	{
		Requisicao[] requisicoes = new Requisicao[quantidade];

		for (int i = 0; i < quantidade; i++) {
			requisicoes[i] = this.gerarRequisicao ();
		}
		System.out.println ("\tForam inseridas " + quantidade + " novos elementos no vetor de requisições");

		return requisicoes;
	}

	public int getReqGeradas(){
		return req_geradas;
	}


	//Retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarConteudo ()
	{

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder sb = new StringBuilder(tamanho_variavel);

		for (int i = 0; i < tamanho_variavel; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
}

