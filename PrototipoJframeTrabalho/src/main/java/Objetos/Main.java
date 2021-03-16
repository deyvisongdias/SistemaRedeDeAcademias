package Objetos;

import Interfaces.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static Map<String, Cliente> clientes = new HashMap<>();
    public static Map<String, String> cpfCliente = new HashMap<>();

    public static Map<String, Recepcionista> recepcionista = new HashMap<>();//###
    public static Map<String, Instrutor> instrutor = new HashMap<>();//#####

    public static Map<String, String> funcionarios = new HashMap<>();//usado pra fazer o login

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Administrador m = new Administrador();
        Recepcionista r = new Recepcionista();

        LerTxtFuncionario();
        r.LerTxtCliente();

        new Login().setVisible(true);

    }

    static public void LerTxtFuncionario() {
        File func = new File("Funcionarios.txt");
        String pathFuncionarios = func.getAbsolutePath();

        if (func.exists()) {

            try (BufferedReader br = new BufferedReader(new FileReader(pathFuncionarios))) {
                String line = br.readLine();
                while (line != null) {

                    String[] f = line.split("\\|");

                    if (f[0].equals("Instrutor")) {
                        Instrutor i = new Instrutor(f[1], f[2], f[3], f[4], f[5], f[6]);
                        instrutor.put(f[3], i);
                        Administrador.listaInstru.add(i);

                    } else if (f[0].equals("Recepcionista")) {
                        Recepcionista rr = new Recepcionista(f[1], f[2], f[3], f[4], f[5], f[6]);
                        recepcionista.put(f[3], rr);
                        Administrador.listaRece.add(rr);
                    }

                    line = br.readLine();
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
