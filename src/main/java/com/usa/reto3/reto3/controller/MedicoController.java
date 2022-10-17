package com.usa.reto3.reto3.controller;


import com.usa.reto3.reto3.entities.Medico;
import com.usa.reto3.reto3.service.ComputerService;
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
    private ComputerService computerService;
    @GetMapping("/all")
    public List<Medico> getComputer(){
        return computerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Medico> getComputer(@PathVariable("id") int computerId) {
        return computerService.getComputer(computerId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico save(@RequestBody Medico medico) {
        return computerService.save(medico);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico update(@RequestBody Medico medico) {
        return computerService.update(medico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return computerService.deleteComputer(id);
    }


}
