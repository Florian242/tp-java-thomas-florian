package com.example.repository;

import com.example.demo.Eleve;
import com.example.demo.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository  extends JpaRepository<Salle,Long> {
}
