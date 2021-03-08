package com.mycompany.trabalhooo;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.calendar.CalendarUtils;

public class Recepcionista implements Pagamento {

    Scanner sc = new Scanner(System.in);

    //identificaçao
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String nome;
    private String senha;

    List<Cliente> lista = new ArrayList<>();

    //construtores
    public Recepcionista(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Recepcionista() {
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
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
                double d = cliente.getValorPlano() - (cliente.getValorPlano() * 0,
                05);
                cliente.setValorParcelado(d / i);

                cliente.updateVencimento();

            }
        }
        if (cliente.getTipoPlano() == "Semestral" || cliente.getTipoPlano() == "semestral") {

            if (cliente.getNumeroParcelas() == 0) {
                System.out.println("Digite o numero de parcelas para pagamento (no maximo 4):");
                int i = sc.nextInt();
                cliente.setNumeroParcelas(i);
                double d1 = cliente.getValorPlano() - (cliente.getValorPlano() * 0,
                10);
                cliente.setValorParcelado(d1 / i);

                cliente.updateVencimento();

            }

        }

        if (cliente.getTipoPlano() == "Anual" || cliente.getTipoPlano() == "anual") {

            if (cliente.getNumeroParcelas() == 0) {
                System.out.println("Digite o numero de parcelas para pagamento (no maximo 6):");
                int i = sc.nextInt();
                cliente.setNumeroParcelas(i);
                double d2 = cliente.getValorPlano() - (cliente.getValorPlano() * 0, 15);
                cliente.setValorParcelado(d2 / i);

                cliente.updateVencimento();

            }

        }
    }

}
