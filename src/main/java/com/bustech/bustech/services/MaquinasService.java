package com.bustech.bustech.services;

import com.bustech.bustech.dto.MaquinasDTO;
import com.bustech.bustech.entities.Maquinas;
import com.bustech.bustech.repositories.MaquinasRepository;
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
public class MaquinasService {

    @Autowired
    private MaquinasRepository repository;

    @Transactional(readOnly = true)
    public List<MaquinasDTO> findAll() {
        List<Maquinas> list = repository.findAll();
        List<MaquinasDTO> listDto = list.stream().map(x -> new MaquinasDTO(x, x.getDiagnosticos())).collect(Collectors.toList());
        return listDto;
    }

    @Transactional(readOnly = true)
    public MaquinasDTO findById(Long id) {
        Optional<Maquinas> obj = repository.findById(id);
        Maquinas entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new MaquinasDTO(entity, entity.getDiagnosticos());
    }

    @Transactional
    public MaquinasDTO insert(MaquinasDTO dto) {
        Maquinas entity = new Maquinas();
        dtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new MaquinasDTO(entity);
    }
    @Transactional
    public MaquinasDTO update(MaquinasDTO dto, Long id) {
        try {
            Maquinas entity = repository.getOne(id);
            dtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new MaquinasDTO(entity);
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

    private void dtoToEntity(MaquinasDTO dto, Maquinas entity){
        entity.setId(dto.getId());
        entity.setUsuario(dto.getUsuario());
        entity.setSenha(dto.getSenha());
        entity.setTipo(dto.getTipo());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setAtivo(dto.getAtivo());
        entity.setMaxCpu(dto.getMaxCpu());
        entity.setMaxDisco(dto.getMaxDisco());
        entity.setMaxRam(dto.getMaxRam());
    }



}

