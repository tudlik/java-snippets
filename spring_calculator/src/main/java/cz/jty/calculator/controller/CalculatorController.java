package cz.jty.calculator.controller;

import cz.jty.calculator.model.CalculatorDTO;
import cz.jty.calculator.model.TitleDTO;
import cz.jty.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping()
    public String renderCalculator(@ModelAttribute TitleDTO titleDTO, @ModelAttribute CalculatorDTO calculatorDTO){
        titleDTO.setTitle("Spring calculator");
        titleDTO.setSubTitle("podnadpis :-)");
        return "calculator";
    }

    @PostMapping
    public String calculate(@ModelAttribute CalculatorDTO calculatorDTO, Model model){
        float calculationResult = calculatorService.calculate(calculatorDTO);
        model.addAttribute("calculationResult", calculationResult);
        return "result";
    }

    @ExceptionHandler(IllegalArgumentException.class) // odchytavani vyjimek typu illegalArgumentException
    public String handleIllegalArgumentException(){
        return "invalid-form";
    }



}
