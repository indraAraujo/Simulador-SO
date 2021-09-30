package tiso.Threads;
import java.util.ArrayList;

public class AlocadorTrhead implements Runnable{
	//private int tamanhoHeap;
	private long tempo;
	private int reqs_proces , inicio, reqs_totais, tam_heap, removidas;
	private ArrayList<VariavelThread> controle = new ArrayList<>();
	public static DesalocadorDeMemoriaThread desaloc = new DesalocadorDeMemoriaThread();
	private long tempoR, tempoI, tempoF;
		
	private RequisitosThread r;

	//private DesalocadorDeMemoria desaloc = new DesalocadorDeMemoria();
	//Construtor da classe.
	public AlocadorTrhead (int tamanhoHeap, long t, int req_T){
		this.reqs_proces = 0;
		this.tempo = t;
		this.reqs_totais = req_T;
		this.tam_heap = tamanhoHeap;
		this.removidas = 0;
	}

	// Recebe uma requisição, inserindo a variável na heap, byte a byte.
	// Retorna true se tudo der certo, caso contrário, retornará false.
	public void run(){
		int counter = 0;
		
		// System.out.println("Antes de começar o while: reqs_process: " + reqs_proces+" regs totais: " +reqs_totais);
		boolean permitido_pegar_proximo = true;
		/*analiser_Thread.start();
		try {
			analiser_Thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		while(reqs_proces < reqs_totais){
			tempoI = System.nanoTime();			
			counter ++;
			//System.out.println("Entrei no while " + counter + " reqs processadas: " + reqs_proces);
			
			synchronized(MainThread.vetor_Req){
				if (permitido_pegar_proximo) {
					//System.out.println("Indo pegar o R");
					
					r = MainThread.vetor_Req.remover();
					//if (r != null) System.out.println("#### peguei " + counter2 + " do vetor de requisições");
					if(MainThread.vetor_Req.vazio()) {
						System.out.println("Vetor de req vazio no ciclo " + counter);
						MainThread.vetor_Req.getVetor();
					}
				}
			}
			if(r != null){
				inicio = MainThread.analiser.primeiroEncaixe(r.getTamanho());
				if(inicio != -1){
					//System.out.println("ENTREI");
					VariavelThread variavel_alocada = r.getVariavel();
					variavel_alocada.setRegBase(inicio, (inicio + r.getTamanho() - 1));
					variavel_alocada.setRegTamanho(r.getTamanho());
					controle.add (variavel_alocada);
					char [] cont = variavel_alocada.gerCont_Char();
					// MainTrhead.gestorHeap.acquire();
					synchronized(MainThread.userHeap){
						reqs_proces ++;
						//System.out.print("Requisições processadas: " + reqs_proces + " ");
						for (int i = 0; i < variavel_alocada.getTam(); i++)
							MainThread.userHeap.addHeap (cont[i], inicio + i);
						// MainTrhead.gestorHeap.release();
						permitido_pegar_proximo = true;
						System.out.println ("[Thread Alocador] Realizada alocacao: " + reqs_proces);
						//MainThread.userHeap.showHeap();
					}
					MainThread.analiser.atualizarBuracos();
					
				} else {// chamar o desalocador
					permitido_pegar_proximo = false;
					boolean control = false;
					for(VariavelThread v: controle){
						if(r.getTamanho() < v.getTam()){
							control = true;
							System.out.println("Chamado o desalocador");
							desaloc.desalocarVar(v);
							MainThread.analiser.atualizarBuracos();
							//MainTrhead.userHeap.showHeap();
							if(controle.remove(v))
								removidas++;
							break;
						}
					}
					if (control == false) {
						System.out.println("Entrou no Desalocador errado");
						desaloc.desalocarVar(controle.get(controle.size()-1));
						controle.remove(controle.get(controle.size()-1));
						MainThread.analiser.atualizarBuracos();
					}
				}
			}
			else {
				permitido_pegar_proximo = true;
				System.out.println ("R nulo antes da hora!!!");
				if (counter > 2000){
					System.out.println("ERRO EXAUSTÃO");
					break;
				}
			}
			tempoF = System.nanoTime();
			tempoR = ((tempoF - tempoI)/1000000);
			MainThread.t_Alocador += tempoR;
			
		}
		System.out.println("[Thread Alocador] Total de alocações realizadas: " + reqs_proces);
		System.out.println("[Thread Alocador] Desalocações realizadas: " + removidas);
		MainThread.terminou = true;
		//MainTrhead.userHeap.showHeap();
	}

	public int getProces(){return reqs_proces;}
	public void sleep(){
		// MainTrhead.vetor_Req.getVetor();
		System.out.println("R nulo no alocador");
		/*
		   System.out.println("sleep do alocador");
		   long tI = System.currentTimeMillis();
		   long tF, tR = 0;
		   while(tR <= tempo){
		   tF = System.currentTimeMillis();
		   tR = tF - tI;
		   }
		   */
		// System.out.println("Vetor de requisições cheio");
	}
	
}
