package com.bustech.bustech.services;

import com.bustech.bustech.dto.DiagnosticoDTO;
import com.bustech.bustech.entities.Diagnostico;
import com.bustech.bustech.repositories.DiagnosticoRepository;
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
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository repository;

    @Transactional(readOnly = true)
    public List<DiagnosticoDTO> findAll() {
        List<Diagnostico> list = repository.findAll();
        List<DiagnosticoDTO> listDto = list.stream().map(x -> new DiagnosticoDTO(x)).collect(Collectors.toList());
        return listDto;
    }

    @Transactional(readOnly = true)
    public DiagnosticoDTO findById(Long id) {
        Optional<Diagnostico> obj = repository.findById(id);
        Diagnostico entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new DiagnosticoDTO(entity);
    }

    @Transactional
    public DiagnosticoDTO insert(DiagnosticoDTO dto) {
        Diagnostico entity = new Diagnostico();
        dtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new DiagnosticoDTO(entity);
    }
    @Transactional
    public DiagnosticoDTO update(DiagnosticoDTO dto, Long id) {
        try {
            Diagnostico entity = repository.getOne(id);
            dtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new DiagnosticoDTO(entity);
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

    private void dtoToEntity(DiagnosticoDTO dto, Diagnostico entity){
        entity.setDisco(dto.getDisco());
        entity.setProcessador(dto.getProcessador());
        entity.setRam(dto.getRam());
    }



}

