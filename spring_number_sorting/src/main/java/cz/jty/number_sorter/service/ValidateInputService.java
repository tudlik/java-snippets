package cz.jty.number_sorter.service;

import cz.jty.number_sorter.dto.InputTextDTO;
import cz.jty.number_sorter.dto.NumbersDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class ValidateInputService {
    NumbersDTO numbersDTO;

    public NumbersDTO validateNumbers(InputTextDTO inputTextDTO){
        numbersDTO=new NumbersDTO();
        String[] splitedText;
        int sum=0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        ArrayList <Integer> numbers = new ArrayList<>();

        splitedText=inputTextDTO.getTextInput().split(" ");
        for(String text : splitedText){
            String numberInString =  validateNumbers(text);
            if (numberInString.length()==0){
                continue;
            }
            int number = Integer.parseInt(numberInString);
            numbers.add(number);
            sum+=number;
            if(number<min){
                min=number;
            }
            if(number>max){
                max=number;
            }

        }
        if (numbers.size()==0){
            return null;
        }


        numbersDTO.setMin(min);
        numbersDTO.setMax(max);
        numbersDTO.setSum(sum);
        numbersDTO.setAvg((double)sum/numbers.size());

        numbersDTO.getListOfNumbers().clear();

        if (inputTextDTO.isAscOrder()){
            Collections.sort(numbers);
            numbersDTO.setListOfNumbers(numbers);
        }else{
            Collections.sort(numbers, Collections.reverseOrder());
            numbersDTO.setListOfNumbers(numbers);
        }

        return numbersDTO;
    }

    private String validateNumbers (String text){
        StringBuilder validatedText = new StringBuilder();
        for(char character: text.toCharArray()){
            if(Character.isDigit(character)){
                validatedText.append(character);
            }
        }
        return validatedText.toString();
    }
}
