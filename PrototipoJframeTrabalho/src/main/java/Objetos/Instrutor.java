/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import static Objetos.Administrador.listaInstru;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deive
 */
public class Instrutor {

    private String funcao;
    private String nome;
    private String senha;
    private String cpf;
    private String data;
    private String sexo;
    private String contato;

    //construtores
    public Instrutor(String nome, String senha, String cpf, String data, String sexo, String contato) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.data = data;
        this.sexo = sexo;
        this.contato = contato;
        listaInstru.add(this);
}

    public Instrutor() {
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getData() {
        return data;
    }

    public String getSexo() {
        return sexo;
    }

    public String getContato() {
        return contato;
    }

    public void setnull() {
        this.nome = null;
        this.senha = null;
        this.cpf = null;
        this.data = null;
        this.sexo = null;
        this.contato = null;

    }

   public void writeFile() {
        String dados = this.toString();
        String path =Administrador.func.getAbsolutePath();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(dados);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
 
    public String ToString()
    {
        return ("Instrutor"+"|"+getNome()+"|"+getSenha()+"|"+getCpf()+"|"+getData()+"|"+getSexo()+"|"+getContato());
    }
    
}
