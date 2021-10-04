package tiso;

import java.util.Random;
/**
 * 
 * @author WillianS
 */

public class GeradorDeRequisitos{
	//private int buffer; // tamanho max da fila circular
	//private int itens; // nº de itens não consumidos
	private int max; 
	private int min; 
	private int req_geradas;
	private int tamanho_variavel;
	Random gerador = new Random();
	Output output = new Output();

	public GeradorDeRequisitos(int mx, int mn){
		this.max = mx;
		this.min = mn;
		this.req_geradas = 0;
	}

	public Requisicao gerarRequisicao(){
		// Requisicao req = new Requisicao(gerador.nextInt(max) + min);
		tamanho_variavel = (int)Math.floor(Math.random()*(max-min+1)+min);
		Requisicao req = new Requisicao(tamanho_variavel, req_geradas, gerarConteudo());
		req_geradas++;
		return req; 
	}

	public Requisicao[] gerarRequisicoes(int quantidade)
	{
		Requisicao[] requisicoes = new Requisicao[quantidade];

		for (int i = 0; i < quantidade; i++) {
			requisicoes[i] = this.gerarRequisicao ();
		}
		output.escrever("\tForam inseridas " + quantidade + " novos elementos no vetor de requisições");

		return requisicoes;
	}

	public int getReqGeradas(){
		return req_geradas;
	}


	// retorna uma string aleatória, de tamanho n; usada para o conteudo da variável
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

