/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;

import com.mycompany.dao.DaoProcesso;
import com.mycompany.modelo.ModAdvogados;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModProcesso;
import com.mycompany.outros.Constantes;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author victor.7455
 */
public class Cadastro_Processo extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro_Processo
     */
    public Cadastro_Processo() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoProcesso daoProcesso = new DaoProcesso();

            int id = daoProcesso.buscarProximoId(); 
            if (id >= 0)
                txtId.setText(String.valueOf(id));
            
            btnCadProc.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluirProc.setVisible(false);
        }else{
            btnCadProc.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluirProc.setVisible(true);
        }
        
        setLocationRelativeTo(null);
        
        txtId.setEnabled(false); 
 

    }
    
        private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModProcesso){
            int id = ((ModProcesso) DadosTemporarios.tempObject).getId();
            
            String numeroprocesso = ((ModProcesso) DadosTemporarios.tempObject).getNumeroDoProcesso();
            String vara = ((ModProcesso) DadosTemporarios.tempObject).getVara();
            String comarca = ((ModProcesso) DadosTemporarios.tempObject).getComarca();
            String dataprotocolo = ((ModProcesso) DadosTemporarios.tempObject).getDataProtocolo();
            String status = ((ModProcesso) DadosTemporarios.tempObject).getStatus();
            int cliente = ((ModProcesso) DadosTemporarios.tempObject).getIdCliente();
            String reu = ((ModProcesso) DadosTemporarios.tempObject).getReu();
            
            
            txtId.setText(String.valueOf(id));
            txtCadNProc.setText(numeroprocesso);
            txtCadVara.setText(vara);
            txtCadCom.setText(comarca);
            txtCadData.setText(String.valueOf(dataprotocolo));
            txtCadStatus.setText(status);
            txtCadCliente.setText(String.valueOf(cliente));
            txtCadReu.setText(reu);
            txtNomeAdvogado.setText(((ModAdvogados) DadosTemporarios.tempObject2).getNome());
            txtCadCliente.setText(((ModCliente) DadosTemporarios.tempObject3).getNome());
            
            DaoProcesso daoProcesso = new DaoProcesso();
            
            ResultSet resultSet = daoProcesso.listarPorID(id);
            
            try{
                txtNomeAdvogado.setText(resultSet.getString("advogado"));
            }catch(SQLException e){
            
            }
            
            try{
                txtCadCliente.setText(resultSet.getString("cliente"));
            }catch(SQLException e){
            
            }
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
        
    private void inserir(){
        DaoProcesso daoProcesso = new DaoProcesso();
        
        if (daoProcesso.inserir(Integer.parseInt(txtId.getText()), Integer.parseInt(txtCadCliente.getText()), Integer.parseInt(txtNomeAdvogado.getText()), txtCadNProc.getText(), txtCadVara.getText(), txtCadCom.getText(), txtCadData.getText(), txtCadStatus.getText(), txtCadReu.getText())){
            JOptionPane.showMessageDialog(null, "Processo salvo com sucesso");
            
            txtId.setText(String.valueOf(daoProcesso.buscarProximoId()));
            txtCadCliente.setText("");
            txtNomeAdvogado.setText("");
            txtCadNProc.setText("");
            txtCadVara.setText("");
            txtCadCom.setText("");
            txtCadData.setText("");
            txtCadStatus.setText("");
            txtCadReu.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o processo");
        }        
    }
    
    private void alterar(){
        DaoProcesso daoprocesso = new DaoProcesso();
        
        if (daoprocesso.alterar(Integer.parseInt(txtId.getText()), Integer.parseInt(txtCadCliente.getText()), Integer.parseInt(txtNomeAdvogado.getText()), txtCadNProc.getText(), txtCadVara.getText(), txtCadCom.getText(), txtCadData.getText(), txtCadStatus.getText(), txtCadReu.getText())){
            JOptionPane.showMessageDialog(null, "Dados do Processo Alterados!");
            
            txtCadCliente.setText("");
            txtNomeAdvogado.setText("");
            txtCadNProc.setText("");
            txtCadVara.setText("");
            txtCadCom.setText("");
            txtCadData.setText("");
            txtCadStatus.setText("");
            txtCadReu.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados do Processo");
        }
        
        ((ListProcesso) Formularios.ListProcesso).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoProcesso daoProcesso = new DaoProcesso();
        
        if (daoProcesso.excluir(Integer.parseInt(txtId.getText()))){
            JOptionPane.showMessageDialog(null, "Processo " + txtCadNProc.getText() + " excluído com sucesso!");
            
            txtCadCliente.setText("");
            txtNomeAdvogado.setText("");
            txtCadNProc.setText("");
            txtCadVara.setText("");
            txtCadCom.setText("");
            txtCadData.setText("");
            txtCadStatus.setText("");
            txtCadReu.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Processo!");
        }
                
        dispose();
    }
    
 
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCadNProc = new javax.swing.JTextField();
        txtCadVara = new javax.swing.JTextField();
        txtCadCom = new javax.swing.JTextField();
        txtCadStatus = new javax.swing.JTextField();
        txtCadReu = new javax.swing.JTextField();
        txtCadData = new javax.swing.JFormattedTextField();
        txtCadCliente = new javax.swing.JTextField();
        btnCadProc = new javax.swing.JButton();
        btnCadReturn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnExcluirProc = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNomeAdvogado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE PROCESSO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Número do processo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Vara");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Comarca");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Data de protocolo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Status");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Cliente");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Réu");

        txtCadNProc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadVara.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCadVara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadVaraActionPerformed(evt);
            }
        });

        txtCadCom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadReu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCadProc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCadProc.setText("CADASTRAR");
        btnCadProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProcActionPerformed(evt);
            }
        });

        btnCadReturn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCadReturn.setText("VOLTAR");
        btnCadReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadReturnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("ID");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnExcluirProc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluirProc.setText("EXCLUIR");
        btnExcluirProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProcActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Advogado");

        txtNomeAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeAdvogadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jLabel1)
                .addGap(252, 322, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadProc)
                .addGap(361, 361, 361))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnExcluirProc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadReturn)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(txtCadVara, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCadNProc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCadReu, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCadStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(txtCadCom, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(67, 67, 67))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadData, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCadNProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCadVara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCadCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addComponent(txtCadData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCadReu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnCadProc)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadReturn)
                    .addComponent(btnExcluirProc))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadReturnActionPerformed
        if (Formularios.Menu == null)
            Formularios.Menu = new Menu();
        
        Formularios.Menu.setVisible(true);
        Formularios.Menu.setExtendedState(JFrame.NORMAL); 
    }//GEN-LAST:event_btnCadReturnActionPerformed

    private void txtCadVaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadVaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadVaraActionPerformed

    private void btnCadProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProcActionPerformed
        DaoProcesso daoProcesso = new DaoProcesso();

        if (btnCadProc.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();

        }else if (btnCadProc.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            dispose();
  
    } 
    }//GEN-LAST:event_btnCadProcActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnExcluirProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProcActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o processo?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();        
    }//GEN-LAST:event_btnExcluirProcActionPerformed

    private void txtNomeAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeAdvogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeAdvogadoActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro_Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Processo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Processo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadProc;
    private javax.swing.JButton btnCadReturn;
    private javax.swing.JButton btnExcluirProc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCadCliente;
    private javax.swing.JTextField txtCadCom;
    private javax.swing.JFormattedTextField txtCadData;
    private javax.swing.JTextField txtCadNProc;
    private javax.swing.JTextField txtCadReu;
    private javax.swing.JTextField txtCadStatus;
    private javax.swing.JTextField txtCadVara;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomeAdvogado;
    // End of variables declaration//GEN-END:variables
}
