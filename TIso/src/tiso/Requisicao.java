package tiso;

/**
* Objeto que representa a requisição
*
*/
public class Requisicao {
    int identificador;
    int tamanho; //tamanho da variavel
   Variavel variavel;
 
    //Construtor da classe.
    public Requisicao(int tm, int id, String conteudo_variavel){
        this.tamanho = tm;
        this.identificador = id;
        variavel = new Variavel(tm, conteudo_variavel);
    }
 
    public void setIdentificador(int id){
        this.identificador = id;
    }
 
    public Variavel getVariavel(){
        return variavel;
    }
 
    public int getTamanho(){
        return tamanho;
    }
 
    public int getIdentificador(){
        return identificador;
    } 
 
    public String toString(){
        return " \n REQUISIÇÃO " + identificador + " ---- \n tamanho -> " + tamanho + variavel.toString();
    }

}
