package br.com.fiap.caloriescounter.controller;

import br.com.fiap.caloriescounter.dto.RegisterFoodDTO;
import br.com.fiap.caloriescounter.dto.ShowFoodDTO;
import br.com.fiap.caloriescounter.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
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
    public Page<ShowFoodDTO> findAll(
            @PageableDefault(size=20, page=0)
            Pageable pageable
    ) {
        return foodService.findAllFoods(pageable);
    }

    @GetMapping("/foods/{foodId}")
    public ResponseEntity<ShowFoodDTO> findFoodById(@PathVariable Long foodId) {
        try {
            return ResponseEntity.ok(foodService.findFoodById(foodId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value ="/foods", params = "name")
    public ResponseEntity<ShowFoodDTO> findByName(@Param("name") String name) {
        try {
            return ResponseEntity.ok(foodService.findFoodByName(name));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/foods", params = {"minimum", "maximum"})
    @ResponseStatus(HttpStatus.OK)
    public List<ShowFoodDTO> listFoodByCalorieRange(
            @RequestParam Double minimum,
            @RequestParam Double maximum
    ) {
        return foodService.listFoodByCalorieRange(minimum, maximum);
    }

    @RequestMapping(value ="/foods", params = "caloriesLessThan")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowFoodDTO> listFoodByCalorieLessThan(
            @RequestParam Double caloriesLessThan
    ) {
        return foodService.getFoodByTotalCaloriesLessThan(caloriesLessThan);
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
    public void delete(@PathVariable Long foodId) {
        foodService.delete(foodId);
    }
}
