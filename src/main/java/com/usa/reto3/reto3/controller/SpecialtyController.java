package com.usa.reto3.reto3.controller;

import com.usa.reto3.reto3.entities.Specialty;
import com.usa.reto3.reto3.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*")

public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public SpecialtyService getSpecialtyService() {
        return specialtyService;
    }

    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int Id) {
        return specialtyService.getSpecialty(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty) {
        return specialtyService.save(specialty);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty){
        return specialtyService.update(specialty);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return specialtyService.deleteSpecialty(id);
    }

}