package cz.jty.calculator.service;

import cz.jty.calculator.model.CalculatorDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public float calculate(CalculatorDTO calculatorDTO){
        float result= 0f;
        switch (calculatorDTO.getOperation()){
            case "+":
                result=calculatorDTO.getNumber1()+calculatorDTO.getNumber2();
                break;
            case "-":
                result=calculatorDTO.getNumber1()-calculatorDTO.getNumber2();
                break;
            case "*":
                result=calculatorDTO.getNumber1()*calculatorDTO.getNumber2();
                break;
            case "/":
            {
                if(calculatorDTO.getNumber2()!=0){
                    result=calculatorDTO.getNumber1()/calculatorDTO.getNumber2();
                    break;
                }else {
                    throw new IllegalArgumentException("Second number cannot be O!");
                }
            }

        }
        return  result;
    }
}
