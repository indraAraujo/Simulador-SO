package tiso.Threads;


import java.util.ArrayList;

/**
 * @author indra
 */
public class VetorRequisicoesThread {

	private int tamanho, inicio, fim;
	private ArrayList<RequisitosThread> fila = new ArrayList<>();

	public VetorRequisicoesThread(int tamanho){
		this.tamanho=tamanho;
		this.inicio = 0;
		this.fim = 0;

	}

	public boolean inserir(RequisitosThread requisicao){
		boolean cheia = false;
		//if(fim < tamanho){	
			fila.add(fim, requisicao);
			fim++;
		//}else cheia = true;
		return cheia;
	}

	public RequisitosThread remover(){
		if(fila.isEmpty()){
			System.out.println("Vazio");
			return null;
		}
			RequisitosThread temp = fila.get(0);
		fila.remove(0);
		fim--;
		return temp;
	}

	public void getVetor(){

		if(fila.isEmpty()){
			System.out.println("Vetor de Requisições está vazia");
			return;
		}else{
			for(int i = 0; i< fila.size(); i++){
				System.out.println(fila.get(i));
			}
		}
	}

	public boolean vazio ()
	{
		boolean result = false;

		if(fila.isEmpty()){
			result = true;
		}

		return result;
	}
}


/*import java.util.ArrayList;

/**
 * @author indra
 */
/*public class VetorRequisicoes {

	private int tamanho, inicio, fim;
	private ArrayList<Requisitos> fila = new ArrayList<>();

	public VetorRequisicoes(int tamanho){
		this.tamanho=tamanho;
		this.inicio = this.fim = -1;
	}

	public boolean inserir(Requisitos requisicao){
		boolean cheia=false;
		if((inicio == 0 && fim == tamanho-1)||(fim==(inicio-1)%(tamanho-1))){
			cheia=true;
		}else if(inicio == -1){
			inicio = 0;
			fim = 0;
			fila.add(fim, requisicao);
		}else if(fim == tamanho-1 && inicio != 0){
			fim = 0;
			fila.set(fim, requisicao);
		}else{
			fim = (fim+1);
			if(inicio <= fim){
				fila.add(fim, requisicao);
			}else{
				fila.set(fim, requisicao);
			}
		}
		return cheia;
	}

	public Requisitos remover(){
		//System.out.println("Remoção do vetor de requisiões acionada");
		Requisitos temp=null;
		if(inicio==-1){
			return null;
		}
		temp = fila.get(inicio);

		if(inicio==fim){
			inicio = -1;
			fim = -1;
		}else if(inicio==tamanho-1){
			inicio = 0;
		}else{
			inicio ++;
		}
		return temp;
	}

	public void getVetor(){
		if(inicio == -1){
			System.out.println("Vetor de Requisições está vazia");
			return;
		}
		if(fim >= inicio){
			for(int i = inicio; i<= fim; i++){
				System.out.println(fila.get(i)+" \n");
			}
		}else{
			for(int i = inicio; i< tamanho; i++){
				System.out.println(fila.get(i)+" \n");
			}
			for(int i=0; i<= fim; i++){
				System.out.println(fila.get(i)+" \n");
			}
		}
	}

	public boolean vazio ()
	{
		boolean result = false;

		if(inicio==-1){
			result = true;
		}

		return result;
	}
}

/*
import java.util.ArrayList;
public class VetorRequisicoes {

	private int tamanho, inicio, fim;
	private ArrayList<Requisitos> fila = new ArrayList<>();

	public VetorRequisicoes(int tamanho){
		this.tamanho=tamanho;
		this.inicio = this.fim = -1; 
	}

	public boolean inserir(Requisitos requisicao){
		boolean cheia=false;
		if((inicio == 0 && fim == tamanho-1)||(fim==(inicio-1)%(tamanho-1))){
			cheia=true; 
		}else if(inicio == -1){
			inicio = 0;
			fim = 0;
			fila.add(fim, requisicao);
		}else if(fim == tamanho-1 && inicio != 0){
			fim = 0;
			fila.set(fim, requisicao);
		}else{
			fim = (fim+1);
			if(inicio <= fim){
				fila.add(fim, requisicao);
			}else{
				fila.set(fim, requisicao);
			}
		}
		return cheia;
	}

	public Requisitos remover(){
		//System.out.println("Remoção do vetor de requisiões acionada");
		Requisitos temp=null;
		if(inicio==-1){
			return null;
		}
		temp = fila.get(inicio);

		if(inicio==fim){
			inicio=-1;
			fim=-1;
		}else if(inicio==tamanho-1){
			inicio =0;
		}else{
			inicio ++;			
		}
		return temp;
	}

	public void getVetor(){
		if(inicio == -1){
			System.out.println("Vetor de Requisições está vazia");
			return;
		}
		if(fim >= inicio){
			for(int i = inicio; i<= fim; i++){
				System.out.println(fila.get(i)+" \n");
			}
		}else{
			for(int i = inicio; i< tamanho; i++){
				System.out.println(fila.get(i)+" \n"); 
			}
			for(int i=0; i<= fim; i++){
				System.out.println(fila.get(i)+" \n");
			}
		}
	}

	public boolean vazio ()
	{
		boolean result = false;

		if(inicio==-1){
			result = true;
		}

		return result;
	}
}
*/
