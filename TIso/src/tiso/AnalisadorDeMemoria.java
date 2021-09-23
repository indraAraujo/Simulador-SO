import java.util.ArrayList;

public class AnalisadorDeMemoria{
    private int tamanhoHeap;
	private int limiteMaxOcupacao;
	private int limiteMinOcupacao;
	private int limiteFragmentacao;
	private int taxaOcupacao;
	private int taxaFragmentacao;
	private ArrayList<Buracos> buracos;
	private ArrayList<Variavel> controle;
	private int chamadasAoDesalocador;

	
	//Construtor da classe.
	public AnalisadorDeMemoria (){
		this.tamanhoHeap = MainTrhead.tamanhoHeap;
		this.limiteMaxOcupacao = MainTrhead.limiteMaxOcupacao;
		this.limiteMinOcupacao = MainTrhead.limiteMinOcupacao;
		this.limiteFragmentacao = MainTrhead.limiteFragmentacao;
		this.taxaOcupacao = 0;
		this.taxaFragmentacao = 0;
		this.buracos = new ArrayList<>();
		this.controle = new ArrayList<>();
		this.chamadasAoDesalocador = 0;
		atualizarBuracos();
	}

	//Algoritmo para encontrar buraco disponível para alocação - "First Fit".
	public int primeiroEncaixe (int tamanho){
		int retorno = -1;

		for (Buracos i : buracos){
			if (i.getTamanho() >= tamanho){
				retorno = i.getInicio();
				return retorno; // pega o primeiro buraco
			}
		}
		return retorno; // se não encontrou nenhum buraco retorna -1;
	}

	//Análise da heap sob ângulos diversos
    public void run(){
        //Análise da Taxa de Ocupação.
		monitorTaxaOcupacao();
		//Análise da Taxa de Fragmentação.
		monitorFragmentacao();
    }
	/*public void analisarMemoria (){
		//Análise da Taxa de Ocupação.
		monitorTaxaOcupacao();
		//Análise da Taxa de Fragmentação.
		monitorFragmentacao();
	}*/

	//Atualização das informações sobre os buracos na heap.
	public void atualizarBuracos (){
		this.buracos.clear();
		
		MainTrhead.gestorHeap.acquire();
		for (int i = 0; i < tamanhoHeap; i++) {
			if (i + 1 >= tamanhoHeap) break;
			if (MainTrhead.userHeap.consult(i) == 0) {
				int comeco = i;
				while (MainTrhead.userHeap.consult(i) == 0 && MainTrhead.userHeap.consult(i + 1) == 0 && i < tamanhoHeap) {
					i++;
					if(i + 1 >= tamanhoHeap) break;
				}
				int fim = i;
				this.buracos.add (new Buracos (comeco, fim));
			}
		}
		MainTrhead.gestorHeap.release();

	}

	//Impressão da lista de buracos, para validação.
	public void imprimeBuracos (){
		System.out.println ("\n\t# Buracos:\n");
		for (Buracos i : buracos)
			System.out.println ("\t\tTamanho: " + i.getTamanho() + ", começa na posição " + i.getInicio() + ", vai até " + i.getFim());
	}

	//Determinação da taxa de ocupação (em porcentagem), com base na quantidade e no tamanho de buracos.
	//Se necessário, será acionado o desalocador.
	public void monitorTaxaOcupacao (){

		taxaOcupacao = calcularTaxaOcupacao();
		if(taxaOcupacao > limiteMaxOcupacao){
			System.out.println("\t\tAcionando desalocador");
			chamadasAoDesalocador ++;
			while (calcularTaxaOcupacao() > limiteMinOcupacao) {
				AlocadorTrhead.desaloc.desalocarVar(controle.get(0));
				atualizarBuracos();
				controle.remove(0);
			}
		}
		else System.out.println ("\tTaxa de ocupação: " + taxaOcupacao);
	}

	//Calculo da Taxa de Ocupação.
	public int calcularTaxaOcupacao(){
		int memoria_livre = 0;
		for (int i = 0; i < buracos.size(); i++){
			memoria_livre += buracos.get(i).getTamanho();
		}
		float v = (float)(tamanhoHeap - memoria_livre) / tamanhoHeap;
		taxaOcupacao = (int) (v * 100);
		
		return taxaOcupacao;
	}

	//Determinação da taxa de fragmentação, mensurada a partir da quantidade de buracos,
	// visto que a mesma é diretamente proporcional à fragmentação das variáveis
	public void monitorFragmentacao (){
		atualizarBuracos();
		double v = (double) buracos.size() / tamanhoHeap;
		taxaFragmentacao = (int) (v * 100);
		if (taxaFragmentacao > limiteFragmentacao)
			;// compactar();
		System.out.println ("\tTaxa de fragmentação: " + taxaFragmentacao + " buraco(s) / 100 posições de memória");
	}

	public void setControle(ArrayList<Variavel> c){
		this.controle = c;
	}

	public int getDesalocacoesFeitas(){
		return chamadasAoDesalocador;
	}
}
