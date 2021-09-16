
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
	Random gerador = new Random();

	public GeradorDeRequisitos(int mx, int mn){
		this.max = mx;
		this.min = mn;
		this.req_geradas = 0;
	}

	public Requisicao gerarRequisicao(){
		// Requisicao req = new Requisicao(gerador.nextInt(max) + min);
		int tam = (int)Math.floor(Math.random()*(max-min+1)+min);
		Requisicao req = new Requisicao(tam, gerarIdentificador());
		req_geradas++;
		return req; 
	}

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


	// retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarIdentificador ()
	{
		int n = 3;

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
}

