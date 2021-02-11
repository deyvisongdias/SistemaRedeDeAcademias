package com.mycompany.caixadedialogo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author deive
 */

public class main {

    public static void main(String[] args) {
        String entrada;
        int num = Integer.parseInt(JOptionPane.showInputDialog("Um numero"));
        float num1 = Float.parseFloat(JOptionPane.showInputDialog("Um numero"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Um numero"));
        
        entrada = JOptionPane.showInputDialog("Digite algo");
        
        JOptionPane.showMessageDialog(null, "sua mensagem é -> " + entrada);
        JOptionPane.showMessageDialog(null, "seu inteiro é -> " + num);
        JOptionPane.showMessageDialog(null, "seu float é -> " + num1);
        JOptionPane.showMessageDialog(null, "seu double é -> " + num2);
    }
}
