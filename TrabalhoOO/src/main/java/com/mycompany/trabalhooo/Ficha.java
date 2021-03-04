/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/
package com.mycompany.trabalhooo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ficha {

    private File file;
    private List<Aparelhos> list = new ArrayList<>();

    public Ficha(File file) {
        this.file = file;
    }

    //metodos
    public void removeAparelhos(Aparelhos a) {
        //lembrar de tirar de arquivo txt
        list.remove(a);
    }

    public void adicionaAparelhos(Aparelhos a) {
        //Abrir e escrever no arquivo txt
        list.add(a);
    }

    public void writeFile(String path) throws IOException {
        FileWriter ficha = new FileWriter("ficha.txt");
        PrintWriter gravarFicha = new PrintWriter(ficha);

        gravarFicha.printf("Academia SmartFit");
        for (int i = 1; i <= 10; i++) {
            //gravarFicha.printf("| %2d X %d = %2d |%n", i, n, (i * n));
        }
        gravarFicha.printf("-------------");

        ficha.close();
        
    }

    //falta o resto da implementação
}
