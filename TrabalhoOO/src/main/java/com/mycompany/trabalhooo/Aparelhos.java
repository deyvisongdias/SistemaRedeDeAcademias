/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/

package com.mycompany.trabalhooo;


public class Aparelhos {
    
    private String nome;
    private String numeracao;
    private boolean estadoFuncionamento;

    public Aparelhos(String nome, String numeracao) {
        this.nome = nome;
        this.numeracao = numeracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }
    
     public String toString(){
         String st="Interditado";
         if(estadoFuncionamento==true)
         {
             st="Em funcionamento";
         }
         return "Nome :" + nome + "\nNumeracao :" + numeracao+"\nEstado de funcinamento :"+st;
     }
    
    
}
