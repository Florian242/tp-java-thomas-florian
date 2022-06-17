package com.example.service;


import com.example.model.Niveau;
import com.example.model.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NiveauService {
        @Autowired
        private NiveauRepository niveauRepository;

        public Iterable<Niveau> getAllNiveau() {
            return this.niveauRepository.findAll();
        }

        public Niveau saveNiveau(Niveau niveau) {
            return this.niveauRepository.save(niveau);
        }

        public void delNiveau(long idNiveau) {
            this.niveauRepository.deleteById(idNiveau);
        }

        public Optional<Niveau> getNiveauById(Long id) {
        Optional<Niveau> niveaux = this.niveauRepository.findById(id);
        return niveaux;
    }


    }

