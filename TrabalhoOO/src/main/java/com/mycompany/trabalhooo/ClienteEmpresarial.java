
package com.mycompany.trabalhooo;

import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;



public class ClienteEmpresarial extends Cliente{

    private double desconto;
    //!!!! Verificar a sequência dos parâmetros depois que ajustar a mensalidade no txt !!!!
    public ClienteEmpresarial(String nome, int cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula, String senha,double desconto,double mensalidade) {
        super(nome, cpf, dataMatricula, vencimento, id, statusMatricula, senha,mensalidade);
        this.desconto = desconto;
        this.ajustarMensalidade(desconto);
    }
    
    public ClienteEmpresarial(String nome, int cpf, Date dataMatricula, String senha,double desconto) {
        super(nome, cpf, dataMatricula, senha);
        this.desconto=desconto;
    }

    
    public void ajustarMensalidade(double mensalidade) {
        this.mensalidade -= mensalidade * desconto / 100;
    }

    public double getDesconto() {
        return desconto;
    }
    
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    @Override
    public String toString(){
         return super.toString() + "," + desconto; 
    }
    
    
}
