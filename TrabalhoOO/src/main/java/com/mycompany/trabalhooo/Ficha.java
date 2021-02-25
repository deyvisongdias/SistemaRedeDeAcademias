/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/

package com.mycompany.trabalhooo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Ficha {
    
    private File file;
    private List <Aparelhos> list = new ArrayList<>();

    public Ficha(File file) {
        this.file = file;
    }
    
    //metodos
    
    public void removeAparelhos(Aparelhos a)
    {
        //lembrar de tirar de arquivo txt
        list.remove(a);
    }
    
    public void adicionaAparelhos(Aparelhos a)
    {
        //Abrir e escrever no arquivo txt
        list.add(a);
    }
    
    public void writeFile(String path)
    {
        //implementar
    }
    
    
    
    //falta o resto da implementação
    
    
    
    
    
    
    
    
}
