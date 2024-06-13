/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;

import com.mycompany.dao.DaoAdvogados;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import com.mycompany.modelo.ModAdvogados;
import java.sql.ResultSet;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        ));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbListAdvogado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtListAdvogado)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addGap(23, 23, 23))
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

                Cadastro_Advogado cadastro_Advogado = new Cadastro_Advogado();
                cadastro_Advogado.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        // TODO add your handling code here:
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
