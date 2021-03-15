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
import static Objetos.Administrador.listaRece;
import static Objetos.Program.clientes;
import static Objetos.Program.cpfCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Recepcionista implements Pagamento {

    static Scanner sc = new Scanner(System.in);
    
    public static File clientesBD = new File("clientes.txt");
    public static String pathCliente = clientesBD.getAbsolutePath();

    //identificaçao
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;
    private String senha;
    private String cpf;
    private String data;
    private String sexo;
    private String contato;

    static public List<Cliente> lista = new ArrayList<>();//achar a implementaçao;

    //construtores
    public Recepcionista(String nome, String senha, String cpf, String data, String sexo, String contato) {
        System.out.println("!!!!!!!!!!!!!!");
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.data = data;
        this.sexo = sexo;
        this.contato = contato;
      
    }

    public Recepcionista() {
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

    static public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public void setnull() {
        this.nome = null;
        this.senha = null;
        this.cpf = null;
        this.data = null;
        this.sexo = null;
        this.contato = null;

    }

    //implementaçao metodos interface
    /**
     *
     * @param cliente
     * @throws ParseException
     */
    public double retornaValorPagamento(Cliente cliente) {
        return cliente.getValorPlano();

    }

    /**
     *
     * @param cliente
     */
    @Override
    public void pagar(Cliente cliente) {

        if (cliente.getTipoPlano() == "Mensal" || cliente.getTipoPlano() == "mensal") {
            System.out.println("Forma de pagamento a vista ");
            //confirmar o pagamento do cliente
            cliente.updateVencimento();

        }

        if (cliente.getTipoPlano() == "Trimestral" || cliente.getTipoPlano() == "trimestral") {
            if (cliente.getNumeroParcelas() == 0) {
                System.out.println("Digite o numero de parcelas para pagamento :");
                int i = sc.nextInt();
                cliente.setNumeroParcelas(i);
                double d = cliente.getValorPlano() - (cliente.getValorPlano() * 0.05);
                cliente.setValorParcela(d / i);

                cliente.updateVencimento();

            }
        }
        if (cliente.getTipoPlano() == "Semestral" || cliente.getTipoPlano() == "semestral") {

            if (cliente.getNumeroParcelas() == 0) {
                System.out.println("Digite o numero de parcelas para pagamento (no maximo 4):");
                int i = sc.nextInt();
                cliente.setNumeroParcelas(i);
                double d1 = cliente.getValorPlano() - (cliente.getValorPlano() * 0.10);
                cliente.setValorParcela(d1 / i);

                cliente.updateVencimento();

            }

        }

        if (cliente.getTipoPlano() == "Anual" || cliente.getTipoPlano() == "anual") {

            if (cliente.getNumeroParcelas() == 0) {
                System.out.println("Digite o numero de parcelas para pagamento (no maximo 6):");
                int i = sc.nextInt();
                cliente.setNumeroParcelas(i);
                double d2 = cliente.getValorPlano() - (cliente.getValorPlano() * 0.15);
                cliente.setValorParcela(d2 / i);

                cliente.updateVencimento();

            }

        }
    }

    
    public void writeFile() {
        String dados = this.coverteEMString();
        String path =Administrador.func.getAbsolutePath();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(dados);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public  void LerTxtCliente()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
        
         if (clientesBD.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(pathCliente))) {
                String line = br.readLine();
                while (line != null) {
                    String[] fields = line.split("|");
                    try {
                        if (fields.equals("mensal")) {
                            Cliente c=new Cliente(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]),//matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade       
                                            fields[8], //telefone
                                            fields[9]);//sexo
                            clientes.put(fields[2], c);
                                    

                        } else if (fields[0].equals("trimestral")) {
                            Cliente c= new ClienteTrimestral(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]);
                            clientes.put(fields[2],c); // cpf como chave
                                    //sexo

                        } else if (fields[0].equals("semestral")) {
                            Cliente c= new ClienteSemestral(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]);//sexo
                            
                            clientes.put(fields[2],c); // cpf como chave
                                   

                        } else if (fields[0].equals("anual")) {
                            Cliente c= new ClienteAnual(fields[0], //tipo plano
                                            fields[1], //nome
                                            fields[2], //cpf
                                            sdf.parse(fields[3]), //matrícula
                                            sdf.parse(fields[4]), //vencimento
                                            Integer.parseInt(fields[5]), //id
                                            Boolean.parseBoolean(fields[6]), //status pagamento
                                            Double.parseDouble(fields[7]), //mensalidade    
                                            fields[8], //telefone
                                            fields[9]);//sexo
                            
                            clientes.put(fields[2],c); // cpf como chave
                                   
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
    }

  
    public String coverteEMString()
    {
        return ("Recepcionista"+"|"+getNome()+"|"+getSenha()+"|"+getCpf()+"|"+getData()+"|"+getSexo()+"|"+getContato());
    }

}
