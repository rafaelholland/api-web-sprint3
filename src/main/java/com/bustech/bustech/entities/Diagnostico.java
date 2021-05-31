package com.bustech.bustech.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_diagnosticos")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double ram;
    private Double disco;
    private Double processador;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquinas maquinas;

    public Diagnostico(){}

    public Diagnostico(Long id, Double ram, Double disco, Double processador, Maquinas maquina) {
        this.id = id;
        this.ram = ram;
        this.disco = disco;
        this.processador = processador;
        this.maquinas = maquina;
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

    public Maquinas getMaquina() {
        return maquinas;
    }

    public void setMaquina(Maquinas maquina) {
        this.maquinas = maquina;
    }
}
