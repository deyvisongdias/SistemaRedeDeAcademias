/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author deive
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador {

    //identificação
    private String nome = "adm";
    private String senha = "adm";

    //construtores
    public Administrador() {
    }

    //Getters e Setters
    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

   static public void CriaFuncionario(String tipoDeFuncao, String nome, String cpf,
            String dataMatricula, String telefone, String sexo, String senha) {
        if (tipoDeFuncao == "Treinador") {
            
            Instrutor rc = new Instrutor(nome, senha, cpf, dataMatricula, sexo, telefone);
            
        } else {
            Recepcionista rc = new Recepcionista(nome, senha, cpf, dataMatricula, sexo, telefone);
        }
    }
}
