package com.mycompany.trabalhooo;

import java.util.Date;

public class ClienteAnual extends Cliente{

    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone,String sexo){
        super(tipoPlano, nome, cpf, dataMatricula, telefone,sexo);
        this.setDesconto(15);
        this.updateVencimento();
        this.setNumeroParcelas(12);
    }
    
    //Cliente já cadastrado
    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade,String telefone,String sexo) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone,sexo);
       this.setNumeroParcelas(12);
        this.setDesconto(15);
      
    }
    
    @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
}
