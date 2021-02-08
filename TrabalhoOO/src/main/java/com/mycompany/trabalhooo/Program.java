/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabalhooo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level; //Não faço ideia o que é isso, nem como parou aqui
import java.util.logging.Logger; //Não faço ideia o que é isso, nem como parou aqui

/**
 *
 * @author Yuri
 */
public class Program {

    public static void main(String[] args) {

        File clientesBD = new File("clientes.txt");
        String pathCliente = clientesBD.getAbsolutePath(); 
        Cliente cliente;
        List<Cliente> clientes = new ArrayList<>();
        Scanner sc = new Scanner(System.in); //apenas pra teste
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String nome, senha;
        int cpf;
        
        if (clientesBD.exists()) {// verifica se já existe um "banco de dados" dos clientes, se existir,
                                 //adiciona todos em uma lista, transformar em função todo esse bloco depois
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {
                    String[] fields = line.split(",");// Tô usando virgula pra separar cada atributo do cliente no arquivo, talvez mudar;
                    try {//Esse try é usado nas datas, elas lançam exceção
                        //Arquivo vai ordenar os dados na mesma ordem do construtor.
                        //Obs: se o atributo de split mudar, colocar o mesmo na função writeFile
                        clientes.add(new Cliente(fields[0],         //nome
                                Integer.parseInt(fields[1]),        //cpf
                                sdf.parse(fields[2]),               //matrícula
                                sdf.parse(fields[3]),               //vencimento
                                Integer.parseInt(fields[4]),        //id
                                Boolean.parseBoolean(fields[5]),    //status pagamento
                                fields[6]));                        //senha
                    } catch (ParseException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    line = br.readLine();
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        } 
        else { //cria o arquivo se não exister nenhum
            try {
                clientesBD.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //Inserção de dados, também transformar em função
        System.out.println("Nome:");
        nome = sc.next();
        System.out.println("Cpf"); 
        cpf = sc.nextInt();
        System.out.println("Senha:");
        senha = sc.next();
        cliente = new Cliente(nome, cpf, new Date(), senha);
        cliente.writeFile(clientesBD);
        clientes.add(cliente);
        
        
        for (Cliente c : clientes) {
            System.out.println(c);
        }
        sc.close();
    }
}
