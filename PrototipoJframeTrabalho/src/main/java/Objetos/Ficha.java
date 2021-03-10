/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author deive
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ficha {

	File file;
	Path caminho = Paths.get("C:\\temp\\in.txt");
	String texto;
	Scanner sc = null;

	// construtores

	public Ficha() {

	}

	public Ficha(String cpf) throws IOException {
		//
		FileWriter file;
		String path = "C:\\temp\\in.txt";// MUDAR CAMINHO
		file = new FileWriter(new File(cpf + ".txt"));

	}

	// metodos

	public void addArquivo(String cpf, List<String> linhas) throws IOException {
		this.texto = cpf;
		String path = "C:\\temp\\in.txt";// MUDAR CAMINHO

		FileWriter fileWriter = new FileWriter(new File(path));
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		for (String linha : linhas) {
			bufferedWriter.write(linha);
		}

	}

	private Boolean verificaFicha(String m) {

		String path = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			if (line == m) {
				return true;

			}
		}
		 catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}



	public void LeCliente() {

		String path = "C:\\temp\\in.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}