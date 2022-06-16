package com.example.controller;

import com.example.model.Cours;
import com.example.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
