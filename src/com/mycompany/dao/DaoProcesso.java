/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

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
public class DaoProcesso {
    String sql;
    
    public Boolean inserir(int id, int idCliente, int idAdvogados, String NumeroDoProcesso, String Vara, String Comarca, String DataProtocolo, String Status, String Reu){
        try{
            
            sql = "INSERT INTO PROCESSO (ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCliente);
            getStatement().setInt(3, idAdvogados);
            getStatement().setString(4, NumeroDoProcesso);
            getStatement().setString(5, Vara);
            getStatement().setString(6, Comarca);
            getStatement().setString(7, DataProtocolo);
            getStatement().setString(8, Status);
            getStatement().setString(9, Reu);

            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean alterar(int id, int idCliente, int idAdvogados, String NumeroDoProcesso, String Vara, String Comarca, String DataProtocolo, String Status, String Reu){
        try{
            sql = "UPDATE PROCESSO SET ID_CLIENTE = ?, ID_ADVOGADOS = ?, NUMERO_DO_PROCESSO = ?, VARA = ?, COMARCA = ?, DATA_PROTOCOLO = ?, STATUS = ?, REU = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(9, id);
            getStatement().setInt(1, idCliente);
            getStatement().setInt(2, idAdvogados);
            getStatement().setString(3, NumeroDoProcesso);
            getStatement().setString(4, Vara);
            getStatement().setString(5, Comarca);
            getStatement().setString(6, DataProtocolo);
            getStatement().setString(7, Status);
            getStatement().setString(8, Reu);
             
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean excluir(int id){
        try{
            sql = "DELETE FROM PROCESSO WHERE ID = ?";
            
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
//                sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO";
             sql = "SELECT * FROM PROCESSO p join cliente c on c.id = p.id_cliente join advogados a on a.id = p.id_Advogados";

            setStatement(getConexao().prepareStatement(sql));
                
            setResultado(getStatement().executeQuery());
                
            }catch(SQLException e){
           System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorID(int id){
         try{
             sql = "select\n" +
                    "	p.id,\n" +
                    "	c.Nome as cliente,\n" +
                    "	a.nome as advogado,\n" +
                    "	p.Numero_do_Processo,\n" +
                    "	p.Vara,\n" +
                    "	p.Comarca,\n" +
                    "	p.Data_Protocolo,\n" +
                    "	p.Status,\n" +
                    "	p.Reu, \n" +
                    "	c.id, \n" +
                    "	p.id_cliente, \n" +
                    "	p.id_advogados \n" +
                    "from\n" +
                    "	processo p \n" +
                    "join cliente c\n" +
                    "	on c.id = p.id_cliente \n" +
                    "join advogados a \n" +
                    "	on a.id = p.id_Advogados\n" +
                    "where \n" +
                    "	p.id = ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setInt(1, id);

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorIdCliente(int idCliente){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE ID_CLIENTE = ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setInt(1, idCliente);

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorNomeCliente(String nomeCliente){
         try{
             sql = "SELECT * FROM PROCESSO P join CLIENTE C on C.id = P.id_cliente join advogados a on a.id = p.id_Advogados where c.Nome like ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, nomeCliente + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorNomeAdvogado(String nomeAdvogado){
         try{
             sql = "SELECT * FROM PROCESSO P join CLIENTE C on C.id = P.id_cliente join advogados a on a.id = p.id_Advogados where a.Nome like ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, nomeAdvogado + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorIdAdvogados(int idAdvogados){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE ID_ADVOGADOS = ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setInt(1, idAdvogados);

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorNumeroDoProcesso(String NumeroDoProcesso){
         try{
             sql = "SELECT * FROM PROCESSO P join CLIENTE C on C.id = P.id_cliente join advogados a on a.id = p.id_Advogados WHERE p.NUMERO_DO_PROCESSO LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, NumeroDoProcesso + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorVara(String Vara){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE VARA LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, Vara + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorComarca(String Comarca){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE COMARCA LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, Comarca + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorDataProtocolo(int DataProtocolo){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE DATA_PROTOCOLO = ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setInt(1, DataProtocolo);

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorStatus(String Status){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE STATUS LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, Status + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
    public ResultSet listarPorReu(String Reu){
         try{
             sql = "SELECT ID, ID_CLIENTE, ID_ADVOGADOS, NUMERO_DO_PROCESSO, VARA, COMARCA, DATA_PROTOCOLO, STATUS, REU FROM PROCESSO WHERE ID_ADVOGADOS LIKE ?";

             setStatement(getConexao().prepareStatement(sql));

             getStatement().setString(1, Reu + "%");

             setResultado(getStatement().executeQuery());
         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

         return getResultado();
    }
    
        public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM PROCESSO";
            
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


