/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Objetos.Cliente;
import Objetos.Ficha;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deive
 */
public class CriarFicha extends javax.swing.JFrame {

    /**
     * Creates new form CriarFicha
     */
    public CriarFicha() {
        initComponents();
       this.ficha = (DefaultTableModel) jtableFicha.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtExr = new javax.swing.JTextField();
        jbAdcionar = new javax.swing.JButton();
        JcbAp = new javax.swing.JComboBox<>();
        jbApagar = new javax.swing.JButton();
        jBAtt = new javax.swing.JButton();
        jSerieRep = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableFicha = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("cadastra na ficha"));

        jLabel10.setText("#aparelho");

        jLabel11.setText("Exercicio:");

        jLabel12.setText("Series/Repetiçao:");

        jbAdcionar.setText("Adicionar");
        jbAdcionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdcionarActionPerformed(evt);
            }
        });

        JcbAp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        jbApagar.setText("Apagar");
        jbApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApagarActionPerformed(evt);
            }
        });

        jBAtt.setText("Atualizar");
        jBAtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAttActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JcbAp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jtxtExr, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBAtt)
                        .addGap(31, 31, 31)
                        .addComponent(jbApagar)
                        .addGap(32, 32, 32)
                        .addComponent(jbAdcionar)))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSerieRep))
                    .addComponent(jButton1))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JcbAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtExr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSerieRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAdcionar)
                            .addComponent(jbApagar)
                            .addComponent(jBAtt)
                            .addComponent(jButton1))
                        .addGap(44, 44, 44))))
        );

        jtableFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Aparelho", "Exercicio", "Séries/Rep", "Carga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableFichaMouseClicked(evt);
            }
        });
        jtableFicha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtableFichaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtableFichaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtableFicha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void preencher(File file) {

    }
    private Cliente cliente;

    private Object[] ConverteString(String st) {
        Object[] dados = st.split(";");
        return dados;
    }
    private  DefaultTableModel ficha = null;

    public void PreencherFicha(Cliente cliente) throws IOException {
        this.cliente = cliente;
        Ficha fichA = new Ficha(this.cliente.getCpf());
        List<String> lista = new LinkedList<>();

        for (Object[] l : fichA.addTabela()) {
            ficha.addRow(l);

        }

    }// colocar esse metodo na janela de cliente tbm

    private void jbAdcionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdcionarActionPerformed
        DefaultTableModel ficha = (DefaultTableModel) jtableFicha.getModel();
        Object[] dados = {JcbAp.getSelectedItem(), jtxtExr.getText(), jSerieRep.getText(), "___"};
        ficha.addRow(dados);

        JcbAp.setSelectedIndex(0);
        jtxtExr.setText(null);
        jSerieRep.setText(null);

    }//GEN-LAST:event_jbAdcionarActionPerformed


    private void jbApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApagarActionPerformed
        if (jtableFicha.getSelectedRow() != -1) {
            ficha.removeRow(jtableFicha.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir");
        }

    }//GEN-LAST:event_jbApagarActionPerformed

    private void jBAttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAttActionPerformed

        if (jtableFicha.getSelectedRow() != -1) {
            jtableFicha.setValueAt(JcbAp.getSelectedItem(), jtableFicha.getSelectedRow(), 0);
            jtableFicha.setValueAt(jtxtExr.getText(), jtableFicha.getSelectedRow(), 1);
            jtableFicha.setValueAt(jSerieRep.getText(), jtableFicha.getSelectedRow(), 2);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha para alterar");
        }

    }//GEN-LAST:event_jBAttActionPerformed

    private void jtableFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableFichaMouseClicked
        if (jtableFicha.getSelectedRow() != -1) {
            JcbAp.setSelectedItem(ficha.getValueAt(jtableFicha.getSelectedRow(), 0));
            jtxtExr.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 1));
            jSerieRep.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 2));
        }


    }//GEN-LAST:event_jtableFichaMouseClicked

    private void jtableFichaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableFichaKeyPressed
        // TODO add your handling code here:
         if (jtableFicha.getSelectedRow() != -1) {
            JcbAp.setSelectedItem(ficha.getValueAt(jtableFicha.getSelectedRow(), 0));
            jtxtExr.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 1));
            jSerieRep.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 2));
        }
    }//GEN-LAST:event_jtableFichaKeyPressed

    private void jtableFichaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableFichaKeyReleased
        if (jtableFicha.getSelectedRow() != -1) {
            JcbAp.setSelectedItem(ficha.getValueAt(jtableFicha.getSelectedRow(), 0));
            jtxtExr.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 1));
            jSerieRep.setText((String) ficha.getValueAt(jtableFicha.getSelectedRow(), 2));
        }
    }//GEN-LAST:event_jtableFichaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] options = {"Sim", "Nao"};
        if ((JOptionPane.showOptionDialog(this, "Sair e salvar?", "Salvar e sair", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0)) {
            try {
                List<String> lista = new LinkedList();
                for (int i = 0; i < ficha.getRowCount(); i++) {
                    String dados = ficha.getValueAt(i, 0) + ";" + ficha.getValueAt(i, 1) + ";"
                            + ficha.getValueAt(i, 2) + ";" + ficha.getValueAt(i, 3);
                    lista.add(dados);
                }

                Ficha ficha = new Ficha(this.cliente.getCpf());
                ficha.addArquivo(lista);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(CriarFicha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CriarFicha().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbAp;
    private javax.swing.JButton jBAtt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSerieRep;
    private javax.swing.JButton jbAdcionar;
    private javax.swing.JButton jbApagar;
    private javax.swing.JTable jtableFicha;
    private javax.swing.JTextField jtxtExr;
    // End of variables declaration//GEN-END:variables
}
