package cz.jty.text_enlargement.controller;

import cz.jty.text_enlargement.dto.TextDTO;
import cz.jty.text_enlargement.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping("/text")
    public String renderApp(@ModelAttribute TextDTO textDTO){
        return "text";
    }

    @PostMapping("/text")
    public String enlargeText(@ModelAttribute TextDTO textDTO, Model model){
        String enlargedText= textService.enelargeText(textDTO);
        model.addAttribute("enlargedText", enlargedText);
        return "text";
    }




}
