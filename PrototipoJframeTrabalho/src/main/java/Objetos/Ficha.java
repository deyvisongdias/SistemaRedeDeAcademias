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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.StyledEditorKit;

public class Ficha {

    File file;
    Path caminho = Paths.get("C:\\temp\\in.txt");
    String texto;
    Scanner sc = null;
    List<File> listficha = new LinkedList<>();

    // construtores
    public Ficha() {

    }

    public Ficha(String cpf) throws IOException {
        //
        if (!verificaFicha(cpf)) {
            File ficha = new File((cpf + ".txt"));
        }
//		FileWriter wfile;
//		String path = "C:\\temp\\in.txt";// MUDAR CAMINHO
//		wfile = new FileWriter(new File(cpf + ".txt"));

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

        for (File f : listficha) {
            if (f.getName() == (m + ".txt")) {
                return true;
            }

        }
        return false;

//		String path = "C:\\temp\\in.txt";
//
//		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//			String line = br.readLine();
//			if (line == m) {
//				return true;
//
//			}
//		}
//		 catch (IOException e) {
//			System.out.println("Error: " + e.getMessage());
//		}
//		return false;
    }

    public List<String> addTabela(String cpf) throws FileNotFoundException {
      
        String path = "C:\\temp\\in.txt";
        List<String> list = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
    
    
    
    
    
    
//        for (File f : listficha) {
//            if (f.getName() == (cpf + ".txt")) {
//            break;
//            }
//        List<String> leitura=new LinkedList<>();
//        FileReader reader= new FileReader(f);        
//                
//        
//        }



}
