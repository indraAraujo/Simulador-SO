
import java.util.Random;
/**
 * 
 * @author WillianS
 */

public class Variavel {
    private int cod; // como vai gerar esse código?
    private String identificador; //conjunto de caracteres ou instrução 
    private int tam; //Tamanho na memória 
    private int regBase; //registrador que indica inicio do bloco
    private int regTamanho; //tamanho para ser acrescido no Base e encontrar final do bloco na memória.

    public Variavel(int tm, String identificador){
        this.tam = tm;
	this.identificador = identificador;
    }

    public void setRegBase(int rgB, int rgF){
        this.regBase = rgB;
        this.regTamanho = rgF;
    }
    
    public void setCod(int cd){
        this.cod = cd;
    }

    public int getCod(){
        return cod;
    }

    public int getTam(){
        return tam;
    }

    public int getRegBase(){
        return regBase;
    }

    public int getRegTamanho(){
        return regTamanho;
    }

    public String getIdentificador(){
        return identificador;
    }
}
