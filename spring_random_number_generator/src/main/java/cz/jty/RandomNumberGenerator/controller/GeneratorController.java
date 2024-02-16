package cz.jty.RandomNumberGenerator.controller;

import cz.jty.RandomNumberGenerator.model.GeneratorDTO;
import cz.jty.RandomNumberGenerator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generator")
public class GeneratorController {
    @Autowired
    private GeneratorService generatorService;

    @GetMapping
    public String renderGenerator(@ModelAttribute GeneratorDTO generatorDTO){

        return "generator";
    }

    @PostMapping
    public String generate(@ModelAttribute GeneratorDTO generatorDTO, Model model){
        Integer generatorResult = generatorService.generate(generatorDTO);
        model.addAttribute("generatedNumber", generatorResult);
        return "generator";
    }

}
