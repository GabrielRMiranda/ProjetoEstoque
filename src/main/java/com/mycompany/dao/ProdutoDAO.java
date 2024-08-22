/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;
import com.mycompany.classes.Conexao;
import com.mycompany.classes.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gabriel Miranda
 */
public class ProdutoDAO {
    Connection conectar;
    PreparedStatement pstmt;

    public void NovoProduto(){

        String sql = "INSERT INTO Produto (nome, marca, unidademedida) VALUES (?,?,?)";

        try{
            pstmt = conectar.prepareStatement(sql);
        } catch (Exception e){

        }

    }
}
