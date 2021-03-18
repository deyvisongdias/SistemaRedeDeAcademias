/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author deive
 */
public class ClienteAnual extends Cliente {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, telefone, sexo);
        this.setDesconto(15);
        this.updateVencimento();
        this.setNumeroParcelas(12);
    }

    //Cliente já cadastrado
    public ClienteAnual(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade, telefone, sexo);
        this.setNumeroParcelas(12);
        this.setDesconto(15);
        if (id > contId) {
            contId = id;
        }

    }

    @Override
    public String toString() {
        return super.toString();//+ "|" + this.getDesconto();
    }

   

}
