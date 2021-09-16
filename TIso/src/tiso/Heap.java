
public class Heap {
	
	private int heap[];
	private int tamanhoHeap;//asdasd
	
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
	
	public void addHeap(int partVariavel, int index) {
		
		heap[index] = partVariavel;
		
		
	}

	public int consult (int i)
	{
		return heap[i];
	}

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
	
	public int[] encontrarCampoVazio() {
		
		int indexs[] = new int[tamanhoHeap];
		int j = 0;
		
		
		if(heap == null)
			return null;
		
		else {
			for(int i=0; i<tamanhoHeap; i++) {
				int temp;
				temp = heap[i];
				if(temp == 0) {
					indexs[j] = i;
					j++;
					
				}
			}
		}
		
		return indexs;
	}

	public int[] getHeap(){
		return heap;
	}

	public void showHeap(){
		for(int i=0; i<tamanhoHeap; i++){
			System.out.println(heap[i]+"\n");
		}
	}
	
}
