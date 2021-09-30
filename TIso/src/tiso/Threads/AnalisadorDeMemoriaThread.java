package tiso.Threads;
import java.util.ArrayList;



public class AnalisadorDeMemoriaThread implements Runnable{
    private int tamanhoHeap;
	private int limiteMaxOcupacao;
	private int limiteMinOcupacao;
	private int limiteFragmentacao;
	private double taxaOcupacao;
	private double taxaFragmentacao;
	private ArrayList<BuracosThread> buracos;
	private ArrayList<VariavelThread> controle;
	private int chamadasAoDesalocador;
	private long tempoR, tempoI, tempoF;

	
	//Construtor da classe.
	public AnalisadorDeMemoriaThread (){
		this.tamanhoHeap = MainThread.tamanhoHeap;
		this.limiteMaxOcupacao = MainThread.limiteMaxOcupacao;
		this.limiteMinOcupacao = MainThread.limiteMinOcupacao;
		this.limiteFragmentacao = MainThread.limiteFragmentacao;
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

		for (BuracosThread i : buracos){
			if (i.getTamanho() >= tamanho){
				retorno = i.getInicio();
				return retorno; // pega o primeiro buraco
			}
		}
		return retorno; // se não encontrou nenhum buraco retorna -1;
	}

	//Análise da heap sob ângulos diversos
    public void run(){
		while(!MainThread.terminou){
			tempoI = System.nanoTime();
			//Análise da Taxa de Ocupação.
			monitorTaxaOcupacao();
			//Análise da Taxa de Fragmentação.
			//monitorFragmentacao();
			
			tempoF = System.nanoTime();
			tempoR = ((tempoF - tempoI)/1000000);
			MainThread.t_Analisador += tempoR;
		}
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
		
		synchronized (MainThread.userHeap){
			for (int i = 0; i < tamanhoHeap; i++) {
				if (i + 1 >= tamanhoHeap) break;
				if (MainThread.userHeap.consult(i) == 48) {
					int comeco = i;
					while (MainThread.userHeap.consult(i) == 48 && MainThread.userHeap.consult(i + 1) == 48 && i < tamanhoHeap) {
						i++;
						if(i + 1 >= tamanhoHeap) break;
					}
					int fim = i;
					this.buracos.add (new BuracosThread (comeco, fim));
					//imprimeBuracos();
				}
			}
		}
	}

	//Impressão da lista de buracos, para validação.
	public void imprimeBuracos (){
		System.out.println ("\n\t# Buracos:\n");
		for (BuracosThread i : buracos)
			System.out.println ("\t\tTamanho: " + i.getTamanho() + ", começa na posição " + i.getInicio() + ", vai até " + i.getFim());
	}

	//Determinação da taxa de ocupação (em porcentagem), com base na quantidade e no tamanho de buracos.
	//Se necessário, será acionado o desalocador.
	public void monitorTaxaOcupacao (){

		taxaOcupacao = calcularTaxaOcupacao();
		if(taxaOcupacao > limiteMaxOcupacao){
			System.out.println("Acionando desalocador");
			System.out.println ("Taxa de ocupação: " + taxaOcupacao);
			chamadasAoDesalocador ++;
			while (calcularTaxaOcupacao() > limiteMinOcupacao) {
				synchronized(MainThread.userHeap){
					if(!controle.isEmpty()){
						AlocadorTrhead.desaloc.desalocarVar(controle.get(0));
						System.out.println("Taxa" + taxaOcupacao);
						atualizarBuracos();
						controle.remove(0);
					}	
				}	
			}
		}
		else System.out.println ("Taxa de ocupação: " + taxaOcupacao);
	}
	
	//Calculo da Taxa de Ocupação.
	public double calcularTaxaOcupacao(){
		int memoria_livre = 0;
		for (BuracosThread i : buracos){
			memoria_livre += i.getTamanho();
		}
		
		double v = (double)(tamanhoHeap - memoria_livre) / tamanhoHeap;
		taxaOcupacao = (v * 100);
		System.out.println("Memoria Livre: " + memoria_livre + "Ocupação " +taxaOcupacao);
		return taxaOcupacao;
	}

	//Determinação da taxa de fragmentação, mensurada a partir da quantidade de buracos,
	// visto que a mesma é diretamente proporcional à fragmentação das variáveis
	public void monitorFragmentacao (){
		atualizarBuracos();
		double v = (double) buracos.size() / tamanhoHeap;
		taxaFragmentacao =  (v * 100);
		if (taxaFragmentacao > limiteFragmentacao)
			fragmentar();// compactar();
		System.out.println ("\tTaxa de fragmentação: " + taxaFragmentacao + " buraco(s) / 100 posições de memória");
	}
	public void fragmentar(){
		int ponteiro = 0;
		synchronized(MainThread.userHeap){
			for(VariavelThread v : controle){
				char [] cont = v.gerCont_Char();
				v.setRegBase(ponteiro, ponteiro + (ponteiro + v.getTam() - 1));
				for (int i = 0; i < v.getTam(); i++){
					MainThread.userHeap.addHeap(cont[i], ponteiro + i);
					ponteiro++;
				}
				ponteiro++;
			}
		}
	}
		public void setControle(ArrayList<VariavelThread> c){
		this.controle = c;
	}

	public int getDesalocacoesFeitas(){
		return chamadasAoDesalocador;
	}
}
