/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author victor.7455
 */
public class ModProcesso {
    private int id;
    private int idCliente;
    private int idAdvogados;
    private String numeroDoProcesso;
    private String vara;
    private String comarca;
    private int dataProtocolo;
    private String status;
    private String reu;

    public ModProcesso(int id, int idCliente, int idAdvogados, String numeroDoProcesso, String vara, String comarca, int dataProtocolo, String status, String reu) {
        this.id = id;
        this.idCliente = idCliente;
        this.idAdvogados = idAdvogados;
        this.numeroDoProcesso = numeroDoProcesso;
        this.vara = vara;
        this.comarca = comarca;
        this.dataProtocolo = dataProtocolo;
        this.status = status;
        this.reu = reu;
    }

    public ModProcesso() {
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdAdvogados() {
        return idAdvogados;
    }

    public String getNumeroDoProcesso() {
        return numeroDoProcesso;
    }

    public String getVara() {
        return vara;
    }

    public String getComarca() {
        return comarca;
    }

    public int getDataProtocolo() {
        return dataProtocolo;
    }

    public String getStatus() {
        return status;
    }

    public String getReu() {
        return reu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdAdvogados(int idAdvogados) {
        this.idAdvogados = idAdvogados;
    }

    public void setNumeroDoProcesso(String numeroDoProcesso) {
        this.numeroDoProcesso = numeroDoProcesso;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public void setDataProtocolo(int dataProtocolo) {
        this.dataProtocolo = dataProtocolo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReu(String reu) {
        this.reu = reu;
    }

    @Override
    public String toString() {
        return "ModProcesso{" + "id=" + id + ", idCliente=" + idCliente + ", idAdvogados=" + idAdvogados + ", numeroDoProcesso=" + numeroDoProcesso + ", vara=" + vara + ", comarca=" + comarca + ", dataProtocolo=" + dataProtocolo + ", status=" + status + ", reu=" + reu + '}';
    }
    
}
