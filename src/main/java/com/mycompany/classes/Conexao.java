package com.mycompany.classes;
import java.sql.*;

public class Conexao {
    private static Connection conectar;



    public static Connection CarregamentoDriver(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch(Exception e){
            System.out.println("Erro de conexão: " + e.getMessage() + e.getCause());
        }
        return null;
    }

    public Conexao() throws Exception {

        try{
            if(conectar != null && !conectar.isClosed()){
                return;
            }
            CarregamentoDriver();
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbFag", "postgres", "99366711Ga");

            conectar.setAutoCommit(false);
            conectar.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage() + " " + e.getErrorCode());
        }
    }

    public static Connection getConectar() {
        return conectar;
    }

    public void fecharConexao() throws Exception{
        try{
            if(conectar == null || conectar.isClosed()){
                return;
            }
            System.out.println("Conexão encerrada.");
            conectar.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage() + e.getErrorCode());;
        }
    }

    public void confirmaTransacao() throws Exception{
        try{
            if(conectar == null || conectar.isClosed()){
                return;
            }
            conectar.commit();
        }catch (SQLException e){
            System.out.println("Erro: " + e.getMessage() + e.getErrorCode());
        }
    }

    public void cancelarTransacao() throws Exception{
        try{
            if(conectar == null || conectar.isClosed()){
                return;
            }
            conectar.rollback();
        }catch (SQLException e){
            System.out.println("Erro: " + e.getMessage() + e.getErrorCode());
        }
    }
}
