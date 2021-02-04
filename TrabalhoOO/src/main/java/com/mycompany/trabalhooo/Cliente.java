package com.mycompany.trabalhooo;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author deive
 */
public abstract class Cliente {

    static int contId = 0; // Vai ser usada pra aachar a ficha
    static int contMatriculas = 0; //  Ativas

    private int id;
    private String cpf;
    private String nome;
    private String tipoDePlano;
    private Ficha ficha;
    private Date dataMatricula;
    private Date nascimento;
    private Date vencimento;
    private Boolean statusMatricula;
    private double mensalidade;

    //Pagamento
    // arrumar implementaçao pra 
    public Cliente() {
    }// Incrementar 

}
