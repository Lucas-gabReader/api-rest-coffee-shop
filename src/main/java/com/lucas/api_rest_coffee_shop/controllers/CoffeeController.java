package com.lucas.api_rest_coffee_shop.controllers;

import com.lucas.api_rest_coffee_shop.models.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.lucas.api_rest_coffee_shop.repositories.CoffeeRepository;

import java.util.List;


@RestController
@RequestMapping("/coffe")
public class CoffeeController{


        @Autowired
        CoffeeRepository coffeeRepository;
        //listar todos os cafes
        @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Coffee> getAllCoffee(){
            return coffeeRepository.findAll();
        }
        //atualizar um cafe
        @PutMapping(value = "uptadeCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        public  Coffee uptadeCoffee(@RequestBody Coffee coffee){
            Coffee getCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();

            Coffee uptadeCoffee = new Coffee();

            uptadeCoffee.setId(coffee.getId());
            uptadeCoffee.setName(coffee.getName());
            uptadeCoffee.setPrice(coffee.getPrice());

            return coffeeRepository.save(uptadeCoffee);
        }
        //deletar um cafe
        @DeleteMapping(value = "/deleteCoffee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public Coffee deleteCoffee(@PathVariable Long id) {
            Coffee getCoffee = coffeeRepository.findById(id).orElseThrow();
            coffeeRepository.delete(getCoffee);
            return getCoffee;

        }

       @PostMapping(value = "/createCoffee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
       public Coffee createNewCoffee(@RequestBody Coffee coffee){

            Coffee createCoffee = new Coffee();

            createCoffee.setName(coffee.getName());
            createCoffee.setPrice(coffee.getPrice());

            return coffeeRepository.save(createCoffee);
       }
}


