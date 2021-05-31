package com.bustech.bustech.resources;

import com.bustech.bustech.dto.MaquinasDTO;
import com.bustech.bustech.services.MaquinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/maquinas")
public class MaquinasResource {

    @Autowired
    private MaquinasService service;

    @GetMapping
    public ResponseEntity<List<MaquinasDTO>> findAll(){
        List<MaquinasDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<MaquinasDTO> findById(@PathVariable Long id){
        MaquinasDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<MaquinasDTO> insert(@RequestBody MaquinasDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<MaquinasDTO> update(@PathVariable Long id, @RequestBody MaquinasDTO dto){
        dto = service.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MaquinasDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
