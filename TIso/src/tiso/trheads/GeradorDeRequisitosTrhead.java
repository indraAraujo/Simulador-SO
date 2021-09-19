package tiso.trheads;

import tiso.Requisicao;
import java.util.Random;

public class GeradorDeRequisitosTrhead implements Runnable{
    //private int buffer; // tamanho max da fila circular
	//private int itens; // nº de itens não consumidos
	private int max; //Tamanho máximo da variável.
	private int min; //Tamanho mínimo da variável
	private int req_geradas;
	private int tamanho_variavel;
	private int contador;
	Random gerador = new Random();

	//Construtor da classe.
	public GeradorDeRequisitosTrhead(int mx, int mn){
		this.max = mx;
		this.min = mn;
		this.req_geradas = 0;
		this.contador=0;
	}

	//Geração do tamanho da variavel e instancia de uma nova requisição.
    @Override
    public void run() { //gerarRequisicao
        // Requisicao req = new Requisicao(gerador.nextInt(max) + min);
        tamanho_variavel = (int)Math.floor(Math.random()*(max-min+1)+min);
        Requisicao req = new Requisicao(tamanho_variavel, contador, gerarConteudo());
        if(!MainTrhead.vetor_requisicoes.inserir(req));
        contador++;
        req_geradas++;
	}

	public int getReqGeradas(){ return req_geradas;}


	//Retorna uma string aleatória, de tamanho n; usada para o identificador da variável
	private String gerarConteudo(){
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
		StringBuilder sb = new StringBuilder(tamanho_variavel);

		for (int i = 0; i < tamanho_variavel; i++) {
			int index = (int)(AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
}
