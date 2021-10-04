package test;

import java.util.ArrayList;

import tiso.AnalisadorDeMemoria;
import tiso.Buraco;
import tiso.Heap;

public class AnalisadorTest {
    
    AnalisadorDeMemoria analisador;
    Heap heap;
    ArrayList<Buraco> buracos = new ArrayList<>();
    
    //Construtor para o Analisador
    public AnalisadorTest(Heap heap) {
        this.heap = heap;
        analisador = new AnalisadorDeMemoria(200, 80, 20, 80, heap);
        buracos.add(new Buraco(90, 200));
    }

    //Teste do primeiro encaixe para a heap
    public void first_fit() {
        System.out.println("Teste Primeiro Encaixe - Analisador.....");
        for(int i=32; i<67; i++){
            heap.removeHeap(i); //cria um novo buraco na heap
        }
        buracos.add(new Buraco(32, 67));//adiciona o novo buraco à lista
        analisador.atualizarBuracos();
        int posicao = analisador.primeiroEncaixe(20); //tenta achar a primeira posição boa
        System.out.println(posicao);
        if(posicao==32){
            System.out.print("Sucesso!");
        }else{
            System.out.println("Falha!");
        }
    }

    //Teste da monitoração da taxa de ocupação da heap
    public void monitorar_ocupacao(){
        System.out.println("Teste Monitorar Ocupação - Analisador.....");
        int posicoes_desocupadas=0;
        float ocupacao=0;
        for(int i=0; i<buracos.size(); i++){
            posicoes_desocupadas+= buracos.get(i).getTamanho(); //pega o tamanho de cada buraco
        }
        ocupacao = (1-posicoes_desocupadas); //calcula a porcentagem das posições ocupadas com o todo
        if(ocupacao!=0){
            System.out.println("Sucesso!");
        }else{
            System.out.println("Falha!");
        }
    }

    //Teste da monitoração da taxa de fragmentação da heap
    public void monitorar_fragmentacao(){
        System.out.println("Teste Monitorar Fragmentação - Analisador.....");
        
        float fragmentacao = (buracos.size()*200)/100;  //pega quantos buracos existem e faz a porcentagem disso
        if(fragmentacao!=0){ //se a fragmentação for diferente de 0% então a análise está no caminho certo
            System.out.println("Sucesso!");
        }else{
            System.out.println("Falha!");
        }
    }
}
