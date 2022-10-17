package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.entities.Medico;
import com.usa.reto3.reto3.repository.crudRepository.MedicoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicoRepository {
    @Autowired
    private MedicoCrudRepository medicoCrudRepository;

    public List<Medico> getAll(){
        return (List<Medico>) medicoCrudRepository.findAll();
    }
    public Optional<Medico> getComputer(int id){
        return medicoCrudRepository.findById(id);
    }
    public Medico save(Medico medico){
        return medicoCrudRepository.save(medico);
    }
    public void delete(Medico medico){
        medicoCrudRepository.delete(medico);
    }
    /*
    public List<Object[]> getTopByYear(){
        return medicoCrudRepository.countTotalComputersByYear()
    }*/
}
