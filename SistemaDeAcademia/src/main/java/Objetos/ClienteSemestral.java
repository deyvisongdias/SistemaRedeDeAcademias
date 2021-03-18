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

/*
Deyvison Gregório Dias 201835017
Deiverson Mourão Alves Pedroso 201965123A
Pedro Henrique Almeida Cardoso Reis 201835039
*/
public class ClienteSemestral extends Cliente {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, telefone, sexo);
        this.setDesconto(10);
        this.updateVencimento();
        this.setNumeroParcelas(6);

    }

    //Cliente já cadastrado
    public ClienteSemestral(String tipoPlano, String nome, String cpf, Date dataMatricula, Date vencimento, int id,
            Boolean statusMatricula, double mensalidade, String telefone, String sexo) throws IOException {
        super(tipoPlano, nome, cpf, dataMatricula, vencimento, id, statusMatricula, mensalidade, telefone, sexo);
        this.setNumeroParcelas(6);
        this.setDesconto(10);
        if (id > contId) {
            contId = id;
        }
    }

    @Override
    public String toString() {
        return super.toString();//+ "|" + this.getDesconto();
    }

}
