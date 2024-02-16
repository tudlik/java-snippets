package cz.jty.spring_basics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/") //slouceni vsech kontroleru - pokracuje se za lomitkem, muze tam byt preddefinovana jina adresa napriklad /test    a jine
public class GreetingsController {

    @GetMapping("/ahoj")
    public  @ResponseBody String ahoj(){        // anotace @ResponseBody umoznuje vypsat text bez sablony

        return "ahoj";
    }

    @GetMapping("/{name}")
    public @ResponseBody String jmeno (@PathVariable ("name") String name){

        return "tve jmeno je "+ name;
    }

    @GetMapping("/sablona/pozdrav")
    public String sablona(){

        return "sablona";       // vraceni sablony, ktera je ulozena v resources-> templates
    }
}
