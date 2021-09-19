package tiso;

import tiso.AnalisadorDeMemoria;


/* 
 * Objeto responsável por monitorar  a taxa de ocupação e fragmentação,
 * acionando o desalocador quando necessário. Mantém a estrutura
 * de dados responsável por informar sobre buracos disponíveis
 * para as requisições. 
 *
 * */

import java.util.ArrayList;

public class AnalisadorDeMemoria
{
	private int tamanhoHeap;
	private int limiteMaxOcupacao;
	private int limiteMinOcupacao;
	private int limiteFragmentacao;
	private int taxaOcupacao;
	private int taxaFragmentacao;
	private Heap heap;
	private ArrayList<Buraco> buracos;
	private DesalocadorDeMemoria desalocador;
	private ArrayList<Variavel> controle;
	private int chamadasAoDesalocador;
	
	//Construtor da classe.
	public AnalisadorDeMemoria (int tamanhoHeap, int limiteMaxOcupacao, int limiteMinOcupacao, int limiteFragmentacao, Heap heap)
	{
		this.tamanhoHeap = tamanhoHeap;
		this.limiteMaxOcupacao = limiteMaxOcupacao;
		this.limiteMinOcupacao = limiteMinOcupacao;
		this.limiteFragmentacao = limiteFragmentacao;
		this.taxaOcupacao = 0;
		this.taxaFragmentacao = 0;
		this.heap = heap;
		this.buracos = new ArrayList<Buraco>();
		this.desalocador = new DesalocadorDeMemoria(heap);
		this.chamadasAoDesalocador = 0;
		atualizarBuracos();
	}

	//Algoritmo para encontrar buraco disponível para alocação - "First Fit".
	public int primeiroEncaixe (int tamanho)
	{
		int retorno = -1;

		for (Buraco i : buracos) {
			if (i.getTamanho() >= tamanho)
				retorno = i.getInicio();
		}

		return retorno;
	}

	//Análise da heap sob ângulos diversos
	public void analisarMemoria (){
		//Análise da Taxa de Ocupação.
		monitorTaxaOcupacao();
		//Análise da Taxa de Fragmentação.
		monitorFragmentacao();
	}

	//Atualização das informações sobre os buracos na heap.
	public void atualizarBuracos ()
	{
		buracos.clear ();

		for (int i = 0; i < tamanhoHeap; i++) {
			if (i + 1 >= tamanhoHeap) break;
			if (heap.consult(i) == 0) {
				int comeco = i;
				while (heap.consult(i) == 0 && heap.consult(i + 1) == 0 && i < tamanhoHeap) {
					i ++;
					if (i + 1 >= tamanhoHeap) break;
				}
				int fim = i;
				buracos.add (new Buraco (comeco, fim));
			}
		}

	}

	//Impressão da lista de buracos, para validação.
	public void imprimeBuracos ()
	{
		System.out.println ("\n\t# Buracos:\n");
		for (Buraco i : buracos)
			System.out.println ("\t\tTamanho: " + i.getTamanho() + ", começa na posição " + i.getInicio() + ", vai até " + i.getFim());
	}

	//Determinação da taxa de ocupação (em porcentagem), com base na quantidade e no tamanho de buracos.
	//Se necessário, será acionado o desalocador.
	public void monitorTaxaOcupacao ()
	{
		taxaOcupacao = calcularTaxaOcupacao();
		if (taxaOcupacao > limiteMaxOcupacao) {
			System.out.println("\t\tAcionando desalocador");
			chamadasAoDesalocador ++;
			while (calcularTaxaOcupacao() > limiteMinOcupacao) {
				desalocador.desalocarVar (controle.get(0));
				atualizarBuracos();
				controle.remove(0);
			}
		}
		else
			System.out.println ("\tTaxa de ocupação: " + taxaOcupacao);
	}

	//Calculo da Taxa de Ocupação.
	public int calcularTaxaOcupacao()
	{
		int memoria_livre = 0;
		for (int i = 0; i < buracos.size(); i++)
			memoria_livre += buracos.get(i).getTamanho();

		double v = (double)(tamanhoHeap - memoria_livre) / tamanhoHeap;
		taxaOcupacao = (int) (v * 100);
		
		return taxaOcupacao;
	}

	//Determinação da taxa de fragmentação, mensurada a partir da quantidade de buracos,
	// visto que a mesma é diretamente proporcional à fragmentação das variáveis
	public void monitorFragmentacao ()
	{
		atualizarBuracos();
		double v = (double) buracos.size() / tamanhoHeap;
		taxaFragmentacao = (int) (v * 100);
		if (taxaFragmentacao > limiteFragmentacao)
			;// compactar();
		System.out.println ("\tTaxa de fragmentação: " + taxaFragmentacao + " buraco(s) / 100 posições de memória");
	}

	public void setControle(ArrayList<Variavel> c)
	{
		this.controle = c;
	}

	public int getDesalocacoesFeitas()
	{
		return chamadasAoDesalocador;
	}
}

