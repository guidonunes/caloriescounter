package br.com.fiap.caloriescounter.controller;

import br.com.fiap.caloriescounter.dto.RegisterFoodDTO;
import br.com.fiap.caloriescounter.dto.ShowFoodDTO;
import br.com.fiap.caloriescounter.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private FoodService foodService;

    //CREATE
    @PostMapping("/foods")
    @ResponseStatus(HttpStatus.CREATED)
    public ShowFoodDTO save(@RequestBody RegisterFoodDTO food) {
        return foodService.saveFood(food);
    }

    //READ
    @GetMapping("/foods")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowFoodDTO> findAll() {
        return foodService.findAllFoods();
    }

    @GetMapping("/foods/{foodId}")
    public ResponseEntity<ShowFoodDTO> findFoodById(@PathVariable Long foodId) {
        try {
            return ResponseEntity.ok(foodService.findFoodById(foodId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //UPDATE
    @PutMapping("/foods")
    public ResponseEntity<ShowFoodDTO> update(@RequestBody RegisterFoodDTO food) {
        try {
            ShowFoodDTO showFoodDTO = foodService.update(food);
            return ResponseEntity.ok(showFoodDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/foods/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}
