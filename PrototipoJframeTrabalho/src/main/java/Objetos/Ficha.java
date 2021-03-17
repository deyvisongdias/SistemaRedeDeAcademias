package Objetos;

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

    private String texto;
    private String cpf;
    File ficha;

    // construtores
    public Ficha() {
         

    }

    public Ficha(String cpf) throws IOException {
        this.cpf=cpf;
        if (!verificaFicha()) {
            ficha = new File((cpf + ".txt"));
            ficha.createNewFile();
        }

    }
    
    public void addArquivo( List<String> linhas) throws IOException {
        
        
        File file=new File(cpf+".txt");
        
        FileWriter fileWriter = new FileWriter(new File(file.getAbsolutePath()));
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (String linha : linhas) {
            bufferedWriter.write(linha);
        }

    }
    

    public void writeFile() {
        String dados = this.toString();
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(ficha.getAbsolutePath(), true))) {
            bw.write(dados);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean verificaFicha() {
        
        File file=new File(cpf+".txt");
        if(file.exists())
        {
           return true;
        }
        return false;

    }

    public List<Object[]> addTabela() throws FileNotFoundException {

       
        List<Object[]> list = new LinkedList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(ficha.getAbsolutePath()))) {
            String line = br.readLine();
            
          
            while (line != null) {
                String[] l = line.split("\\|");
                Object []o ={l[0],l[1],l[2],l[3]};
                list.add(o);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

}
