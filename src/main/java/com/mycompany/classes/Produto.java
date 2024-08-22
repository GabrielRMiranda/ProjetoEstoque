package com.mycompany.classes;

/**
 *
 * @author Gabriel Miranda
 */
public class Produto {
    private int id;
    private String descProduto;
    private Marca marca;

    private UnidadeMedida unidadeMedida;

    public Produto() {
    }

    public Produto(int id, String descProduto, Marca marca, UnidadeMedida unidadeMedida) {
        this.id = id;
        this.descProduto = descProduto;
        this.marca = marca;
        this.unidadeMedida = unidadeMedida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String toString(){
        return "Código do Produto: " + id + "\nProduto: " + descProduto +
               "Marca: " + marca.getDescMarca();
    }
}
