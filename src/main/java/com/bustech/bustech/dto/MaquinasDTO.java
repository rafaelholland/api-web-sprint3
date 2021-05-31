package com.bustech.bustech.dto;

import com.bustech.bustech.entities.Diagnostico;
import com.bustech.bustech.entities.Empresas;
import com.bustech.bustech.entities.Maquinas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MaquinasDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String usuario;
    private String senha;
    private String tipo;
    private Boolean ativo;
    private String latitude;
    private String longitude;
    private Double maxRam;
    private Double maxCpu;
    private Double maxDisco;
    private List<DiagnosticoDTO> diagnosticos = new ArrayList<>();



    public MaquinasDTO(Maquinas entity) {
        this.id = entity.getId();
        this.usuario = entity.getUsuario();
        this.latitude = entity.getLatitude();
        this.senha = entity.getSenha();
        this.longitude = entity.getLongitude();
        this.ativo = entity.getAtivo();
        this.maxCpu = entity.getMaxCpu();
        this.maxDisco = entity.getMaxDisco();
        this.maxRam = entity.getMaxRam();
        this.tipo = entity.getTipo();
    }

    public MaquinasDTO(Maquinas entity, List<Diagnostico> diagnosticos){
        this(entity);
        diagnosticos.forEach(dig -> this.diagnosticos.add((new DiagnosticoDTO(dig))));
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

    public List<DiagnosticoDTO> getDiagnosticos() {
        return diagnosticos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDiagnosticos(List<DiagnosticoDTO> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
