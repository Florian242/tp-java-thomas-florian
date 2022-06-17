package com.example.controller;

import com.example.model.Cours;
import com.example.model.Salle;
import com.example.service.SalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/modificationSalle/{id}/modifier")
    public String modificationCours(@PathVariable("id") Long id, Model model) {

        Optional<Salle> modifie = salleService.getSalleById(id);
        model.addAttribute("salle", modifie.get());
        return "salleUpdate";
    }

    @PostMapping("/listSalles/{id}/update")
    public String modificationELeve(@PathVariable("id") Long id, @Validated Salle salles, BindingResult result, Model model){
        salles.setId(id);
        salleService.saveSalle(salles);
        model.addAttribute("salles", salleService.getAllSalle());
        return "listSalles";
    }
}
