package com.bustech.bustech.resources;

import com.bustech.bustech.dto.DiagnosticoDTO;
import com.bustech.bustech.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/diagnosticos")
public class DiagnosticoResource {

    @Autowired
    private DiagnosticoService service;

    @GetMapping
    public ResponseEntity<List<DiagnosticoDTO>> findAll(){
        List<DiagnosticoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<DiagnosticoDTO> findById(@PathVariable Long id){
        DiagnosticoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DiagnosticoDTO> insert(@RequestBody DiagnosticoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<DiagnosticoDTO> update(@PathVariable Long id, @RequestBody DiagnosticoDTO dto){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DiagnosticoDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
