package tiso;


import java.util.ArrayList;

public class VetorRequisicoes {

	private int fim=0;
	private ArrayList<Requisicao> fila = new ArrayList<>();


	public boolean inserir(Requisicao Requisicao){
		boolean cheia = false;	
			fila.add(fim, Requisicao);
			fim++;
		return cheia;
	}

	public Requisicao remover(){
		if(fila.isEmpty()){
			System.out.println("Vazio");
			return null;
		}
			Requisicao temp = fila.get(0);
		fila.remove(0);
		fim--;
		return temp;
	}

	public void getVetor(){

		if(fila.isEmpty()){
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
