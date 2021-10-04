package tiso.Threads;
import java.util.ArrayList;

import tiso.Requisicao;
import tiso.Variavel;

public class AlocadorTrhead implements Runnable{
	private int reqs_proces , inicio, reqs_totais,  removidas;
	private ArrayList<Variavel> controle = new ArrayList<>();
	public static DesalocadorDeMemoriaThread desaloc = new DesalocadorDeMemoriaThread();
	private long tempoR, tempoI, tempoF;
		
	private Requisicao r;

	//private DesalocadorDeMemoria desaloc = new DesalocadorDeMemoria();
	//Construtor da classe.
	public AlocadorTrhead ( long t, int req_T){
		this.reqs_proces = 0;
		this.reqs_totais = req_T;
		this.removidas = 0;
	}

	// Recebe uma requisição, inserindo a variável na heap, byte a byte.
	// Retorna true se tudo der certo, caso contrário, retornará false.
	public void run(){
		int counter = 0;
		
		boolean permitido_pegar_proximo = true;
		
		while(reqs_proces < reqs_totais){
			tempoI = System.nanoTime();			
			counter ++;
			synchronized(MainThread.vetor_Req){
				if (permitido_pegar_proximo) {
					r = MainThread.vetor_Req.remover();
					if(MainThread.vetor_Req.vazio()) {
						MainThread.vetor_Req.getVetor();
					}
				}
			}
			if(r != null){
				inicio = MainThread.analiser.primeiroEncaixe(r.getTamanho());
				if(inicio != -1){
					Variavel variavel_alocada = r.getVariavel();
					variavel_alocada.setRegBase(inicio);
					variavel_alocada.setRegTamanho( (inicio + r.getTamanho() - 1));
					controle.add (variavel_alocada);
					char [] cont = variavel_alocada.gerCont_Char();
					synchronized(MainThread.userHeap){
						reqs_proces ++;
						for (int i = 0; i < variavel_alocada.getTam(); i++)
							MainThread.userHeap.addHeap (cont[i], inicio + i);
						permitido_pegar_proximo = true;
					}
					MainThread.analiser.atualizarBuracos();
					
				} else {// chamar o desalocador
					permitido_pegar_proximo = false;
					boolean control = false;
					for(Variavel v: controle){
						if(r.getTamanho() < v.getTam()){
							control = true;
							desaloc.desalocarVar(v);
							MainThread.analiser.atualizarBuracos();
							if(controle.remove(v))
								removidas++;
							break;
						}
					}
					if (control == false) {
						desaloc.desalocarVar(controle.get(controle.size()-1));
						controle.remove(controle.get(controle.size()-1));
						MainThread.analiser.atualizarBuracos();
					}
				}
			}
			else {
				permitido_pegar_proximo = true;
				if (counter > 2000){
					break;
				}
			}
			tempoF = System.nanoTime();
			tempoR = ((tempoF - tempoI)/1000000);
			MainThread.t_Alocador += tempoR;
			
		}
		MainThread.terminou = true;
	}

	public int getProces(){return reqs_proces;}
	public void sleep(){
	}
	
}
