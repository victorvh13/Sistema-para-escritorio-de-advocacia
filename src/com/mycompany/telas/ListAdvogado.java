/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;

import com.mycompany.dao.DaoAdvogados;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import com.mycompany.modelo.ModAdvogados;
import com.mycompany.modelo.ModEndereco;
import com.mycompany.outros.Constantes;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author victor.7455
 */
public class ListAdvogado extends javax.swing.JFrame {

    /**
     * Creates new form ListAdvogado
     */
    public ListAdvogado() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
    public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListAdvogado.getModel();
            
            tblListAdvogado.setModel(defaultTableModel);

            DaoAdvogados daoAdvogados = new DaoAdvogados();

            ResultSet resultSet = daoAdvogados.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String OAB = resultSet.getString(3);
                String UF = resultSet.getString(4);

                
                defaultTableModel.addRow(new Object[]{id, nome, OAB, UF});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListAdvogado.getModel();
            
            tblListAdvogado.setModel(defaultTableModel);

            DaoAdvogados daoAdvogados = new DaoAdvogados();

            ResultSet resultSet = daoAdvogados.listarPorId(Integer.parseInt(txtListAdvogado.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String OAB = resultSet.getString(3);
                String UF = resultSet.getString(4);

                defaultTableModel.addRow(new Object[]{id, nome, OAB, UF});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorNome(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListAdvogado.getModel();
            
            tblListAdvogado.setModel(defaultTableModel);

            DaoAdvogados daoAdvogados = new DaoAdvogados();

            ResultSet resultSet = daoAdvogados.listarPorNome(txtListAdvogado.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String OAB = resultSet.getString(3);
                String UF = resultSet.getString(4);

                
                defaultTableModel.addRow(new Object[]{id, nome, OAB, UF});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorOab(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListAdvogado.getModel();
            
            tblListAdvogado.setModel(defaultTableModel);

            DaoAdvogados daoAdvogados = new DaoAdvogados();

            ResultSet resultSet = daoAdvogados.listarPorOab(txtListAdvogado.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String OAB = resultSet.getString(3);
                String UF = resultSet.getString(4);

                
                defaultTableModel.addRow(new Object[]{id, nome, OAB, UF});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUF(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListAdvogado.getModel();
            
            tblListAdvogado.setModel(defaultTableModel);

            DaoAdvogados daoAdvogados = new DaoAdvogados();

            ResultSet resultSet = daoAdvogados.listarPorUf(txtListAdvogado.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String OAB = resultSet.getString(3);
                String UF = resultSet.getString(4);

                
                defaultTableModel.addRow(new Object[]{id, nome, OAB, UF});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListAdvogado = new javax.swing.JTable();
        cmbListAdvogado = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        txtListAdvogado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblListAdvogado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "OAB", "UF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListAdvogado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListAdvogadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListAdvogado);

        cmbListAdvogado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "Nome", "OAB", "UF" }));
        cmbListAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListAdvogadoActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        txtListAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListAdvogadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbListAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtListAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtListAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtListAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListAdvogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtListAdvogadoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        switch (cmbListAdvogado.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId();
                break;
            case 2:
                listarPorNome();
                break;
            case 3:
                listarPorOab();
                break;
            case 4:
                listarPorUF();
                break;
    }//GEN-LAST:event_btnFiltrarActionPerformed
    }

    
    private void tblListAdvogadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListAdvogadoMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModAdvogados modAdvogados = new ModAdvogados();

                modAdvogados.setId(Integer.parseInt(String.valueOf(tblListAdvogado.getValueAt(tblListAdvogado.getSelectedRow(), 0))));
                modAdvogados.setNome(String.valueOf(tblListAdvogado.getValueAt(tblListAdvogado.getSelectedRow(), 1)));
                modAdvogados.setOab(String.valueOf(tblListAdvogado.getValueAt(tblListAdvogado.getSelectedRow(), 2)));
                modAdvogados.setUf(String.valueOf(tblListAdvogado.getValueAt(tblListAdvogado.getSelectedRow(), 3)));
                
                
                DadosTemporarios.tempObject = (ModAdvogados) modAdvogados;

                if(!Constantes.novoProcesso && Formularios.Cadastro_Processo == null){
                    Cadastro_Advogado cadastro_Advogado = new Cadastro_Advogado();
                    cadastro_Advogado.setVisible(true);
                }else{
                    ((Cadastro_Processo) Formularios.Cadastro_Processo).setVisible(true);
                    ((Cadastro_Processo) Formularios.Cadastro_Processo).existeDadosTemporarios();
                }
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        
//            DadosTemporarios.tempObject = modAdvogados;
//           
//           
//         
//            ModAdvogados modAdvogados = new ModAdvogados();
//            
//            DaoAdvogados daoAdvogados = new DaoAdvogados();
//            
//            ResultSet resultSetadvogados = daoAdvogados.listarPorId();
//            
//            try{
//                if(resultSetadvogados.next()){
//                    modAdvogados.setId(resultSetadvogados.getInt("ID"));
//                    modAdvogados.setNome(resultSetadvogados.getString("NOME"));
//                    modAdvogados.setNome(resultSetadvogados.getString("OAB"));
//                    modAdvogados.setUf(resultSetadvogados.getString("UF"));
//
//                }
//            }catch(SQLException e){
//                e.printStackTrace();
//            }
//            
//            DadosTemporarios.tempObject2 = modAdvogados;
//            
//            if(Formularios.Cadastro_Processo != null && !Constantes.novoProcesso){
//                JOptionPane.showMessageDialog(null, "Já existe um formulário de processo aberto. Feche-o para continuar.");
//                ((Cadastro_Processo) Formularios.Cadastro_Processo).setVisible(true);
//                return;
//            }
//            
//            if(!Constantes.novoProcesso){
//                Formularios.Cadastro_Advogado = new Cadastro_Cliente();
//                Formularios.Cadastro_Advogado.setVisible(true);
//            }else{
//                ((Cadastro_Processo) Formularios.Cadastro_Processo).setVisible(true);
//                ((Cadastro_Processo) Formularios.Cadastro_Processo).existeDadosTemporarios();
//            }
    }//GEN-LAST:event_tblListAdvogadoMouseClicked

    private void cmbListAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListAdvogadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbListAdvogadoActionPerformed

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
            java.util.logging.Logger.getLogger(ListAdvogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListAdvogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListAdvogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListAdvogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListAdvogado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbListAdvogado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListAdvogado;
    private javax.swing.JTextField txtListAdvogado;
    // End of variables declaration//GEN-END:variables
}
