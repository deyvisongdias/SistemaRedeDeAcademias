package Objetos;

import Interfaces.Login;
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

    public static Map<String, Cliente> clientes = new HashMap<>();
    public static Map<String, String> cpfCliente = new HashMap<>();

    public static Map<String, Recepcionista> recepcionista = new HashMap<>();//###
    public static Map<String, Instrutor> instrutor = new HashMap<>();//#####

    public static Map<String, String> funcionarios = new HashMap<>();//usado pra fazer o login
    
    public static void main(String[] args) throws IOException, ParseException {
        int updatedId = 0;
        String sexo;
        File clientesBD = new File("clientes.txt");
        String plano = "";
        String pathCliente = clientesBD.getAbsolutePath();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String nome;
        String cpf = "";

        if (clientesBD.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {
                    String[] fields = line.split("|");
                    try {
                        if (fields.equals("mensal")) {
                            clientes.put(fields[2], //cpf como chave
                                    new Cliente(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]),//matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade       
                                            fields[8], //telefone
                                            fields[9]));//sexo

                        } else if (fields[0].equals("trimestral")) {
                            clientes.put(fields[2], // cpf como chave
                                    new ClienteTrimestral(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]));//sexo

                        } else if (fields[0].equals("semestral")) {
                            clientes.put(fields[2], // cpf como chave
                                    new ClienteSemestral(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]));//sexo

                        } else if (fields[0].equals("anual")) {
                            clientes.put(fields[2], // cpf como chave
                                    new ClienteAnual(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]));//sexo
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cpfCliente.put(fields[1], fields[2]);
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

        ///////////////////////////
        File func = new File("Funcionarios.txt");
        String pathFuncionarios = func.getAbsolutePath();

        if (func.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {

                    String[] f = line.split("|");

                    if (f[6].equals("Instrutor")) {
                        instrutor.put(f[2], new Instrutor(f[0], f[1], f[2], f[3], f[4], f[5]));
                    } else if (f[6].equals("Recepcionista")) {

                        recepcionista.put(f[2], new Recepcionista(f[0], f[1], f[2], f[3], f[4], f[5]));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            try {
                func.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        new Login().setVisible(true);

        ////////////////
//      Inserção de dados
        System.out.println("Informe tipo do plano: (mensal, trimestral, semestral ou anual)");
        plano = sc.next();
        plano = plano.toLowerCase();
        System.out.println();
        System.out.println("Nome:");
        nome = sc.next();
        System.out.println("Cpf");
        cpf = sc.next();
        while (clientes.containsKey(cpf)) {
            System.out.println("O cpf informado já existe, informe outro:");
            cpf = sc.next();
        }
        System.out.println("Telefone");
        String telefone = sc.next();
        Cliente cliente;
        System.out.println("Sexo: ");
        sexo = sc.next();
        if (plano.equals("mensal")) {
            cliente = new Cliente(plano, nome, cpf, new Date(), telefone, sexo);
            clientes.put(cpf, cliente);
        } else {
            if (plano.equals("trimestral")) {
                cliente = new ClienteTrimestral(plano, nome, cpf, new Date(), telefone, sexo);
            } else if (plano.equals("semestral")) {
                cliente = new ClienteSemestral(plano, nome, cpf, new Date(), telefone, sexo);
            } else {
                cliente = new ClienteAnual(plano, nome, cpf, new Date(), telefone, sexo);
            }
        }
        clientes.put(cpf, cliente);
        cliente.writeFile(clientesBD);

        //adicionando na lista de funcionarios
        //criacao recepcionista
        Recepcionista rec;

        nome = sc.next();

        String senha = sc.next();

        cpf = sc.next();

        String data = sc.next();

        sexo = sc.next();
        String contato = sc.next();

        rec = new Recepcionista(nome, senha, cpf, data, sexo, contato);

        recepcionista.put(cpf, rec);//adicionando ao map recepcionisa
        funcionarios.put(cpf, nome);
        rec.writeFile(func);

        //criaçao instrutor
        Instrutor ins;

        System.out.println("Digite o nome :");
        nome = sc.next();
        System.out.println("Digite a senha:");
        senha = sc.next();
        System.out.println("Digite o cpf :");
        cpf = sc.next();
        System.out.println("Digite a data de nascimento(xx/xx/xxxx):");
        data = sc.next();
        System.out.println("Digite o sexo :");
        sexo = sc.next();
        System.out.println("Digite o telefone:");
        contato = sc.next();

        ins = new Instrutor(nome, senha, cpf, data, sexo, contato);

        instrutor.put(cpf, ins);
        funcionarios.put(cpf, nome);
        ins.writeFile(func);

        new Login().setVisible(true);

        sc.close();

    }

    public static int verificaParcelas(String tipoPlano) {
        int maxParcelas;
        int parcelas = -1;
        switch (tipoPlano) {
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
        while (parcelas <= 0 || parcelas > maxParcelas) {
            System.out.println("Em quantas vezes deseja parcelar?");
            parcelas = sc.nextInt();
        }
        return parcelas;
    }
}
