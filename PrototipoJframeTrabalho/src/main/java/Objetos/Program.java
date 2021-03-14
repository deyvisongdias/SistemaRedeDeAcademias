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
         

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        
        Recepcionista r=new Recepcionista();
        Instrutor i=new Instrutor();
        Cliente c=new Cliente();
        
        for (String key : clientes.keySet()) {       
            c=clientes.get(key);     
            c.writeFile();
        }
      
        for (String key : funcionarios.keySet()) {       
            r=recepcionista.get(key);     
             if(r.getNome()!=null)
            {
            r.writeFile();
            }
            }
           
        }
        
        for (String key : instrutor.keySet()) {       
            i=instrutor.get(key); 
            if(i.getNome()!=null)
            {
            i.writeFile();
            }
            }
            
        new Login().setVisible(true);
        
        
       

        
    }
    
    
    
    
    
    
    public void LeTxtFuncionario()
    {
        File func = new File("Funcionarios.txt");
        String pathFuncionarios = func.getAbsolutePath();

        if (func.exists()) {
            String pathCliente;
            try (BufferedReader br = new BufferedReader(new FileReader(pathFuncionarios))) {
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
