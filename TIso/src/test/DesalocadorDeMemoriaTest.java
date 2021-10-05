package test;

import tiso.DesalocadorDeMemoriaS;
import tiso.VariavelAlocada;
import tiso.HeapS;
import tiso.Variavel;

public class DesalocadorDeMemoriaTest {

    HeapS heap = new HeapS(89);
    DesalocadorDeMemoriaS desalocador = new DesalocadorDeMemoriaS(heap);

    //Teste desaloca a variavel da heap
    public void desalocarVartest(VariavelAlocada variavel){

        System.out.println("Teste Desalocador - Desalocador de memória....."); 
        System.out.println("ANTES DE DESALOCAR");
        heap.showHeap(); // MOSTRA A HEAP ANTES DA DESALOCAÇÃO
        desalocador.desalocarVar(variavel); //desaloca da heap uma variavel
        
        if(heap.consult(1) == 0){   // consulta no index 1 se esta
            System.out.println("DEPOIS DE DESALOCAR");
            heap.showHeap(); // MOSTRA A HEAP DEPOIS DA DESALOCAÇÃO
            System.out.println("Sucesso!");
        }
        else{
            System.out.println("Falha!");
            heap.showHeap(); // MOSTRA A HEAP DEPOIS DA DESALOCAÇÃO
        }

    }

    
    
}
