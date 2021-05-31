package com.bustech.bustech.dto;

import com.bustech.bustech.entities.Diagnostico;
import com.bustech.bustech.entities.Maquinas;

import javax.persistence.*;

public class DiagnosticoDTO {


    private Long id;
    private Double ram;
    private Double disco;
    private Double processador;

    public DiagnosticoDTO(){}

    public DiagnosticoDTO(Diagnostico entity){
        this.id = entity.getId();
        this.ram = entity.getRam();
        this.disco = entity.getDisco();
        this.processador = entity.getProcessador();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRam() {
        return ram;
    }

    public void setRam(Double ram) {
        this.ram = ram;
    }

    public Double getDisco() {
        return disco;
    }

    public void setDisco(Double disco) {
        this.disco = disco;
    }

    public Double getProcessador() {
        return processador;
    }

    public void setProcessador(Double processador) {
        this.processador = processador;
    }



}
