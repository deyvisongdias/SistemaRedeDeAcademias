/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author deive
 */

public class ClienteTrimestral extends Cliente {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula,String telefone,String sexo) {
        super(tipoPlano, nome, cpf, dataMatricula, telefone,sexo);
        this.setDuracaoPlano(3);
        this.setDesconto(5);
        this.updateVencimento();
    }

    //Leitura do txt
    public ClienteTrimestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, 
            int id, Boolean statusMatricula, double mensalidade, String telefone,String sexo) {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade, telefone, sexo);
        this.setDuracaoPlano(3);
        this.setDesconto(5);
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.getDesconto();
    }
}
