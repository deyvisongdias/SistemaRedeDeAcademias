package com.mycompany.trabalhooo;

import java.util.Date;

public class ClienteSemestral extends Cliente{
    

   
    
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone,int numeroParcelas,int valorParcelado)
    {
        super(tipoPlano, nome, cpf, dataMatricula, telefone,numeroParcelas,valorParcelado);
        this.setDuracaoPlano(6);
        this.setDesconto(10);
        this.updateVencimento();
        this.setNumeroParcelas(0);
        this.setValorParcelado(0);

    //Cliente já cadastrado
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,Boolean statusMatricula, double mensalidade,String telefone,String sexo) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone,sexo);
        this.setNumeroParcelas(6);
        this.setDesconto(10);
    }
    
    
    
   @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
}
