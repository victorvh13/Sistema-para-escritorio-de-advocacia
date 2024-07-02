/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.telas;

import com.mycompany.dao.DaoCliente;
import com.mycompany.modelo.ModCliente;
import com.mycompany.dao.DaoEndereco;
import com.mycompany.modelo.ModEndereco;
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
public class Cadastro_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro_Cliente2
     */
    public Cadastro_Cliente() {
        initComponents();
        
        if(!existeDadosTemporarios()){
            DaoCliente daoCliente = new DaoCliente();

            int id = daoCliente.buscarProximoId(); 
            if (id >= 0)
                txtIdCli.setText(String.valueOf(id));
            
            btnCadCliCad.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluirCli.setVisible(false);
        }else{
            btnCadCliCad.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluirCli.setVisible(true);
        }
        
        setLocationRelativeTo(null);
        
        txtIdCli.setEnabled(false); 
        
        txtIdEnd.setVisible(false);

    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModCliente){
            int id = ((ModCliente) DadosTemporarios.tempObject).getId();
            
            String nome = ((ModCliente) DadosTemporarios.tempObject).getNome();
            String cpf = ((ModCliente) DadosTemporarios.tempObject).getCpf();
            String telefone = ((ModCliente) DadosTemporarios.tempObject).getTelefone();
            String email = ((ModCliente) DadosTemporarios.tempObject).getEmail();
            int idEnd = ((ModEndereco) DadosTemporarios.tempObject2).getId();
            int cep = ((ModEndereco) DadosTemporarios.tempObject2).getCep();
            String uf = ((ModEndereco) DadosTemporarios.tempObject2).getEstado();
            String cidade = ((ModEndereco) DadosTemporarios.tempObject2).getCidade();
            String bairro = ((ModEndereco) DadosTemporarios.tempObject2).getBairro();
            String rua = ((ModEndereco) DadosTemporarios.tempObject2).getRua();
            String numero = ((ModEndereco) DadosTemporarios.tempObject2).getNumero();
            
            txtIdCli.setText(String.valueOf(id));
            txtCadCliNome.setText(nome);
            txtCadCliCPF.setText(cpf);
            txtCadCliTel.setText(telefone);
            txtCadCliEmail.setText(String.valueOf(email));
            txtCadCliCep.setText(String.valueOf(cep));
            txtCadCliUF.setText(String.valueOf(uf));
            txtCadCliCid.setText(cidade);
            txtCadCliBar.setText(bairro);
            txtCadCliLog.setText(rua);
            txtCadCliN.setText(numero);
            
            txtIdEnd.setText(String.valueOf(idEnd));
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        
        DaoEndereco daoEndereco = new DaoEndereco();
        
        int proximoIdEndereco = daoEndereco.buscarProximoId();
        
        daoEndereco.inserir(proximoIdEndereco, txtCadCliCep.getText(), txtCadCliUF.getText(), txtCadCliCid.getText(), txtCadCliBar.getText(), txtCadCliLog.getText(), txtCadCliN.getText());
        
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.inserir(daoCliente.buscarProximoId(), txtCadCliNome.getText(), txtCadCliCPF.getText(), txtCadCliTel.getText(), txtCadCliEmail.getText(), proximoIdEndereco)){
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
            
            txtIdCli.setText(String.valueOf(daoCliente.buscarProximoId()));
            txtCadCliNome.setText("");
            txtCadCliCPF.setText("");
            txtCadCliTel.setText("");
            txtCadCliEmail.setText("");
            txtCadCliCep.setText("");
            txtCadCliUF.setText("");
            txtCadCliCid.setText("");
            txtCadCliBar.setText("");
            txtCadCliLog.setText("");
            txtCadCliN.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar esse cliente");
        }
            
    }
    
        private void alterar(){
            
            DaoEndereco daoEndereco = new DaoEndereco();
        
            int proximoIdEndereco = daoEndereco.buscarProximoId();
        
//            daoEndereco.inserir(proximoIdEndereco, txtCadCliCep.getText(), txtCadCliUF.getText(), txtCadCliCid.getText(), txtCadCliBar.getText(), txtCadCliLog.getText(), txtCadCliN.getText());
        
            daoEndereco.alterar(Integer.parseInt(txtIdEnd.getText()), txtCadCliCep.getText(), txtCadCliUF.getText(), txtCadCliCid.getText(), txtCadCliBar.getText(), txtCadCliLog.getText(), txtCadCliN.getText());

            DaoCliente daoCliente = new DaoCliente();
        
            if (daoCliente.alterar(Integer.parseInt(txtIdCli.getText()), txtCadCliNome.getText(), txtCadCliCPF.getText(), txtCadCliTel.getText(), txtCadCliEmail.getText())){
                JOptionPane.showMessageDialog(null, "Dados do Cliente Alterados!");

                txtIdCli.setText(String.valueOf(daoCliente.buscarProximoId()));
                txtCadCliNome.setText("");
                txtCadCliCPF.setText("");
                txtCadCliTel.setText("");
                txtCadCliEmail.setText("");
                txtCadCliCep.setText("");
                txtCadCliUF.setText("");
                txtCadCliCid.setText("");
                txtCadCliBar.setText("");
                txtCadCliLog.setText("");
                txtCadCliN.setText("");
            
            
            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados do Cliente");
            }
            
            ((ListCliente) Formularios.ListCliente).listarTodos();
        
        dispose();
        }
        
        
        private void excluir(){
        DaoEndereco daoEndereco = new DaoEndereco();
        
        int proximoIdEndereco = daoEndereco.buscarProximoId();
        
        daoEndereco.alterar(Integer.parseInt(txtIdEnd.getText()), txtCadCliCep.getText(), txtCadCliUF.getText(), txtCadCliCid.getText(), txtCadCliBar.getText(), txtCadCliLog.getText(), txtCadCliN.getText());
        
        DaoCliente daoCliente = new DaoCliente();
        
        if (daoCliente.excluir(Integer.parseInt(txtIdCli.getText()))){
            JOptionPane.showMessageDialog(null, "Cliente " + txtCadCliNome.getText() + " excluído com sucesso!");
            
            txtCadCliNome.setText("");
            txtCadCliCPF.setText("");
            txtCadCliTel.setText("");
            txtCadCliEmail.setText("");
            txtCadCliCep.setText("");
            txtCadCliUF.setText("");
            txtCadCliCid.setText("");
            txtCadCliBar.setText("");
            txtCadCliLog.setText("");
            txtCadCliN.setText("");
            
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir os dados do Cliente!");
        }
                
        dispose();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCadCliLog = new javax.swing.JTextField();
        txtCadCliNome = new javax.swing.JTextField();
        txtCadCliN = new javax.swing.JTextField();
        txtCadCliCPF = new javax.swing.JTextField();
        txtCadCliBar = new javax.swing.JTextField();
        txtCadCliCid = new javax.swing.JTextField();
        txtCadCliEmail = new javax.swing.JTextField();
        txtCadCliUF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCadCliCep = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCadCliCad = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCadCliVoltar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCadCliTel = new javax.swing.JTextField();
        btnExcluirCli = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        txtIdEnd = new javax.swing.JTextField();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telefone");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("CEP");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("E-mail");

        txtCadCliLog.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliBar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliCid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCadCliCid.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtCadCliEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtCadCliUF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCadCliUF.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Logradouro");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE CLIENTE");

        txtCadCliCep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nº");

        btnCadCliCad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCadCliCad.setText("CADASTRAR");
        btnCadCliCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCliCadActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nome completo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Bairro");

        btnCadCliVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCadCliVoltar.setText("VOLTAR");
        btnCadCliVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCliVoltarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Cidade");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("CPF");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Estado");

        txtCadCliTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnExcluirCli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExcluirCli.setText("EXCLUIR");
        btnExcluirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCliActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCadCliCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtCadCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(323, 323, 323))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnExcluirCli)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCadCliCad)
                                    .addGap(9, 9, 9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(txtCadCliLog, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtCadCliBar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtCadCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCadCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCadCliCid, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txtCadCliUF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCadCliVoltar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCadCliN, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(txtCadCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(280, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addComponent(txtIdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCliNome))
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtCadCliCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCadCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCliTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCadCliLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCliN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCadCliBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCliCid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCadCliUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtCadCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadCliCad)
                    .addComponent(btnCadCliVoltar)
                    .addComponent(btnExcluirCli))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnCadCliVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCliVoltarActionPerformed
        if (Formularios.Menu == null)
            Formularios.Menu = new Menu();
        
        Formularios.Menu.setVisible(true);
        Formularios.Menu.setExtendedState(JFrame.NORMAL); 
    }//GEN-LAST:event_btnCadCliVoltarActionPerformed

    private void btnCadCliCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCliCadActionPerformed
        DaoCliente daoCliente = new DaoCliente();

        if (btnCadCliCad.getText() == Constantes.BTN_SALVAR_TEXT){
          inserir();

        }else if (btnCadCliCad.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            dispose();
        } 
    }//GEN-LAST:event_btnCadCliCadActionPerformed

    private void btnExcluirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCliActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir o processo?");
        
        if(escolha == JOptionPane.YES_OPTION){
            excluir();
            ((ListCliente) Formularios.ListCliente).listarTodos();
        }
    }//GEN-LAST:event_btnExcluirCliActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCliCad;
    private javax.swing.JButton btnCadCliVoltar;
    private javax.swing.JButton btnExcluirCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txtCadCliBar;
    private javax.swing.JTextField txtCadCliCPF;
    private javax.swing.JTextField txtCadCliCep;
    private javax.swing.JTextField txtCadCliCid;
    private javax.swing.JTextField txtCadCliEmail;
    private javax.swing.JTextField txtCadCliLog;
    private javax.swing.JTextField txtCadCliN;
    private javax.swing.JTextField txtCadCliNome;
    private javax.swing.JTextField txtCadCliTel;
    private javax.swing.JTextField txtCadCliUF;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtIdEnd;
    // End of variables declaration//GEN-END:variables
}
