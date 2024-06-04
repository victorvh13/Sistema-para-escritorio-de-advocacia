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
public class DaoEndereco extends BancoDeDadosMySql {
    private String sql;
    public Boolean inserir (int id, String cep, String estado, String cidade, String bairro, String rua, String numero) {
        try {
            sql = "INSERT INTO ENDERECO (ID, CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setString(2, cep);
            getStatement().setString(3, estado);
            getStatement().setString(4, cidade);
            getStatement().setString(5, bairro);
            getStatement().setString(6, rua);
            getStatement().setString(7, numero);
          
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

    }
    }
    
            public Boolean alterar (int id, String novoCep, String novoEstado, String novaCidade, String novoBairro, String novaRua, String novoNumero) {
            try{
                 sql = "UPDATE ENDERECO SET CEP = ?, ESTADO = ?, CIDADE = ?, BAIRRO = ?, RUA = ?, NUMERO = ?  WHERE ID = ?";
                  setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(7, id);
            getStatement().setString(1, novoCep);
            getStatement().setString(2, novoEstado);
            getStatement().setString(3, novaCidade);
            getStatement().setString(4, novoBairro);
            getStatement().setString(5, novaRua);
            getStatement().setString(6, novoNumero);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
                 
            
      }
    }
          public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ENDERECO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }   
          }
         public ResultSet listarTodos(){
            try {
                sql = "SELECT ID, CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO";
                
            setStatement(getConexao().prepareStatement(sql));
                
            setResultado(getStatement().executeQuery());
                
            }catch(SQLException e){
           System.out.println(e.getMessage());
        }
        
        return getResultado();
    }


        public ResultSet listarPorId(int id){
        try{
            sql = "SELECT ID, CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }


    public ResultSet listarPorCEP(String CEP){
         try{
             sql = "SELECT ID, CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO FROM ENDERECO WHERE CEP LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, CEP + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
     }
    
public ResultSet listarPorEstado(String estado){
        try{
            sql = "SELECT ID,CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO FROM ENDERECO WHERE ESTADO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, estado + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
}

     public ResultSet listarPorcidade(String cidade){
        try{
            sql = "SELECT ID, CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO  WHERE CIDADE LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, cidade + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
        return getResultado();
  
}
     public ResultSet listarPorBairro(String bairro){
     try{
         sql = "SELECT ID,CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO FROM ENDERECO WHERE BAIRRO LIKE ?";
         
         setStatement(getConexao().prepareStatement(sql));
         
         setResultado(getStatement() .executeQuery());
         
     }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
        return getResultado();
     
}

    /**
     *
     * @param rua
     * @return
     */
    public ResultSet listarPorRua(String rua){
     try{
         sql = "SELECT ID,CEP, ESTADO, CIDADE, BAIRRO, RUA, NUMERO FROM ENDERECO WHERE RUA LIKE ?";
         
         setStatement(getConexao().prepareStatement(sql));
         
         setResultado(getStatement() .executeQuery());
         
     }catch(SQLException e){
            System.out.println(e.getMessage());
        }
       
        return getResultado();
 }
    public int buscarProximoId(){
            int id = 0;

            try{
                sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ENDERECO";

                setStatement(getConexao().prepareStatement(sql));

                setResultado(getStatement().executeQuery());

                getResultado().next();

                id = getResultado().getInt(1); 
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

            return id;

    }
    
}