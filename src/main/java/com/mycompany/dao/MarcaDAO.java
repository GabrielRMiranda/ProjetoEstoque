package com.mycompany.dao;

import com.mycompany.classes.Conexao;
import com.mycompany.classes.Marca;

import java.sql.*;

public class MarcaDAO {
    private Connection conectar;

    private Conexao conexao;

    public MarcaDAO(){
        try{
            Conexao conexao = new Conexao();
            this.conectar = Conexao.getConectar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean validaMarca(String descmarca){
        String sql = "SELECT COUNT(*) FROM Marca WHERE descmarca = ?";

        try{
            PreparedStatement pstmt = conectar.prepareStatement(sql);

            pstmt.setString(1, descmarca);

            try(ResultSet rs = pstmt.executeQuery()){
                if(descmarca == null || descmarca.isBlank()){
                    return true;
                }
            }

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    return rs.getInt(1) > 0;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage()+ "" + e.getCause());
        }

        return false;
    }

    public void NovaMarca(Marca marca){
        String sql = "INSERT INTO Marca (descmarca) VALUES (?)";

        try{PreparedStatement pstmt = conectar.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, marca.getDescMarca());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            Conexao.getConectar().commit();
            rs.close();
            pstmt.close();

        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public Marca ConsultaMarca(String descmarca){
        String sql = "SELECT * FROM Marca WHERE descmarca LIKE ?";
        Marca marca = null;

        try{PreparedStatement pstmt = conectar.prepareStatement(sql);

            pstmt.setString(1, descmarca);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setDescMarca(rs.getString("descmarca"));
            }

        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage() + e.getErrorCode());
        }
        return marca;
    }

}
