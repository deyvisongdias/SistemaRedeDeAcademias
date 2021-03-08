/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalhooo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteTrimestral extends Cliente{
    
        
        
        private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        private int duracaoPlano = 3;
        private double desconto = 5; //desconto em porcentagem
//        private Date renovacaoPlano;
        
    //Cadastro de um cliente com pagamento à vista
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula) {//Falta a ficha
        super(tipoPlano, nome, cpf, dataMatricula);
        this.setValorPlano(desconto);
        this.setAcrescimo(duracaoPlano);
        updateVencimento(this.getAcrescimo());
//        try {
//            renovacaoPlano = sdf.parse(this.getVencimento());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
         numParcelas = 0;//Talvez colocar 1
         valorParcela = this.getValorPlano();
    }
    
    //cadastro com pagamento parcelado
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula, int numParcelas){
        super(tipoPlano, nome, cpf, dataMatricula);
        this.setAcrescimo(duracaoPlano);
        this.setValorPlano(desconto);
        updateVencimento(this.getAcrescimo());
        valorParcela = this.getValorPlano()/numParcelas;
        this.numParcelas = numParcelas;
//        try {
//            renovacaoPlano = sdf.parse(this.getVencimento());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }
    
    //Leitura do txt
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula, double mensalidade,int numParcelas,
            double valorParcela/*,Date renovacaoPlano*/) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade);
        this.numParcelas = numParcelas;
        this.valorParcela = valorParcela;
//        Cliente.contId++;
//        this.renovacaoPlano = renovacaoPlano;      
    }

    public int getDuracaoPlano() {
        return duracaoPlano;
    }

    public void setDuracaoPlano(int duracaoPlano) {
        this.duracaoPlano = duracaoPlano;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }


//    public String getRenovacaoPlano() {
//        return sdf.format(renovacaoPlano);
//    }
//
//    public void setRenovacaoPlano(Date renovacaoPlano) {
//        this.renovacaoPlano = renovacaoPlano;
//    }
    
    //Getters e Setters numeroParcelas

    
    @Override
    public void setValorPlano(double desconto){
        double tempMensalidade = (super.getValorPlano() - (super.getValorPlano() * desconto)/100) * duracaoPlano;
        super.setValorPlano(tempMensalidade);
    }  
    
    public void updateVencimento(int acrescimo){//atualiza data do pagamento
        Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(this.getDataMatricula()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        cal.add(Calendar.MONTH, acrescimo);
        this.setVencimento(cal.getTime());
    }  
    
    @Override
    public String toString(){ 
        return super.toString() + "," + desconto + "," + numParcelas + "," + valorParcela/* + "," + this.getRenovacaoPlano()*/;
    }
 }
