package com.example.controller;

import com.example.model.Eleve;

import com.example.service.EleveService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/modificationEleve/{id}")
    public String modificationEleve(@PathVariable Long id, BindingResult result, Model model) {

        Eleve modifie = eleveService.getEleveById(id).get();

        model.addAttribute("modifies", modifie);

        return "eleveUpdate";
    }



}
