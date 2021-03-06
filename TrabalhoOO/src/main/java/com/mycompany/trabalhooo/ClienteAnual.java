package com.mycompany.trabalhooo;

import java.util.Date;

public class ClienteAnual extends Cliente{

    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone) {
        super(tipoPlano, nome, cpf, dataMatricula, telefone);
        this.setDuracaoPlano(12);
        this.setDesconto(15);
        this.updateVencimento();
    }
    
    //Cliente já cadastrado
    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula,
            double mensalidade,String telefone) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone);
        this.setDuracaoPlano(12);
        this.setDesconto(15);
      
    }
    
    @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
}
