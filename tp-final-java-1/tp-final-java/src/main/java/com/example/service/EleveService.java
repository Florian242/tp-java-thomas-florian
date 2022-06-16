package com.example.service;

import com.example.model.Eleve;
import com.example.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EleveService {
    @Autowired
    private EleveRepository eleveRepository;

    public Iterable<Eleve> getAll() {
        return this.eleveRepository.findAll();
    }

    public Eleve saveEleve(Eleve eleve) {
        return this.eleveRepository.save(eleve);
    }

    public void delEleve(long idEtudiant) {
        this.eleveRepository.deleteById(idEtudiant);
    }

    public Optional<Eleve> getEleveById(Long id) {
        Optional<Eleve> eleve = this.eleveRepository.findById(id);
        return eleve;
    }




}
