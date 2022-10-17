package com.usa.reto3.reto3.service;


import com.usa.reto3.reto3.entities.Medico;
import com.usa.reto3.reto3.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> getAll(){
        return medicoRepository.getAll();
    }

    public Optional<Medico> getComputer(int id){
        return medicoRepository.getComputer(id);
    }

    public Medico save(Medico medico){
        if(medico.getId() == null){
            return medicoRepository.save(medico);
        }else{
            Optional<Medico> e = medicoRepository.getComputer(medico.getId());
            if(!e.isPresent()){
                return medicoRepository.save(medico);
            }else{
                return medico;
            }
        }
    }
    public Medico update(Medico medico){
        if(medico.getId() != null){
            Optional<Medico> e = medicoRepository.getComputer(medico.getId());
            if(e.isPresent()){
                if(medico.getName() != null) {
                    e.get().setName(medico.getName());
                }
                if(medico.getBrand() != null) {
                    e.get().setBrand(medico.getBrand());
                }
                if(medico.getYear() != null) {
                    e.get().setYear(medico.getYear());
                }
                if(medico.getDescription() != null) {
                    e.get().setDescription(medico.getDescription());
                }
                if(medico.getCategory() != null) {
                    e.get().setCategory(medico.getCategory());
                }
                medicoRepository.save(e.get());
                return e.get();
            }else{
                return medico;
            }
        }else{
            return medico;
        }
    }

    public boolean deleteComputer (int id){
        Boolean d = getComputer(id).map(computer -> {
            medicoRepository.delete(computer);
            return true;
        }).orElse(false);
        return d;
    }
}
