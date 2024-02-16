package cz.jty.number_sorter.controller;

import cz.jty.number_sorter.dto.InputTextDTO;
import cz.jty.number_sorter.dto.NumbersDTO;
import cz.jty.number_sorter.service.ValidateInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SorterController {

    @Autowired
    ValidateInputService validateInputService;

    @GetMapping("/sorter")
    public String renderApp(@ModelAttribute InputTextDTO inputTextDTO){
        return "sorter";
    }

    @PostMapping("/sorter")
    public String validateInput(@ModelAttribute InputTextDTO inputTextDTO, Model model){
        NumbersDTO statistics = validateInputService.validateNumbers(inputTextDTO);
        model.addAttribute("statistics", statistics);
        return "sorter";
    }
}
