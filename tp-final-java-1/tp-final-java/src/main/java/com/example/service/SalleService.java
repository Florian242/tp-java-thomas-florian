package com.example.service;

import com.example.model.Salle;
import com.example.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

}
