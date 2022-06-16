package com.example.controller;


import com.example.model.Niveau;
import com.example.service.CoursService;
import com.example.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}

