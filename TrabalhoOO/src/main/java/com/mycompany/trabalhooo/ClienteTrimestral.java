package com.mycompany.trabalhooo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteTrimestral extends Cliente{
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone,String sexo){
        super(tipoPlano, nome, cpf, dataMatricula, telefone,sexo);
        this.setDesconto(5);
        this.updateVencimento();  
        this.setNumeroParcelas(3);
    }
    
    //Leitura do txt
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade,String telefone,String sexo) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone,sexo);
        this.setNumeroParcelas(3);
        this.setDesconto(5);
    }
    
    @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
 }
