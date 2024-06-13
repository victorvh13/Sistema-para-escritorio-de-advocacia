/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.outros.BancoDeDadosMySql;
import static com.mycompany.outros.BancoDeDadosMySql.getConexao;
import static com.mycompany.outros.BancoDeDadosMySql.getResultado;
import static com.mycompany.outros.BancoDeDadosMySql.getStatement;
import static com.mycompany.outros.BancoDeDadosMySql.setResultado;
import static com.mycompany.outros.BancoDeDadosMySql.setStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victor.7455
 */
public class DaoCliente {
    String sql;
    
    public Boolean inserir(int id, String nome, String CPF, String telefone, String email, int idEndereco){
        try{
            sql = "INSERT INTO CLIENTE (ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, nome);
            getStatement().setString(3, CPF);
            getStatement().setString(4, telefone);
            getStatement().setString(5, email);
            getStatement().setInt(6, idEndereco);

            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, String nome, String CPF, String telefone, String email, int idEndereco){
        try{
            sql = "UPDATE CLIENTE SET ID = ?, NOME = ?, CPF = ?, TELEFONE = ?, EMAIL = ?, ID_ENDERECO = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
             getStatement().setInt(6, id);
            getStatement().setString(1, nome);
            getStatement().setString(2, CPF);
            getStatement().setString(3, telefone);
            getStatement().setString(4, email);
            getStatement().setInt(5, idEndereco);
             
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM CLIENTE WHERE ID = ?";
            
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
                sql = "SELECT ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO FROM CLIENTE";
                
            setStatement(getConexao().prepareStatement(sql));
                
            setResultado(getStatement().executeQuery());
                
            }catch(SQLException e){
           System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     
     public ResultSet listarPorId(int id){
        try{
            sql = "select \n" +
                    "	c.id as ID,\n" +
                    "	c.Nome as NOME,\n" +
                    "	c.CPF as CPF,\n" +
                    "	c.Telefone as TELEFONE,\n" +
                    "	c.Email as EMAIL,\n" +
                    "	c.id_endereco as ID_ENDERECO,\n" +
                    "	e.CEP as CEP,\n" +
                    "	e.Estado as ESTADO,\n" +
                    "	e.Cidade as CIDADE,\n" +
                    "	e.Bairro as BAIRRO,\n" +
                    "	e.Rua as RUA,\n" +
                    "	e.Numero as NUMERO\n" +
                    "from \n" +
                    "	cliente c\n" +
                    "join endereco e on\n" +
                    "	e.id = c.id_endereco \n" +
                    "where c.id = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     
     public ResultSet listarPorNome(String nome){
         try{
             sql = "SELECT ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO FROM CLIENTE WHERE NOME LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, nome + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
     }
     
     public ResultSet listarPorCPF(String CPF){
         try{
             sql = "SELECT ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO FROM CLIENTE WHERE CPF LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, CPF + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
     }
     
     public ResultSet listarPorTelefone(String telefone){
         try{
             sql = "SELECT ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO FROM CLIENTE WHERE TELEFONE LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, telefone + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
     }
     
     public ResultSet listarPorEmail(String email){
         try{
             sql = "SELECT ID, NOME, CPF, TELEFONE, EMAIL, ID_ENDERECO FROM CLIENTE WHERE EMAIL LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, email + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
     }
     
     public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CLIENTE";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
     
     
}

