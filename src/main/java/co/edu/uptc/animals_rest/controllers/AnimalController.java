package co.edu.uptc.animals_rest.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.edu.uptc.animals_rest.models.Animal;
import co.edu.uptc.animals_rest.services.AnimalService;




@RestController
@RequestMapping("/animal")
public class AnimalController {

    private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @Autowired
    private AnimalService animalService;


    @GetMapping("/all")
    public List<Animal> getAnimalAll() throws IOException {
        logger.info("getAnimalAll called");
        return animalService.getAnimalAll();
    }

    @GetMapping("/range")
    public List<Animal> getAnimal(@RequestParam int from, @RequestParam int to) throws IOException {
        logger.info("getAnimal called with parameters: from = {}, to = {}", from, to);
        return animalService.getAnimalInRange(from, to);
    }

    @GetMapping(path ="/category/{category}")
    public List<Animal> getAnimalCategory(@PathVariable("category") String category) throws IOException {
        logger.info("getAnimal called with parameters: from = {}",category);
        return animalService.getAnimalCategory(category);
    }

    @GetMapping(path = "/name-length/{numberOfLetters}")
    public List<Animal> getAnimalName_Length(@PathVariable("numberOfLetters")String numberOfLetters) throws IOException {
        logger.info("getAnimal called with name of length : from = {}",numberOfLetters);
        return animalService.getAnimalNameLength(numberOfLetters);
    }

}
