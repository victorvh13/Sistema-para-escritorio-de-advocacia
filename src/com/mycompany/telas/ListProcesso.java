/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;

import com.mycompany.dao.DaoAdvogados;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoProcesso;
import com.mycompany.modelo.ModAdvogados;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModProcesso;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victor.7455
 */
public class ListProcesso extends javax.swing.JFrame {

    /**
     * Creates new form ListCliente
     */
    public ListProcesso() {
        initComponents();
  
        setLocationRelativeTo(null);
        
        listarTodos();
  
        jPanelExtra.setVisible(false);
    }

        public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblProc.getModel();
            
            tblProc.setModel(defaultTableModel);

            DaoProcesso daoProcesso = new DaoProcesso();

            ResultSet resultSet = daoProcesso.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cliente = resultSet.getString(2);
                String advogado = resultSet.getString(3);
                String numeroprocesso = resultSet.getString(4);
                String dadosprocesso = resultSet.getString(5);

                
                defaultTableModel.addRow(new Object[]{id, cliente,advogado, numeroprocesso,dadosprocesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        public void listarPorCliente(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblProc.getModel();
            
            tblProc.setModel(defaultTableModel);

            DaoProcesso daoProcesso = new DaoProcesso();

            ResultSet resultSet = daoProcesso.listarPorIdCliente(Integer.parseInt(txtFiltrarProc.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cliente = resultSet.getString(2);
                String advogado = resultSet.getString(3);
                String numeroprocesso = resultSet.getString(4);
                String dadosprocesso = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, cliente,advogado, numeroprocesso,dadosprocesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        public void listarPorAdv(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblProc.getModel();
            
            tblProc.setModel(defaultTableModel);

            DaoProcesso daoProcesso = new DaoProcesso();

            ResultSet resultSet = daoProcesso.listarPorIdAdvogados(Integer.parseInt(txtFiltrarProc.getText()));
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cliente = resultSet.getString(2);
                String advogado = resultSet.getString(3);
                String numeroprocesso = resultSet.getString(4);
                String dadosprocesso = resultSet.getString(5);

                
                defaultTableModel.addRow(new Object[]{id, cliente,advogado, numeroprocesso,dadosprocesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        public void listarPorNumeroDoProcesso(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblProc.getModel();
            
            tblProc.setModel(defaultTableModel);

            DaoProcesso daoProcesso = new DaoProcesso();

            ResultSet resultSet = daoProcesso.listarPorNumeroDoProcesso(txtFiltrarProc.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cliente = resultSet.getString(2);
                String advogado = resultSet.getString(3);
                String numeroprocesso = resultSet.getString(4);
                String dadosprocesso = resultSet.getString(5);

                
                defaultTableModel.addRow(new Object[]{id, cliente,advogado, numeroprocesso,dadosprocesso});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        cmbProc = new javax.swing.JComboBox<>();
        txtFiltrarProc = new javax.swing.JTextField();
        btnFiltrarProc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProc = new javax.swing.JTable();
        jPanelExtra = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vara = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comarca = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        reu = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dataprotocolo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        numero1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbProc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "Cliente", "Advogado", "Número do processo", "Dados do processo" }));
        cmbProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProcActionPerformed(evt);
            }
        });

        txtFiltrarProc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltrarProcActionPerformed(evt);
            }
        });

        btnFiltrarProc.setText("FILTRAR");

        tblProc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Advogado", "Número do processo", "Dados do processo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProc.setColumnSelectionAllowed(true);
        tblProc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProc);
        tblProc.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblProc.getColumnModel().getColumnCount() > 0) {
            tblProc.getColumnModel().getColumn(0).setMaxWidth(40);
            tblProc.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblProc.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblProc.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblProc.getColumnModel().getColumn(4).setPreferredWidth(1);
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
                        .addComponent(cmbProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFiltrarProc, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrarProc)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltrarProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrarProc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelExtra.setBackground(new java.awt.Color(153, 153, 153));
        jPanelExtra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Vara:");

        vara.setText("jLabel2");

        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Comarca:");

        comarca.setText("jLabel2");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Status:");

        status.setText("jLabel2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Réu:");

        reu.setText("jLabel2");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Data de protocolo:");

        dataprotocolo.setText("jLabel2");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanelExtraLayout = new javax.swing.GroupLayout(jPanelExtra);
        jPanelExtra.setLayout(jPanelExtraLayout);
        jPanelExtraLayout.setHorizontalGroup(
            jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelExtraLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanelExtraLayout.createSequentialGroup()
                        .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vara))
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comarca))
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status))
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reu))
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataprotocolo))
                            .addGroup(jPanelExtraLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numero1)))
                        .addGap(0, 263, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelExtraLayout.setVerticalGroup(
            jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExtraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(23, 23, 23)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vara))
                .addGap(18, 18, 18)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comarca))
                .addGap(18, 18, 18)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(status))
                .addGap(18, 18, 18)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(reu))
                .addGap(18, 18, 18)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dataprotocolo))
                .addGap(18, 18, 18)
                .addGroup(jPanelExtraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(numero1))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelExtra, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(270, 270, 270)
                    .addComponent(jPanelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(179, 179, 179)
                    .addComponent(jPanelExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProcActionPerformed

    private void txtFiltrarProcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltrarProcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltrarProcActionPerformed

    private void tblProcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProcMouseClicked
        if((evt.getButton() == MouseEvent.BUTTON1) && (evt.getClickCount() == 2)){
            int linhaClicada = tblProc.rowAtPoint(evt.getPoint());
            
            int idProcesso = Integer.parseInt(String.valueOf(tblProc.getValueAt(linhaClicada, 0)));
            

            ModProcesso modProcesso = new ModProcesso();
            ModAdvogados modAdvogados = new ModAdvogados();
            ModCliente modCliente = new ModCliente();
            
            DaoProcesso daoProcesso = new DaoProcesso();
            
            ResultSet resultSetProcesso = daoProcesso.listarPorID(idProcesso);
            
//            int idProcesso = -1;
            try{
                if(resultSetProcesso.next()){
                    modProcesso.setId(resultSetProcesso.getInt("ID"));
                    modProcesso.setIdCliente(resultSetProcesso.getInt("Id_cliente"));
                    modProcesso.setIdAdvogados(resultSetProcesso.getInt("ID_ADVOGADOs"));
                    modProcesso.setNumeroDoProcesso(resultSetProcesso.getString("NUMERO_DO_PROCESSO"));
                    modProcesso.setVara(resultSetProcesso.getString("VARA"));
                    modProcesso.setComarca(resultSetProcesso.getString("COMARCA"));
                    modProcesso.setDataProtocolo(resultSetProcesso.getString("DATA_PROTOCOLO"));
                    modProcesso.setStatus(resultSetProcesso.getString("COMARCA"));
                    modProcesso.setReu(resultSetProcesso.getString("REU"));
                    
                    idProcesso = resultSetProcesso.getInt("id");
                    
                    modAdvogados.setNome(resultSetProcesso.getString("advogado"));
                    modCliente.setNome(resultSetProcesso.getString("cliente"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            DadosTemporarios.tempObject = modProcesso;
            DadosTemporarios.tempObject2 = modAdvogados;
            DadosTemporarios.tempObject3 = modCliente;
            
            
            Formularios.Cadastro_Processo = new Cadastro_Processo();
            Formularios.Cadastro_Processo.setVisible(true);
            //Obtendo dados do endereço
            /*ModEndereco modEndereco = new ModEndereco();
            
            DaoEndereco daoEndereco = new DaoEndereco();
            
            ResultSet resultSetendereco = daoEndereco.listarPorId(idEndereco);
            
            try{
                if(resultSetendereco.next()){
                    modEndereco.setId(resultSetendereco.getInt("ID"));
                    modEndereco.setCep(resultSetendereco.getInt("CEP"));
                    modEndereco.setCidade(resultSetendereco.getString("CIDADE"));
                    modEndereco.setEstado(resultSetendereco.getString("ESTADO"));
                    modEndereco.setNumero(resultSetendereco.getString("NUMERO"));
                    modEndereco.setRua(resultSetendereco.getString("RUA"));
                    modEndereco.setBairro(resultSetendereco.getString("BAIRRO"));
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            DadosTemporarios.tempObject2 = modEndereco;*/
         
                
            
        }else if(evt.getButton() == MouseEvent.BUTTON3){
            JPopupMenu popupMenu = new JPopupMenu();

            // Adicione itens ao menu popup
            JMenuItem menuItem1 = new JMenuItem("Dados do processo");

            // Adicione ação aos itens do menu popup
            menuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int linhaClicada = tblProc.rowAtPoint(evt.getPoint());
                    int id = Integer.parseInt(String.valueOf(tblProc.getValueAt(linhaClicada, 0)));

                    // Realize a consulta ao banco de dados para obter os dados do endereço
                    try {
                        DaoProcesso daoCliente = new DaoProcesso();
                        ResultSet rs = daoCliente.listarPorID(id);
                        if (rs.next()) {
                            vara.setText(rs.getString("Vara"));
                            comarca.setText(rs.getString("Comarca"));
                            status.setText(rs.getString("Status"));
                            reu.setText(rs.getString("Reu"));
                            dataprotocolo.setText(rs.getString("Data_Protocolo"));
                            
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    jPanelExtra.setVisible(true);
                }
            });

            // Adicione os itens ao menu popup
            popupMenu.add(menuItem1);

            // Exiba o menu popup na posição do mouse
            popupMenu.show(tblProc, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblProcMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPanelExtra.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ListProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListProcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrarProc;
    private javax.swing.JComboBox<String> cmbProc;
    private javax.swing.JLabel comarca;
    private javax.swing.JLabel dataprotocolo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelExtra;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numero1;
    private javax.swing.JLabel reu;
    private javax.swing.JLabel status;
    private javax.swing.JTable tblProc;
    private javax.swing.JTextField txtFiltrarProc;
    private javax.swing.JLabel vara;
    // End of variables declaration//GEN-END:variables
}
