
/**
 *
 * @author indra
 */
public class Requisicao {
   String identificador;
   int tamanho;
   Variavel variavel;

   public Requisicao(int tm, String id){
    this.tamanho = tm;
    this.identificador = id;
    variavel = new Variavel(tm, id); // ver se o tamanho da variavel vai ser o mesmo da requisição.
   }

   public void setIdentificador(String id){
       this.identificador = id;
   }

   public Variavel getVariavel(){
       return variavel;
   }

   public String getIdentificador(){
       return identificador;
   } 
}

