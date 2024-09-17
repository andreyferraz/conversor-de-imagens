package com.conversor.conversor_de_imagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.conversor.conversor_de_imagens.services.ImageConverterService;

@Controller
public class ImageConverterViewController {

    @Autowired
    private ImageConverterService imageConverterService;

    @GetMapping("/converter")
    public String converter(Model model) {
        model.addAttribute("imageConverterService", imageConverterService);
        return "converter";
    }
}
