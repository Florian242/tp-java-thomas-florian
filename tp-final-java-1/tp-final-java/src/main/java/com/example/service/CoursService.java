package com.example.service;

import com.example.model.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CoursService {
    @Autowired
    private CoursRepository coursRepository;

    public Iterable<Cours> getAllCours() {
        return this.coursRepository.findAll();
    }

    public Cours saveCours(Cours cours) {
        return this.coursRepository.save(cours);
    }

    public void delCours(long idSalle) {
        this.coursRepository.deleteById(idSalle);
    }

}
