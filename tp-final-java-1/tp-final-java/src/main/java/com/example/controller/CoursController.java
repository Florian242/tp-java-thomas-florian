package com.example.controller;

import com.example.model.Cours;
import com.example.model.Eleve;
import com.example.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CoursController {
    @Autowired
    public CoursService coursService;

    @GetMapping("/listCours")
    String getAll(Model model){
        Iterable<Cours> cours = coursService.getAllCours();
        model.addAttribute("cours", cours);
        return "listCours";
    }
    @GetMapping("/addCours")
    String addCours(Model model){
        Cours cours = new Cours();
        model.addAttribute("cours", cours);
        return "addCours";
    }

    @PostMapping("/listCours")
    public String Cours(@ModelAttribute("cours") Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/listCours";
    }

    @GetMapping("/deleteCour")
    public String deleteCours(@RequestParam Long courId) {
        coursService.delCours(courId);
        return "redirect:/listCours";
    }

    @GetMapping("/modificationCours/{id}/modifier")
    public String modificationCours(@PathVariable("id") Long id, Model model) {

        Optional<Cours> modifie = coursService.getCoursById(id);
        model.addAttribute("cour", modifie.get());
        return "coursUpdate";
    }

    @PostMapping("/listCours/{id}/update")
    public String modificationELeve(@PathVariable("id") Long id, @Validated Cours cours, BindingResult result, Model model){
        cours.setId(id);
        coursService.saveCours(cours);
        model.addAttribute("cours", coursService.getAllCours());
        return "listCours";
    }

}
