package com.example.repository;

import com.example.demo.Cour;
import com.example.demo.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourRepository extends JpaRepository<Cour,Long> {
}
