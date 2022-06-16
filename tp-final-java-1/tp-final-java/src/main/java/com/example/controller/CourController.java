package com.example.controller;

import com.example.model.Cour;
import com.example.service.CourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourController {
    @Autowired
    public CourService courService;

    @GetMapping("/listCours")
    String getAll(Model model){
        Iterable<Cour> cours = courService.getAllCour();
        model.addAttribute("cours", cours);
        return "listCours";
    }
    @GetMapping("/addCour")
    String addCour(Model model){
        Cour cour = new Cour();
        model.addAttribute("cour", cour);
        return "addCour";
    }

    @PostMapping("/listCours")
    public String Cours(@ModelAttribute("cour") Cour cour) {
        courService.saveCour(cour);
        return "redirect:/listCours";
    }

    @GetMapping("/deleteCour")
    public String deleteCour(@RequestParam Long courId) {
        courService.delCour(courId);
        return "redirect:/listCours";
    }

}
