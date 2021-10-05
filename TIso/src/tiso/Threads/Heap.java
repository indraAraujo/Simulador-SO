package tiso.Threads;

public class Heap {
	private char heap[];
	private int tamanhoHeap;//asdasd
	//Construtor da classe.
	public Heap(int tamanhoHeap) {
		this.heap = new char[tamanhoHeap];
		this.tamanhoHeap = tamanhoHeap;
		for(int i = 0; i<tamanhoHeap; i++) {
			
			heap[i]='0';
		}
		
	}
	public int getTamanhoHeap() {
		return tamanhoHeap;
	}
	public void setTamanhoHeap(int tamanhoHeap) {
		this.tamanhoHeap = tamanhoHeap;
	}
	
	//Adição de uma nova variável na Heap
	public void addHeap(char partVariavel, int index) {
		
		heap[index] = partVariavel;
		
		
	}

	//Consulta um campo específico na Heap.
	public int consult (int i){
		return heap[i];
	}

	//Remoção de uma variável da Heap.
	public char removeHeap(int index) {
		
		char temp = '0';
		if(heap == null) return temp;
		else {
			temp = heap[index];
			heap[index] = '0';
		}
		return temp;
	}
	
	//Retorno da Heap no estado atual.
	public char[] getHeap(){
		return heap;
	}

	//Impressão da Heap.
	public void showHeap(){
		for(int i=0; i<tamanhoHeap; i++){
			System.out.print(heap[i] + " ");
			if (i % 40 == 0) 
				System.out.print("\n");
		}
		System.out.println("\n");
	}
}
