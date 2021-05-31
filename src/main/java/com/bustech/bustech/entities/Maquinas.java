package com.bustech.bustech.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_maquinas")
public class Maquinas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String usuario;
    private String senha;
    private Boolean ativo;
    private String latitude;
    private String longitude;
    private Double maxRam;
    private Double maxCpu;
    private Double maxDisco;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresas empresas;

    @OneToMany(mappedBy = "maquinas")
    private List<Diagnostico> diagnosticos = new ArrayList<>();

    public Maquinas(String usuario, String senha, Double maxRam, Double maxCpu, Double maxDisco,Boolean ativo, String latitude, String longitude, String tipo ,Empresas empresas) {
        this.usuario = usuario;
        this.senha = senha;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipo = tipo;
        this.ativo = ativo;
        this.maxRam = maxRam;
        this.maxCpu = maxCpu;
        this.maxDisco = maxDisco;
        this.empresas = empresas;
    }

    public Maquinas() {

    }

    public List<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(Double maxRam) {
        this.maxRam = maxRam;
    }

    public Double getMaxCpu() {
        return maxCpu;
    }

    public void setMaxCpu(Double maxCpu) {
        this.maxCpu = maxCpu;
    }

    public Double getMaxDisco() {
        return maxDisco;
    }

    public void setMaxDisco(Double maxDisco) {
        this.maxDisco = maxDisco;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
