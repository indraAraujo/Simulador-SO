package tiso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {

    public void escrever(String x) {
        try(FileWriter fw = new FileWriter("log.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
    {
        out.println(x);
    } catch (IOException e) {
        // exceção
    }

    }

}
