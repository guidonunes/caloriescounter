package br.com.fiap.caloriescounter.controller;

import br.com.fiap.caloriescounter.dto.RegisterFoodDTO;
import br.com.fiap.caloriescounter.dto.ShowFoodDTO;
import br.com.fiap.caloriescounter.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/foods")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowFoodDTO save(@RequestBody RegisterFoodDTO food) {
        return foodService.saveFood(food);
    }

}
