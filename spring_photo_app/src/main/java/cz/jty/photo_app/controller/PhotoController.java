package cz.jty.photo_app.controller;

import cz.jty.photo_app.entity.PhotoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {

    @GetMapping("/ahoj")
    public @ResponseBody String greeting(){
        return "Hi, how are you :-)";
    }





}
