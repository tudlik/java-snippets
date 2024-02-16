package cz.jty.RandomNumberGenerator.service;

import cz.jty.RandomNumberGenerator.model.GeneratorDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {
    private Random random;
    public Integer generate(GeneratorDTO generatorDTO) {

        random = new Random();
        if (generatorDTO.getNumber1() <= generatorDTO.getNumber2()) {
            return random.nextInt(generatorDTO.getNumber2() - generatorDTO.getNumber1() + 1) + generatorDTO.getNumber1();
        } else {
            return null;
        }
    }

  }

