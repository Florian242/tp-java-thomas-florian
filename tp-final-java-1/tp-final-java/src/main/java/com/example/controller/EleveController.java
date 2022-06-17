package com.example.controller;

import com.example.model.Eleve;

import com.example.service.EleveService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller

public class EleveController {

    @Autowired
    public EleveService eleveService;


    @RequestMapping("/")
    String index(){
        return "index";
    }


    @GetMapping("/listEleves")
    String getAll(Model model){
        Iterable<Eleve> eleves = eleveService.getAll();
        model.addAttribute("eleves", eleves);
        return "listEleves";
    }

    @GetMapping("/addEleve")
    String addEleve(Model model){
        Eleve eleve = new Eleve();
        model.addAttribute("eleve", eleve);
        return "addEleve";
    }

    @PostMapping("/listEleves")
    public String eleves(@ModelAttribute("eleve") Eleve eleve) {
        eleveService.saveEleve(eleve);
        return "redirect:/listEleves";
    }

    @GetMapping("/deleteEleve")
    public String deleteEleve(@RequestParam Long eleveId) {
        eleveService.delEleve(eleveId);
        return "redirect:/listEleves";
    }

    @GetMapping("/modificationEleve/{id}/modifier")
    public String modificationEleve(@PathVariable("id") Long id, Model model) {

        Optional<Eleve> modifie = eleveService.getEleveById(id);
        model.addAttribute("eleve", modifie.get());
        return "eleveUpdate";
    }

    @PostMapping("/listEleves/{id}/update")
    public String modificationELeve(@PathVariable("id") Long id, @Validated Eleve eleve, BindingResult result,Model model){
        eleve.setId(id);
        eleveService.saveEleve(eleve);
        model.addAttribute("eleves", eleveService.getAll());
        return "listEleves";
    }



}
