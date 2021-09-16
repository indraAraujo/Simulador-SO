package tiso;
/*
* Objeto que representa a Heap, na qual serão alocadas as variáveis geradas.
*
*/

public class Heap {
	
	private int heap[];
	private int tamanhoHeap;//asdasd
	
	//Construtor da classe.
	public Heap(int tamanhoHeap) {
		this.heap = new int[tamanhoHeap];
		this.tamanhoHeap = tamanhoHeap;
		
		for(int i=0; i<tamanhoHeap; i++) {
			
			heap[i]= 0;
		}
		
	}
	public int getTamanhoHeap() {
		return tamanhoHeap;
	}
	public void setTamanhoHeap(int tamanhoHeap) {
		this.tamanhoHeap = tamanhoHeap;
	}
	
	//Adição de uma nova variável na Heap
	public void addHeap(int partVariavel, int index) {
		
		heap[index] = partVariavel;
		
		
	}

	//Consulta um campo específico na Heap.
	public int consult (int i)
	{
		return heap[i];
	}

	//Remoção de uma variável da Heap.
	public int removeHeap(int index) {
		
		int temp = -1;
		
		if(heap == null)
		return temp;
		
		else {
			temp = heap[index];
			heap[index] = 0;
			
		}
		
		
		return temp;
		
	}
	
	//Retorno da Heap no estado atual.
	public int[] getHeap(){
		return heap;
	}

	//Impressão da Heap.
	public void showHeap(){
		for(int i=0; i<tamanhoHeap; i++){
			System.out.println(heap[i]+"\n");
		}
	}
	
}
