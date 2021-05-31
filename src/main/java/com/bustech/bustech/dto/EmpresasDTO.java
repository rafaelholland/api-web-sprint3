package com.bustech.bustech.dto;

import com.bustech.bustech.entities.Empresas;
import com.bustech.bustech.entities.Maquinas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EmpresasDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;
    private String cnpj;
    private String usuario;
    private String senha;
    private String telefone;
    private List<MaquinasDTO> maquinas = new ArrayList<>();


    public EmpresasDTO(Empresas entity) {
        this.senha = entity.getSenha();
        this.id = entity.getId();
        this.cnpj = entity.getCnpj();
        this.usuario = entity.getUsuario();
        this.telefone = entity.getTelefone();
    }

    public EmpresasDTO(Empresas entity, List<Maquinas> maquinas){
        this(entity);
        maquinas.forEach(maq -> this.maquinas.add(new MaquinasDTO(maq, maq.getDiagnosticos())));
    }

    public EmpresasDTO(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<MaquinasDTO> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<MaquinasDTO> maquinas) {
        this.maquinas = maquinas;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}
