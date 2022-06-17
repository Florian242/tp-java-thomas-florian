package com.example.service;

import com.example.model.Cours;
import com.example.model.Eleve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Cours> getCoursById(Long id) {
        Optional<Cours> cours = this.coursRepository.findById(id);
        return cours;
    }

}
