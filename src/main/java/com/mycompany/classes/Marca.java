package com.mycompany.classes;

/**
 *
 * @author Gabriel Miranda
 */
public class Marca {
    private int id;
    private String descMarca;

    public Marca() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescMarca() {
        return descMarca;
    }

    public void setDescMarca(String descMarca) {
        this.descMarca = descMarca;
    }

    public String toString(){
        return "Código Marca: " + id + "\nMarca: " + descMarca;
    }
}
