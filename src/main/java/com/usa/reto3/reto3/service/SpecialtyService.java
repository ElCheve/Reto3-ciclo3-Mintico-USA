package com.usa.reto3.reto3.service;


import com.usa.reto3.reto3.entities.Specialty;
import com.usa.reto3.reto3.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAll(){
        return specialtyRepository.getAll();
    }

    public Optional<Specialty> getSpecialty(int id){
        return specialtyRepository.getSpecialty(id);
    }

    public Specialty save(Specialty specialty){
        if(specialty.getId() == null){
            return specialtyRepository.save(specialty);
        }else{
            Optional<Specialty> specialty1 = specialtyRepository.getSpecialty(specialty.getId());
            if(!specialty1.isPresent()){
                return specialtyRepository.save(specialty);
            }else{
                return specialty;
            }
        }
    }
    public Specialty update(Specialty specialty){
        if(specialty.getId() != null){
            Optional<Specialty> g = specialtyRepository.getSpecialty(specialty.getId());
            if(g.isPresent()){
                if(specialty.getDescription() != null) {
                    g.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName() != null) {
                    g.get().setName(specialty.getName());
                }
                return specialtyRepository.save(g.get());
            }
        }
            return specialty;
    }

    public boolean deleteSpecialty (int id){
        Boolean d = getSpecialty(id).map(specialty -> {
            specialtyRepository.delete(specialty);
            return true;
        }).orElse(false);
        return d;
    }
}
