package com.bustech.bustech.resources;

import com.bustech.bustech.dto.EmpresasDTO;
import com.bustech.bustech.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresasResource {

    @Autowired
    private EmpresasService service;

    @GetMapping
    public ResponseEntity<List<EmpresasDTO>> findAll(){
        List<EmpresasDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<EmpresasDTO> findById(@PathVariable Long id){
        EmpresasDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<EmpresasDTO> insert(@RequestBody EmpresasDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<EmpresasDTO> update(@PathVariable Long id, @RequestBody EmpresasDTO dto){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EmpresasDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
