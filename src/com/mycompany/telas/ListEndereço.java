/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import com.mycompany.modelo.ModEndereco;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author victor.7455
 */
public class ListEndereço extends javax.swing.JFrame {

    /**
     * Creates new form ListCliente
     */
    public ListEndereço() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
    }
    
        public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void listarPorId(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorId(Integer.parseInt(txtListEnd.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        public void listarPorRua(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorRua(txtListEnd.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    

    
    public void listarPorBairro(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorBairro(txtListEnd.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        public void listarPorCidade(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorcidade(txtListEnd.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorUf(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorEstado(txtListEnd.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorCep(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListEnd.getModel();
            
            tblListEnd.setModel(defaultTableModel);

            DaoEndereco daoEndereco = new DaoEndereco();

            ResultSet resultSet = daoEndereco.listarPorCEP(txtListEnd.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String rua = resultSet.getString(2);
                String numero = resultSet.getString(3);
                String bairro = resultSet.getString(4);
                String cidade = resultSet.getString(5);
                String uf = resultSet.getString(6);
                String cep = resultSet.getString(7);

                
                defaultTableModel.addRow(new Object[]{id, rua, numero, bairro, cidade, uf, cep});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbListEnd = new javax.swing.JComboBox<>();
        txtListEnd = new javax.swing.JTextField();
        btnFiltrarEnd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListEnd = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbListEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "Id", "Rua", "Bairro", "Cidade", "UF", "CEP" }));
        cmbListEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListEndActionPerformed(evt);
            }
        });

        txtListEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListEndActionPerformed(evt);
            }
        });

        btnFiltrarEnd.setText("FILTRAR");

        tblListEnd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Rua", "nº", "Bairro", "Cidade", "UF", "CEP"
            }
        ));
        tblListEnd.setColumnSelectionAllowed(true);
        tblListEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListEndMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListEnd);
        tblListEnd.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblListEnd.getColumnModel().getColumnCount() > 0) {
            tblListEnd.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblListEnd.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblListEnd.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblListEnd.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblListEnd.getColumnModel().getColumn(5).setPreferredWidth(1);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbListEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtListEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrarEnd)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtListEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrarEnd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addContainerGap())
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

    private void cmbListEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbListEndActionPerformed

    private void txtListEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListEndActionPerformed
        
        switch (cmbListEnd.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId();
                break;
            case 2:
                listarPorRua();
                break;
            case 3:
                listarPorBairro();
                break;
            case 4:
                listarPorCidade();
                break;
            case 5:
                listarPorUf();
                break;
    }                                          

    }//GEN-LAST:event_txtListEndActionPerformed

    private void tblListEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListEndMouseClicked
        try{
            if (evt.getClickCount() == 2){
                ModEndereco modEndereco = new ModEndereco();

                modEndereco.setId(Integer.parseInt(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 0))));
                modEndereco.setRua(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 1)));
                modEndereco.setNumero(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 2)));
                modEndereco.setBairro(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 3)));
                modEndereco.setCidade(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 4)));
                modEndereco.setEstado(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 5)));
                modEndereco.setCep(String.valueOf(tblListEnd.getValueAt(tblListEnd.getSelectedRow(), 6)));
                
                
                DadosTemporarios.tempObject = (ModEndereco) modEndereco;

                Cadastro_Advogado cadastro_Advogado = new Cadastro_Advogado();
                cadastro_Advogado.setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
  
    }       
    }//GEN-LAST:event_tblListEndMouseClicked

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
            java.util.logging.Logger.getLogger(ListEndereço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEndereço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEndereço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEndereço.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEndereço().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrarEnd;
    private javax.swing.JComboBox<String> cmbListEnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListEnd;
    private javax.swing.JTextField txtListEnd;
    // End of variables declaration//GEN-END:variables
}
