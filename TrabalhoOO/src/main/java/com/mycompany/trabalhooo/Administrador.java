/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/

package com.mycompany.trabalhooo;//pacote

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    
    private List<Cliente> clientes = new ArrayList<>();
    private Ficha ficha; //Necessario colocar uma ficha para o adm editar/remover?
    private Aparelhos aparelhos;
    private String nome;
    private String password;

    public Administrador(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Aparelhos getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(Aparelhos aparelhos) {
        this.aparelhos = aparelhos;
    }

    
    public String toString(){
        
        return "Nome :"+nome;    
    }
    
    
    

}

    
    
    
   
