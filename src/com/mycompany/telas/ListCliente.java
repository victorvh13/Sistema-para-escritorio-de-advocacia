/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;
import com.mycompany.dao.DaoCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.outros.DadosTemporarios;
import com.mycompany.outros.Formularios;
import com.mycompany.modelo.ModCliente;
import com.mycompany.modelo.ModEndereco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author victor.7455
 */
public class ListCliente extends javax.swing.JFrame {

    /**
     * Creates new form ListCliente
     */
    public ListCliente() {
        initComponents();
  
        setLocationRelativeTo(null);
        
        listarTodos();
  
        jPanelEnderecoCliente.setVisible(false);
    }

        public void listarTodos(){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();
            
            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            ResultSet resultSet = daoCliente.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String tel = resultSet.getString(3);
                String email = resultSet.getString(4);
                String endereco = resultSet.getString(5);

                
                defaultTableModel.addRow(new Object[]{id, cpf,tel, email,endereco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
    public void listarPorId(int pId){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();

            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCliente.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String nome = resultSet.getString(2);
                String cpf = resultSet.getString(3);
                String tel = resultSet.getString(4);
                String email = resultSet.getString(5);
  
                defaultTableModel.addRow(new Object[]{id, nome, cpf, tel, email});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    } 
    
        public void listarPorNome(String pNome){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();
            
            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            ResultSet resultSet = daoCliente.listarPorNome(txtListCliente.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String tel = resultSet.getString(3);
                String email = resultSet.getString(4);
                String endereco = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, cpf, tel, email, endereco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
        public void listarPorCPF(String pCPF){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();
            
            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            ResultSet resultSet = daoCliente.listarPorCPF(txtListCliente.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String tel = resultSet.getString(3);
                String email = resultSet.getString(4);
                String endereco = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, cpf, tel, email, endereco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        public void listarPorTelefone(String pTelefone){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();
            
            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            ResultSet resultSet = daoCliente.listarPorTelefone(txtListCliente.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String tel = resultSet.getString(3);
                String email = resultSet.getString(4);
                String endereco = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, cpf, tel, email, endereco});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
        
        public void listarPorEmail(String pEmail){
        try{
            DefaultTableModel defaultTableModel = (DefaultTableModel) tblListCliente.getModel();
            
            tblListCliente.setModel(defaultTableModel);

            DaoCliente daoCliente = new DaoCliente();

            ResultSet resultSet = daoCliente.listarPorEmail(txtListCliente.getText());
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String tel = resultSet.getString(3);
                String email = resultSet.getString(4);
                String endereco = resultSet.getString(5);
                
                defaultTableModel.addRow(new Object[]{id, cpf, tel, email, endereco});
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

        ppMnOpcoesCliente = new javax.swing.JPopupMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        cmbListCliente = new javax.swing.JComboBox<>();
        txtListCliente = new javax.swing.JTextField();
        btnListCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListCliente = new javax.swing.JTable();
        jPanelEnderecoCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cep = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bairro = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rua = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        numero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbListCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME", "CPF", "TEL", "EMAIL" }));
        cmbListCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListClienteActionPerformed(evt);
            }
        });

        txtListCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListClienteActionPerformed(evt);
            }
        });

        btnListCliente.setText("FILTRAR");
        btnListCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListClienteActionPerformed(evt);
            }
        });

        tblListCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Tel", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListCliente.setColumnSelectionAllowed(true);
        tblListCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListCliente);
        tblListCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblListCliente.getColumnModel().getColumnCount() > 0) {
            tblListCliente.getColumnModel().getColumn(0).setMaxWidth(40);
            tblListCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblListCliente.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbListCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtListCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListCliente)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtListCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelEnderecoCliente.setBackground(new java.awt.Color(153, 153, 153));
        jPanelEnderecoCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("CEP:");

        cep.setText("jLabel2");

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Estado:");

        estado.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Cidade:");

        cidade.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Bairro:");

        bairro.setText("jLabel2");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Rua:");

        rua.setText("jLabel2");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Número:");

        numero.setText("jLabel2");

        javax.swing.GroupLayout jPanelEnderecoClienteLayout = new javax.swing.GroupLayout(jPanelEnderecoCliente);
        jPanelEnderecoCliente.setLayout(jPanelEnderecoClienteLayout);
        jPanelEnderecoClienteLayout.setHorizontalGroup(
            jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                        .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cep))
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado))
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cidade))
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bairro))
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rua))
                            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numero)))
                        .addGap(0, 263, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEnderecoClienteLayout.setVerticalGroup(
            jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(23, 23, 23)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cep))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(estado))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cidade))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bairro))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rua))
                .addGap(18, 18, 18)
                .addGroup(jPanelEnderecoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(numero))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelEnderecoCliente, javax.swing.JLayeredPane.PALETTE_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jPanelEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jPanelEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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

    private void cmbListClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbListClienteActionPerformed

    private void txtListClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtListClienteActionPerformed

    private void tblListClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListClienteMouseClicked
        
        if((evt.getButton() == MouseEvent.BUTTON1) && (evt.getClickCount() == 2)){
            int linhaClicada = tblListCliente.rowAtPoint(evt.getPoint());
            
            int idCliente = Integer.parseInt(String.valueOf(tblListCliente.getValueAt(linhaClicada, 0)));
            
            //Obtendo dados do cliente
            ModCliente modCliente = new ModCliente();
            
            DaoCliente daoCliente = new DaoCliente();
            

            
            ResultSet resultSetCliente = daoCliente.listarPorId(idCliente);
            
            int idEndereco = -1;
            try{
                if(resultSetCliente.next()){
                    modCliente.setId(resultSetCliente.getInt("ID"));
                    modCliente.setCpf(resultSetCliente.getString("CPF"));
                    modCliente.setEmail(resultSetCliente.getString("EMAIL"));
                    modCliente.setIdEndereco(resultSetCliente.getInt("ID_ENDERECO"));
                    modCliente.setNome(resultSetCliente.getString("NOME"));
                    modCliente.setTelefone(resultSetCliente.getString("TELEFONE"));
                    
                    idEndereco = resultSetCliente.getInt("id_endereco");
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
            
            DadosTemporarios.tempObject = modCliente;
           
           
         
            ModEndereco modEndereco = new ModEndereco();
            
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
            
            DadosTemporarios.tempObject2 = modEndereco;
            
             Formularios.Cadastro_Cliente = new Cadastro_Cliente();
            Formularios.Cadastro_Cliente.setVisible(true);
            
            //
        }else if(evt.getButton() == MouseEvent.BUTTON3){
            JPopupMenu popupMenu = new JPopupMenu();

      
            JMenuItem menuItem1 = new JMenuItem("Dados do endereço");

         
            menuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int linhaClicada = tblListCliente.rowAtPoint(evt.getPoint());
                    int id = Integer.parseInt(String.valueOf(tblListCliente.getValueAt(linhaClicada, 0)));

                   
                    try {
                        DaoCliente daoCliente = new DaoCliente();
                        ResultSet rs = daoCliente.listarPorId(id);
                        if (rs.next()) {
                            cep.setText(rs.getString("CEP"));
                            estado.setText(rs.getString("Estado"));
                            cidade.setText(rs.getString("Cidade"));
                            bairro.setText(rs.getString("Bairro"));
                            rua.setText(rs.getString("Rua"));
                            numero.setText(rs.getString("Numero"));
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    jPanelEnderecoCliente.setVisible(true);
                }
            });

  
            popupMenu.add(menuItem1);

          
            popupMenu.show(tblListCliente, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblListClienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanelEnderecoCliente.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListClienteActionPerformed
        switch (cmbListCliente.getSelectedIndex()){
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(txtListCliente.getText()));
                break;
            case 2:
                listarPorNome(txtListCliente.getText());
                break;
            case 3:
                listarPorCPF(txtListCliente.getText());
                break;
            case 4:
                listarPorTelefone(txtListCliente.getText());
                break;
            case 5:
                listarPorEmail(txtListCliente.getText());
                break;
        
    }          
    }//GEN-LAST:event_btnListClienteActionPerformed

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
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairro;
    private javax.swing.JButton btnListCliente;
    private javax.swing.JLabel cep;
    private javax.swing.JLabel cidade;
    private javax.swing.JComboBox<String> cmbListCliente;
    private javax.swing.JLabel estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEnderecoCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numero;
    private javax.swing.JPopupMenu ppMnOpcoesCliente;
    private javax.swing.JLabel rua;
    private javax.swing.JTable tblListCliente;
    private javax.swing.JTextField txtListCliente;
    // End of variables declaration//GEN-END:variables
}
