package com.factoriaf5.clinicadental.controllers;

import java.util.List;


// import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.factoriaf5.clinicadental.models.Perfil;
import com.factoriaf5.clinicadental.service.PerfilService;

@RestController
@RequestMapping(path = "/api/perfil")
public class PerfilController {
  private PerfilService service;

  public PerfilController (PerfilService service){
    this.service = service;
  }

  @GetMapping("")
    public List<Perfil> listAll() {
        return service.getAll();
    }
  @GetMapping("{/id}")
  public Perfil listOne(@PathVariable Long id) {
    return service.getOne(id);
  }

  @PostMapping("")
  @ResponseStatus( value = HttpStatus.CREATED)
  public ResponseEntity<?> store(@RequestBody Perfil newprofile){

  try{
    return ResponseEntity.ok(service.save(newprofile));
} catch(Exception e){
    return ResponseEntity.status(500).body("error");
}
}
@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

  }













