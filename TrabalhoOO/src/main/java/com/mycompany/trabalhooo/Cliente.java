/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/


package com.mycompany.trabalhooo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Cliente {

    static int contId; // Vai ser usada pra achar a ficha


    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String tipoPlano;
    private String nome;
    private String cpf;
    private Date dataMatricula;
    private Date vencimento;
    private int id;
    private Boolean statusMatricula;
//  private Ficha ficha;
    private double valorPlano;
    private int acrescimo = 1;
    
    //Construtor de um cliente novo
    public Cliente(String tipoPlano,String nome,String cpf, Date dataMatricula) {
        contId++;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataMatricula);
        cal.add(Calendar.MONTH, 1);
        this.tipoPlano = tipoPlano;
        this.nome = nome;
        this.cpf = cpf;  
        this.dataMatricula = dataMatricula; 
        vencimento = cal.getTime();
        this.id = contId;
        this.statusMatricula = true;
        valorPlano = 80;
    }
    
    //Construtor de um cliente já cadastrado, com o construtor de cima, dados como vencimento e statusMatricula
    //poderiam se perder. Usado quando lê os dados de um arquivo
    
    public Cliente(String tipoPlano,String nome, String cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula,double valorPlano){
        contId++;
        this.tipoPlano = tipoPlano;
        this.nome = nome;
        this.cpf = cpf;
        this.dataMatricula = dataMatricula;
        this.vencimento = vencimento;
        this.id = id;
        this.statusMatricula = statusMatricula;
        this.valorPlano = valorPlano;
    }

    public String getTipoPlano(){
        return tipoPlano;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getDataMatricula() {
        return sdf.format(dataMatricula);
    }
    
    public double getValorPlano() {
        return valorPlano;
    }
    
    public void setValorPlano(double valorPlano){
        this.valorPlano = valorPlano;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Boolean getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(Boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }
      
    public String getVencimento() {
        return sdf.format(vencimento);
    }
    
    public void setVencimento(Date vencimento){//usado para atualizar as subclasses
        this.vencimento = vencimento;
    }
    
    public void updateVencimento(){//atualiza data do pagamento
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataMatricula);
        cal.add(Calendar.MONTH, acrescimo);
        vencimento = cal.getTime();
    }  

    public int getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(int acrescimo) {
        this.acrescimo = acrescimo;
    }
    
    public void writeFile(File file){
        String dados = this.toString();
        String path = file.getAbsolutePath();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            bw.write(dados);
            bw.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return tipoPlano + "," + nome + "," + cpf + "," + getDataMatricula() + "," + getVencimento() + "," + 
               id + "," + statusMatricula + "," + this.valorPlano ;
    }
}
