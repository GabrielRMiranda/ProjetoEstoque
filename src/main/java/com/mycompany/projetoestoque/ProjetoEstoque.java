package com.mycompany.projetoestoque;
import java.sql.*;
import com.mycompany.classes.Conexao;
import com.mycompany.classes.Marca;
import com.mycompany.classes.Produto;
import com.mycompany.dao.MarcaDAO;
import com.mycompany.dao.ProdutoDAO;

/**
 @author Gabriel Miranda
 */
public class ProjetoEstoque {
    public static void main(String[] args) throws Exception {
        Marca marca = new Marca();
        
        marca.setDescMarca("testescxv");
        
        MarcaDAO marcaDAO = new MarcaDAO();
        
        marcaDAO.NovaMarca(marca);


    }
}
