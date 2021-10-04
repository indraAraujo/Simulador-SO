package tiso.Threads;

import tiso.Output;
import tiso.Variavel;

public class DesalocadorDeMemoriaThread{
	private long tempoR, tempoI, tempoF;
	Output output = new Output();

	public DesalocadorDeMemoriaThread(){
		
	}

	//Desalocação de uma variável da heap.
	public void desalocarVar (Variavel variavel){
		tempoI = System.nanoTime();
		// MainTrhead.gestorHeap.acquire();
		

		synchronized (MainThread.userHeap) {
			for (int i = 0; i < variavel.getTam(); i ++) {
				MainThread.userHeap.removeHeap(variavel.getRegBase() + i);
			}
		}
		tempoF = System.nanoTime();
		tempoR = ((tempoF - tempoI)/1000000);
		MainThread.t_Desalocador += tempoR;
		// MainTrhead.gestorHeap.release();
		
	}
}
