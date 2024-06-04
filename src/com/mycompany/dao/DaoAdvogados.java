/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.outros.BancoDeDadosMySql;
import java.sql.ResultSet;

/**
 *
 * @author victor.7455
 */
public class DaoAdvogados extends BancoDeDadosMySql {
    private String sql;
    public Boolean inserir (int id, String nome, String oab, String uf) {
        try {
            sql = "INSERT INTO ADVOGADOS (ID, NOME, OAB, UF) VALUES (?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, oab);
            getStatement().setString(4, uf);
          
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        
        }
}
    
        public Boolean alterar (int id, String novoNome, String novaOab, String novaUf) {
            try{
                 sql = "UPDATE ADVOGADOS SET NOME = ?, OAB = ?, UF = ?  WHERE ID = ?";
                  setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(4, id);
            getStatement().setString(1, novoNome);
            getStatement().setString(2, novaOab);
            getStatement().setString(3, novaUf);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
                 
            
            }
 
        }
            public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ADVOGADOS WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
            
            public ResultSet listarTodos(){
            try {
                sql = "SELECT ID, NOME, OAB, UF FROM ADVOGADOS";
                
            setStatement(getConexao().prepareStatement(sql));
                
            setResultado(getStatement().executeQuery());
                
            }catch(Exception e){
           System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
            
        

    public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, NOME, OAB, UF FROM ADVOGADOS WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = "SELECT ID, NOME, OAB, UF FROM ADVOGADOS WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorOab(String oab){
        try{
            sql = "SELECT ID, NOME, OAB, UF FROM ADVOGADOS WHERE OAB LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, oab + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorUf(String uf){
        try{
            sql = "SELECT ID, NOME, OAB, UF FROM ADVOGADOS WHERE UF LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, uf + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
   
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ADVOGADOS";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next();
            
            id = getResultado().getInt(1); 
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    
    }
    
}
    

