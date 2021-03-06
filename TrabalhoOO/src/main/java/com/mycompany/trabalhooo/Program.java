package com.mycompany.trabalhooo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    private static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        int updatedId = 0;
        File clientesBD = new File("clientes.txt");
        String plano = "";
        String pathCliente = clientesBD.getAbsolutePath();
        Map<String, Cliente> clientes = new HashMap<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String nome;
        String cpf = "";
        
        if (clientesBD.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {
                    String[] fields = line.split("|");
                    try {
                        if (fields[0] == "1") {
                            clientes.put(fields[2],                                            //cpf como chave
                                    new Cliente(fields[0],                                     //tipo plano
                                            fields[1],                                         //nome
                                            fields[2],                                         //cpf
                                            sdf.parse(fields[3]),                              //matrícula
                                            sdf.parse(fields[4]),                              //vencimento
                                            Integer.parseInt(fields[5]),                       //id
                                            Boolean.parseBoolean(fields[6]),                   //status pagamento
                                            Double.parseDouble(fields[7]),                     //mensalidade       
                                            fields[8]));                                       //telefone
                            
                        } else if (fields[0].equals("trimestral")) {
                            clientes.put(fields[2],                                             // cpf como chave
                                    new ClienteTrimestral(fields[0],                            //tipo plano
                                            fields[1],                                          //nome
                                            fields[2],                                          //cpf
                                            sdf.parse(fields[3]),                               //matrícula
                                            sdf.parse(fields[4]),                               //vencimento
                                            Integer.parseInt(fields[5]),                        //id
                                            Boolean.parseBoolean(fields[6]),                    //status pagamento
                                            Double.parseDouble(fields[7]),                      //mensalidade    
                                            fields[8]));                                        //telefone

                        }
                        else if(fields[0].equals("semestral")){
                            clientes.put(fields[2],                                             // cpf como chave
                                            new ClienteSemestral(fields[0],                     //tipo plano
                                            fields[1],                                          //nome
                                            fields[2],                                          //cpf
                                            sdf.parse(fields[3]),                               //matrícula
                                            sdf.parse(fields[4]),                               //vencimento
                                            Integer.parseInt(fields[5]),                        //id
                                            Boolean.parseBoolean(fields[6]),                    //status pagamento
                                            Double.parseDouble(fields[7]),                      //mensalidade    
                                            fields[8]));                                        //telefone
                                                                               
                        }
                        else if(fields[0].equals("anual")){
                            clientes.put(fields[2],                                             // cpf como chave
                                    new ClienteAnual(fields[0],                                 //tipo plano
                                            fields[1],                                          //nome
                                            fields[2],                                          //cpf
                                            sdf.parse(fields[3]),                               //matrícula
                                            sdf.parse(fields[4]),                               //vencimento
                                            Integer.parseInt(fields[5]),                        //id
                                            Boolean.parseBoolean(fields[6]),                    //status pagamento
                                            Double.parseDouble(fields[7]),                      //mensalidade    
                                            fields[8]));                                        //telefone
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Cliente.contId++;
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
        
//      Inserção de dados
        System.out.println("Informe tipo do plano: (mensal, trimestral, semestral ou anual)");
        plano = sc.next();
        plano = plano.toLowerCase();
        System.out.println();
        System.out.println("Nome:");
        nome = sc.next();
        System.out.println("Cpf"); 
        cpf = sc.next();
        while(clientes.containsKey(cpf)){
           System.out.println("O cpf informado já existe, informe outro:"); 
           cpf = sc.next(); 
        }
        System.out.println("Telefone"); 
        String telefone = sc.next();
        Cliente cliente;         
        if(plano.equals("mensal")){
             cliente = new Cliente(plano,nome, cpf, new Date(),telefone); 
             clientes.put(cpf,cliente);
        }
        else{
             if(plano.equals("trimestral")){
                cliente = new ClienteTrimestral(plano, nome, cpf, new Date(),telefone);
            }
            else if(plano.equals("semestral")){
                cliente = new ClienteSemestral(plano, nome, cpf, new Date(),telefone);
            }
            else {
                cliente = new ClienteAnual(plano, nome, cpf, new Date(),telefone);
            }
        }
     
         clientes.put(cpf, cliente);
         cliente.writeFile(clientesBD);
         
         
        sc.close();
    }
    public static int verificaParcelas(String tipoPlano){
        int maxParcelas;
        int parcelas = -1;
        switch(tipoPlano){
            case "trimestral":
                maxParcelas = 3;
                break;
            case "semestral":
                maxParcelas = 6;
                break;
            default:
                maxParcelas = 12;
                break;
        }
        while(parcelas <= 0 || parcelas > maxParcelas){
            System.out.println("Em quantas vezes deseja parcelar?");
            parcelas = sc.nextInt();
        }
        return parcelas;
    }
}
