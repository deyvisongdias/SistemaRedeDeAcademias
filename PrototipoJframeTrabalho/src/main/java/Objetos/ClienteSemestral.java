/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author deive
 */
public class ClienteSemestral extends Cliente {

    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, telefone, sexo);
        this.setDesconto(10);
        this.updateVencimento();
        this.setNumeroParcelas(6);
        Recepcionista.lista.add(this);

    }

    //Cliente já cadastrado
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade, telefone, sexo);
        this.setNumeroParcelas(6);
        this.setDesconto(10);
        Recepcionista.lista.add(this);
        if(id >contId)
            contId = id;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + this.getDesconto();
    }
}
