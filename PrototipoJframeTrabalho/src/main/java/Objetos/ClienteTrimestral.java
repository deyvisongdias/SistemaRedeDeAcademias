/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author deive
 */

public class ClienteTrimestral extends Cliente{
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone,String sexo) throws IOException{
        super(tipoPlano, nome, cpf, dataMatricula, telefone,sexo);
        this.setDesconto(5);
        this.updateVencimento();  
        this.setNumeroParcelas(3);
        Recepcionista.lista.add(this);
    }
    
    //Leitura do txt
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade,String telefone,String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade,telefone,sexo);
        this.setNumeroParcelas(3);
        this.setDesconto(5);
        Recepcionista.lista.add(this);
    }
    
    @Override
    public String toString(){ 
        return super.toString() + "|" + this.getDesconto();
    }
 }
