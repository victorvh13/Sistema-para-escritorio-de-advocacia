/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author victor.7455
 */
public class ModAdvogados {
    private int id;
    private String nome;
    private String oab;
    private String uf;

    public ModAdvogados(int id, String nome, String oab, String uf) {
        this.id = id;
        this.nome = nome;
        this.oab = oab;
        this.uf = uf;
    }

    public ModAdvogados(String nome) {
        this.nome = nome;
    }
    
    public ModAdvogados() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getOab() {
        return oab;
    }

    public String getUf() {
        return uf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ModAdvogados{" + "id=" + id + ", nome=" + nome + ", oab=" + oab + ", uf=" + uf + '}';
    }
    
    
}
