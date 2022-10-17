package com.usa.reto3.reto3.controller;


import com.usa.reto3.reto3.entities.Medico;
import com.usa.reto3.reto3.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*")

public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @GetMapping("/all")
    public List<Medico> getMedico(){
        return medicoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Medico> getMedico(@PathVariable("id") int medicoId) {
        return medicoService.getMedico(medicoId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico save(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico update(@RequestBody Medico medico) {
        return medicoService.update(medico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return medicoService.deleteMedico(id);
    }


}
