
/* Lê o arquivo de configuração passado como parâmetro, 
 * e determina os valores das variáveis correspondentes.
 *
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reader
{
	File file;
	Scanner scanner;
	private int tamHeap;
	private int tamVetorReq;
	private int limMinOcup;
	private int limMaxOcup;
	private int limFragHeap;
	private int tamMinVar;
	private int tamMaxVar;
	private int totalAlocacoes;

	public Reader (String caminho)
	{
		try {
			file = new File (caminho);
			scanner = new Scanner (file);

			while (scanner.hasNextLine()) {
				String string = scanner.nextLine();
				String[] a = string.split(":");
				String valueString;
				int value = -1;

				if (a.length > 1) {
					valueString = a[1];
					valueString = valueString.trim();
					value = Integer.parseInt(valueString);
				}
				else continue;

				if (string.contains("Tamanho da heap:")) 
					tamHeap = value;

				if (string.contains("Limite de fragmentação da heap")) 
					limFragHeap = value;
				
				else if (string.contains("Tamanho do vetor de requisições")) 
					tamVetorReq = value;
				
				else if (string.contains("Limite mínimo de ocupação da heap")) 
					limMinOcup = value;
				
				else if (string.contains("Limite máximo de ocupação da heap")) 
					limMaxOcup = value;
				
				else if (string.contains("Tamanho mínimo para as variáveis")) 
					tamMinVar = value;
				
				else if (string.contains("Tamanho máximo para as variáveis")) 
					tamMaxVar = value;
				
				else if (string.contains("Quantidade de alocações a serem feitas")) 
					totalAlocacoes = value;
				
			}
		} catch (FileNotFoundException fe){
			System.out.println("Exception: "+ fe);
		}
	}

	// retorna o valor para o tamanho da heap
	public int getTamHeap ()
	{
		return tamHeap;
	}

	// retorna o tamanho do vetor de requisições
	public int getTamVetorReq ()
	{
		return tamVetorReq;
	}

	// retorna o limite mínimo de ocupação da heap
	public int getLimMinOcupHeap ()
	{
		return limMinOcup;
	}

	// retorna o limite máximo de ocupação da heap
	public int getLimMaxOcupHeap ()
	{
		return limMaxOcup;
	}

	// retorna o limite de fragmentação da heap
	public int getLimFragHeap ()
	{
		return limFragHeap;
	}

	// retorna o tamanho mínimo para as variáveis dinâmicas
	public int getTamMinVar ()
	{
		return tamMinVar;
	}

	// retorna o tamanho máximo para as variáveis dinâmicas
	public int getTamMaxVar ()
	{
		return tamMaxVar;
	}
	
	// retorna a quantidade total de alocações a serem realizadas
	public int getTotalAlocacoes ()
	{
		return totalAlocacoes;
	}

	public void close()
	{
		scanner.close();
	}
}

