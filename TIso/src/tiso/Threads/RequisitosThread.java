package tiso.Threads;
/**
* Objeto que representa a requisição
*
*/
/**
 *
 * @author indra
 */
public class RequisitosThread {
    int identificador;
    int tamanho; //tamanho da variavel
    VariavelThread variavel;
 
    //Construtor da classe.
    public RequisitosThread(int tm, int id, String conteudo_variavel){
        this.tamanho = tm;
        this.identificador = id;
        variavel = new VariavelThread(tm, conteudo_variavel);
    }
 
    public void setIdentificador(int id){
        this.identificador = id;
    }
 
    public VariavelThread getVariavel(){
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
