package com.example.controller;


import com.example.model.Niveau;
import com.example.model.Salle;
import com.example.service.CoursService;
import com.example.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class NiveauController {
    @Autowired
    public NiveauService niveauService;

    @GetMapping("/listNiveau")
    String getAll(Model model){
        Iterable<Niveau> niveau = niveauService.getAllNiveau();
        model.addAttribute("niveau", niveau);
        return "listNiveau";
    }
    @GetMapping("/addNiveau")
    String addCours(Model model){
        Niveau niveau = new Niveau();
        model.addAttribute("niveau", niveau);
        return "addNiveau";
    }

    @PostMapping("/listNiveau")
    public String Cours(@ModelAttribute("niveau") Niveau niveau) {
        niveauService.saveNiveau(niveau);
        return "redirect:/listNiveau";
    }

    @GetMapping("/deleteNiveau")
    public String deleteCours(@RequestParam Long niveauId) {
        niveauService.delNiveau(niveauId);
        return "redirect:/listNiveau";
    }

    @GetMapping("/modificationNiveau/{id}/modifier")
    public String modificationCours(@PathVariable("id") Long id, Model model) {

        Optional<Niveau> modifie = niveauService.getNiveauById(id);
        model.addAttribute("niveau", modifie.get());
        return "niveauUpdate";
    }

    @PostMapping("/listNiveau/{id}/update")
    public String modificationELeve(@PathVariable("id") Long id, @Validated Niveau niveaux, BindingResult result, Model model){
        niveaux.setId(id);
        niveauService.saveNiveau(niveaux);
        model.addAttribute("niveaux", niveauService.getAllNiveau());
        return "listNiveau";
    }

}

