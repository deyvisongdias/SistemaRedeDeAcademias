
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
    
    static int contId = 0; 
    static int contMatriculas = 0;
    
    private double mensalidade;
    
    public ClienteEmpresarial(String nome, int cpf, Date dataMatricula, Date vencimento, int id, Boolean statusMatricula, String senha,double desconto) {
        super(nome, cpf, dataMatricula, vencimento, id, statusMatricula, senha);
        this.desconto=desconto;
    }
    
    public ClienteEmpresarial(String nome, int cpf, Date dataMatricula, String senha,double desconto) {
        super(nome, cpf, dataMatricula, senha);
        this.desconto=desconto;
    }

    public double getMensalidade() {
        desconto=mensalidade*desconto;
        mensalidade+=desconto;
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        
        this.mensalidade = mensalidade;
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
