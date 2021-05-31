package com.bustech.bustech.repositories;

import com.bustech.bustech.entities.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long> {
}
