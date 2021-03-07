/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 *
 * @author deive
 */
public class Cliente {
     //falta a senha ou vai ser o cpf mesmo
    static int contId = 0; // usado pra achar a ficha 
    
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String tipoPlano;
    private String nome;
    private String cpf;
    private Date dataMatricula;
    private Date vencimento;
    private int id;
    private Boolean statusMatricula;
    private double valorPlano;
    private String telefone;
    private int duracaoPlano;
    private int desconto;
    private String sexo;

    public String getSexo() {
        return sexo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }
    
    //Construtor de um cliente novo
    public Cliente(String tipoPlano,String nome,String cpf, Date dataMatricula, String telefone,String sexo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataMatricula);
        cal.add(Calendar.MONTH, 1);
        this.tipoPlano = tipoPlano;
        this.nome = nome;
        this.cpf = cpf;  
        this.dataMatricula = dataMatricula; 
        this.telefone = telefone;
        vencimento = cal.getTime();
        contId++;
        this.id = contId;
        this.statusMatricula = true;
        valorPlano = 80;
        duracaoPlano = 1;
        desconto = 0;
        this.sexo=sexo;
    }
    
    //Construtor de um cliente já cadastrado
    public Cliente(String tipoPlano,String nome, String cpf, Date dataMatricula,
            Date vencimento, int id, Boolean statusMatricula,double valorPlano, String telefone,String sexo){
        
        
        
        this.tipoPlano = tipoPlano;
        this.nome = nome;
        this.cpf = cpf;
        this.dataMatricula = dataMatricula;
        this.vencimento = vencimento;
        this.id = id;
        this.statusMatricula = statusMatricula;
        this.valorPlano = valorPlano;
        contId = id;
        this.telefone = telefone;
        duracaoPlano = 1;
        desconto = 0;
        this.sexo=sexo;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

//    public String getTelefone() {
//        return telefone;
//    }
//    
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
    public int getDuracaoPlano() {
        return duracaoPlano;
    }

    public void setDuracaoPlano(int duracaoPlano) {
        this.duracaoPlano = duracaoPlano;
    }

//    public String getTipoPlano(){
//        return tipoPlano;
//    }
//    
//    public int getId() {
//        return id;
//    }
//    
//    public String getCpf() {
//        return cpf;
//    }

    public String getDataMatricula() {
        return sdf.format(dataMatricula);
    }
    
    public double getValorPlano() {
        return valorPlano;
    }
    
     public void setValorPlano(double valorPlano){
        this.valorPlano = valorPlano;
    }  
    
    public String getNome() {
        return nome;
    }
//    
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
    
    public Boolean getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(Boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }
      
    public String getVencimento() {
        return sdf.format(vencimento);
    }
    
    public void updateVencimento(){//atualiza data do pagamento
        Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(this.getDataMatricula()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        cal.add(Calendar.MONTH, duracaoPlano);
        vencimento = cal.getTime();
    }
    
    public void writeFile(File file){
        String dados = this.toString();
        String path = file.getAbsolutePath();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))){
            bw.write(dados);
            bw.newLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString(){
        return tipoPlano + "|" + nome + "|" + cpf + "|" + getDataMatricula() + "|" + getVencimento() + "|" + 
               id + "|" + statusMatricula + "|" + this.valorPlano + "|" + telefone+"|"+sexo;
    }
}
