/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/

package com.mycompany.trabalhooo;//pacote

import java.util.ArrayList;
import java.util.List;


public class Administrador {
    
    //identificação
    private String nome;
    private String senha;
    
    List <Aparelhos> lista=new ArrayList<>();//lista de Aparelhos

    //construtores
    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Administrador() {
    }

    //Getters e Setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Aparelhos> getLista() {
        return lista;
    }

    public void setLista(List<Aparelhos> lista) {
        this.lista = lista;
    }
    
    //Metodos
    
    public void verificaFuncionamento(Aparelhos aparelho)
    {
        System.out.println(aparelho.toString()); 
        
    }
    
    
    
    

}

    
    
    
   
