package com.mycompany.trabalhooo;

import java.util.Date;

public class ClienteSemestral extends Cliente{
    
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone) {
        super(tipoPlano, nome, cpf, dataMatricula, telefone);
        this.setDuracaoPlano(6);
        this.setDesconto(10);
        this.updateVencimento();
    }
    
    //Cliente já cadastrado
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula,
            double mensalidade,String telefone) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone);
        this.setDuracaoPlano(6);
        this.setDesconto(10);
    }
    
   @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
}
