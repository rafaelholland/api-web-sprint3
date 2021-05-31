package com.bustech.bustech.entities;

import com.bustech.bustech.entities.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_empresas")
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String usuario;
    private String senha;
    private String telefone;



    @OneToMany(mappedBy = "empresas")
    private List<Maquinas> maquinas = new ArrayList<>();



    public Empresas(Long id, String cnpj, String usuario, String senha, String telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.usuario = usuario;
        this.senha = senha;
        this.telefone = telefone;
    }
    public Empresas(){}

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Maquinas> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(List<Maquinas> maquinas) {
        this.maquinas = maquinas;
    }

}
