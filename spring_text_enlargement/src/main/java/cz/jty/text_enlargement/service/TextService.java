package cz.jty.text_enlargement.service;

import cz.jty.text_enlargement.dto.TextDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class TextService {
    public String enelargeText(@ModelAttribute TextDTO textDTO){
        return textDTO.getText().toUpperCase();
    }
}
