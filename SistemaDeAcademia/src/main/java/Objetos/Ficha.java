package Objetos;

/*
Deyvison Gregório Dias 201835017
Deiverson Mourão Alves Pedroso 201965123A
Pedro Henrique Almeida Cardoso Reis 201835039
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

    private String texto;
    private String cpf;
    private File ficha;
    private String path = null;

    // construtores
    public Ficha() {

    }

    public Ficha(String cpf) throws IOException {
        this.cpf = cpf;
        if (!verificaFicha()) {
            ficha = new File((cpf + ".txt"));
            ficha.createNewFile();
            path = ficha.getAbsolutePath();
        }
        ficha = new File((cpf + ".txt"));
        path = ficha.getAbsolutePath();

    }

    public void addArquivo(List<String> linhas) {
        this.ficha.delete();
        File file = new File(cpf + ".txt");

        String dados = this.toString();
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean verificaFicha() {

        File file = new File(cpf + ".txt");
        if (file.exists()) {
            return true;
        }
        return false;

    }

    public List<Object[]> addTabela() throws FileNotFoundException {

        List<Object[]> list = new LinkedList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            if (line != null) {
                while (line != null) {
                    String[] l = line.split("\\|");
                    Object[] o = {l[0], l[1], l[2], l[3]};
                    list.add(o);
                    line = br.readLine();
                }
            }
            return list;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
