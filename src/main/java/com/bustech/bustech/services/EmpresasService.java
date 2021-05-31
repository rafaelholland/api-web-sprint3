package com.bustech.bustech.services;

import com.bustech.bustech.dto.EmpresasDTO;
import com.bustech.bustech.entities.Empresas;
import com.bustech.bustech.repositories.EmpresasRepository;
import com.bustech.bustech.services.exceptions.DatabaseException;
import com.bustech.bustech.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository repository;

    @Transactional(readOnly = true)
    public List<EmpresasDTO> findAll() {
        List<Empresas> list = repository.findAll();
        List<EmpresasDTO> listDto = list.stream().map(x -> new EmpresasDTO(x, x.getMaquinas())).collect(Collectors.toList());
        return listDto;
    }

    @Transactional(readOnly = true)
    public EmpresasDTO findById(Long id) {
        Optional<Empresas> obj = repository.findById(id);
        Empresas entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new EmpresasDTO(entity, entity.getMaquinas());
    }

    @Transactional
    public EmpresasDTO insert(EmpresasDTO dto) {
        Empresas entity = new Empresas();
        dtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmpresasDTO(entity);
    }
    @Transactional
    public EmpresasDTO update(EmpresasDTO dto, Long id) {
        try {
            Empresas entity = repository.getOne(id);
            dtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EmpresasDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found" + id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    private void dtoToEntity(EmpresasDTO dto, Empresas entity){
        entity.setCnpj(dto.getCnpj());
        entity.setSenha(dto.getSenha());
        entity.setUsuario(dto.getUsuario());
        entity.setTelefone(dto.getTelefone());
    }



}

