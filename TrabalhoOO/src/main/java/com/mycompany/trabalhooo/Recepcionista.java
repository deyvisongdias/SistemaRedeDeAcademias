
package com.mycompany.trabalhooo;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Recepcionista implements Pagamento{
    
    //identificaçao
     private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      
    private String nome;
    private String senha;
    
    List <Cliente> lista = new ArrayList<>();
    
    
     //construtores
    public Recepcionista(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public Recepcionista(){
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

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    //implementaçao metodos interface

    /**
     *
     * @param cliente
     * @throws ParseException
     */
    
     @Override
    public void alteraDataVencimento(Cliente cliente)
    {
         try {
             //parte da interface grafica
             String vencimento="00/00/0000";//so para teste
             Date data=sdf.parse(vencimento);
             cliente.setVencimento(data);
         } catch (ParseException ex) {
             Logger.getLogger(Recepcionista.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
            
    public Double retornaValorPagamento(Cliente cliente)
    {
       return cliente.getMensalidade();
        
    }
  
    
    
    
    
}
