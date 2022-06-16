package com.example.controller;

import com.example.demo.Eleve;
import com.example.demo.Salle;
import com.example.service.SalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalleController {
    @Autowired
    public SalleService salleService;

    @GetMapping("/listSalles")
    String getAll(Model model){
        Iterable<Salle> salles = salleService.getAllSalle();
        model.addAttribute("salles", salles);
        return "listSalles";
    }
    @GetMapping("/addSalle")
    String addSalle(Model model){
        Salle salle = new Salle();
        model.addAttribute("salle", salle);
        return "addSalle";
    }

    @PostMapping("/listSalles")
    public String salles(@ModelAttribute("salle") Salle salle) {
        salleService.saveSalle(salle);
        return "redirect:/listSalles";
    }

    @GetMapping("/deleteSalle")
    public String deleteSalle(@RequestParam Long salleId) {
        salleService.delSalle(salleId);
        return "redirect:/listSalles";
    }
}
