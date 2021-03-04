/*Deiverson Mourão Alves Pedroso (201965123A) 
Deyvison Gregório Dias   (201835017)
Pedro Henrique Almeida Cardoso Reis (201835039)
Yuri de Oliveira (201835010)*/


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
import java.util.HashMap;
//import java.util.ArrayList;
import java.util.Map;
//import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    private static Scanner sc = new Scanner(System.in); //apenas pra teste
    public static void main(String[] args) {
        int updatedId = 0;
        File clientesBD = new File("clientes.txt");
        String pathCliente = clientesBD.getAbsolutePath();
        Map<String, Cliente> clientes = new HashMap<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String nome;
        String cpf = "";

        // VERIFICAR SE A PARCELA INFORMADA É <= AO LIMITE PARCELAS
//        //!!!! Não esquece de ajustar a Mensalidade !!!!
        if (clientesBD.exists()) {// verifica se já existe um "banco de dados" dos clientes, se existir, adiciona todos em uma lista
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {
                    String[] fields = line.split(",");
                    try {//Esse try é usado nas datas, elas lançam exceção
                        //Arquivo vai ordenar os dados na mesma ordem do construtor.
                        //Obs: se o atributo de split mudar, colocar o mesmo na função writeFile
                        if (fields[0] == "mensal") {
                            clientes.put(fields[2],                                            // cpf como chave
                                    new Cliente(fields[0],                                     //tipo plano
                                            fields[1],                                         //nome
                                            fields[2],                                         //cpf
                                            sdf.parse(fields[3]),                              //matrícula
                                            sdf.parse(fields[4]),                              //vencimento
                                            Integer.parseInt(fields[5]),                       //id
                                            Boolean.parseBoolean(fields[6]),                   //status pagamento
                                            Double.parseDouble(fields[7])));                   //mensalidade      
                                        
                        } else if (fields[0] == "trimestral") {
                            clientes.put(fields[2],                                             // cpf como chave
                                    new ClienteTrimestral(fields[0],                            //tipo plano
                                            fields[1],                                          //nome
                                            fields[2],                                          //cpf
                                            sdf.parse(fields[3]),                               //matrícula
                                            sdf.parse(fields[4]),                               //vencimento
                                            Integer.parseInt(fields[5]),                        //id
                                            Boolean.parseBoolean(fields[6]),                    //status pagamento
                                            Double.parseDouble(fields[7]),                      //mensalidade    
                                            Integer.parseInt(fields[8]),                        //nº parcelas
                                            Double.parseDouble(fields[9])));                    // valor das parcelas
//                                            sdf.parse(fields[10])));                          //Renovação do plano
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //cria o arquivo se não exister nenhum
            try {
                clientesBD.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Inserção de dados, faltando o tipo
        System.out.println("Informe o tipo de plano (mensal/trimestral)");
        String tipo = sc.next();
        System.out.println();
        System.out.println("Nome:");
        nome = sc.next();
        System.out.println("Cpf"); 
        cpf = sc.next();
        Cliente cliente;
        if(tipo.equals("mensal")){// Por algum motivo, tipo == "mensal" sempre retornava false
             cliente = new Cliente(tipo,nome, cpf, new Date()); //FALTANDO TIPO DE CLIENTE, criar uma função que verifica o tipo
             clientes.put(cpf,cliente);  
        }
        else{
            System.out.println("Deseja pagar o plano à vista? (s|n)");
            char res = sc.next().toLowerCase().charAt(0);//Só pra garantir
            if(res == 's'){
                cliente = new ClienteTrimestral(tipo, nome, cpf, new Date());
            }
            else{
                int parcelas = verificaParcelas(tipo);
                cliente = new ClienteTrimestral(tipo, nome, cpf, new Date(), parcelas);
            }
        }
         clientes.put(cpf, cliente);
         cliente.writeFile(clientesBD);
//        Cliente c = new ClienteTrimestral("normal","normal" , "normal", new Date(), 3);
//        System.out.println(c.getMensalidade());

        for(int i = 0; i < clientes.size(); i++){
            System.out.println(clientes);
        }
        sc.close();
    }
    public static int verificaParcelas(String tipoPlano){
        int maxParcelas;
        int parcelas = -1;
        switch(tipoPlano){
            case "trimestral":
                maxParcelas = 3;
                break;
            case "anual":
                maxParcelas = 12;
                break;
            default:
                System.out.println("Plano inválido"); //placeholder
                return -1;
        }
        while(parcelas <= 0 || parcelas > maxParcelas){
            System.out.println("Em quantas vezes deseja parcelar?");
            parcelas = sc.nextInt();
        }
        return parcelas;
    }
}

