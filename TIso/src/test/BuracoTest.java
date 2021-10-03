package test;
import tiso.Buraco;
public class BuracoTest {
    public int inicio;
    public int fim;

    Buraco hole = new Buraco(0, 10);

    public void getInicioTest(){

        if (hole.getInicio() == 0) {
            System.out.println("Sucesso! Teste buraco INICIO OK!");
        } 
        else {
            System.out.println("ERRO!");
        }
    }
    public void getFimTest(){

        if (hole.getFim() == 10) {
            System.out.println("Sucesso! Teste buraco FIM OK!");
        } 
        else {
            System.out.println("ERRO!");
        }
    }

    public void getTamanhoTest(){
        if (hole.getTamanho()==11) {
            System.out.println("Sucesso! Teste buraco TAMANHO OK!");
        } 
        else {
            System.out.println("ERRO!");
        }
    }

}
