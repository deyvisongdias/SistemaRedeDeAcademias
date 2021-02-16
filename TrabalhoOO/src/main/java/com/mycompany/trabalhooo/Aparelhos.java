
package com.mycompany.trabalhooo;


public class Aparelhos {
    
    private String nome;
    private String numeracao;

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
         return "Nome :"+nome+"\nNumeracao :"+numeracao;
     }
    
    
}
