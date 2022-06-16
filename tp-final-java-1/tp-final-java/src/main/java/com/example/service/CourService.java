package com.example.service;

import com.example.demo.Cour;
import com.example.demo.Salle;
import com.example.repository.CourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourService {
    @Autowired
    private CourRepository courRepository;

    public Iterable<Cour> getAllCour() {
        return this.courRepository.findAll();
    }

    public Cour saveCour(Cour cour) {
        return this.courRepository.save(cour);
    }

    public void delCour(long idSalle) {
        this.courRepository.deleteById(idSalle);
    }

}
