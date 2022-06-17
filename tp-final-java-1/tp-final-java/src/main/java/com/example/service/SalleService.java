package com.example.service;

import com.example.model.Cours;
import com.example.model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    public Iterable<Salle> getAllSalle() {
        return this.salleRepository.findAll();
    }

    public Salle saveSalle(Salle salle) {
        return this.salleRepository.save(salle);
    }

    public void delSalle(long idSalle) {
        this.salleRepository.deleteById(idSalle);
    }

    public Optional<Salle> getSalleById(Long id) {
        Optional<Salle> salles = this.salleRepository.findById(id);
        return salles;
    }

}
