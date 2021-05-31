package com.bustech.bustech.repositories;

import com.bustech.bustech.entities.Empresas;
import com.bustech.bustech.entities.Maquinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinasRepository extends JpaRepository<Maquinas, Long> {
}
