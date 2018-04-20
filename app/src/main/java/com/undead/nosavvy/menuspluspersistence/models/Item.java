package com.undead.nosavvy.menuspluspersistence.models;

import com.orm.dsl.Table;

/**
 * Created by nosavvy on 4/20/18.
 */
@Table
public class Item {
    private Long id;

    public Item(){

    }

    public Item(String nombre, String categoria, Double precio, String descripcion, String estado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    private String nombre;
    private String categoria;
    private Double precio;
    private String descripcion;
    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
