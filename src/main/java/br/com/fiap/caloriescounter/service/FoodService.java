package br.com.fiap.caloriescounter.service;

import br.com.fiap.caloriescounter.dto.RegisterFoodDTO;
import br.com.fiap.caloriescounter.dto.ShowFoodDTO;
import br.com.fiap.caloriescounter.model.Food;
import br.com.fiap.caloriescounter.repository.FoodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    //CREATE
    public ShowFoodDTO saveFood(RegisterFoodDTO foodDTO) {
        Food food = new Food();
        BeanUtils.copyProperties(foodDTO, food);

        food.setTotalCalories(
                calculateCalories(
                        food.getProtein(),
                        food.getCarbs(),
                        food.getFats()
                )
        );

        Food savedFood = foodRepository.save(food);
        return new ShowFoodDTO(savedFood);
    }

    //READ
    public ShowFoodDTO findFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        if (food.isPresent()) {
            return new ShowFoodDTO(food.get());
        } else {
            throw new RuntimeException("Food not found");
        }
    }

    public List<ShowFoodDTO> findAllFoods() {
        return foodRepository
                .findAll()
                .stream()
                .map(ShowFoodDTO::new)
                .toList();
    }

    //UPDATE
    public ShowFoodDTO update(RegisterFoodDTO foodDTO) {
        Optional<Food> foodOptional = foodRepository.findById(foodDTO.foodId());

        if (foodOptional.isPresent()) {
            Food food = new Food();
            BeanUtils.copyProperties(foodDTO, food);

            food.setTotalCalories(
                    calculateCalories(
                        food.getProtein(),
                        food.getCarbs(),
                        food.getFats()
                    )
            );

            return new ShowFoodDTO(foodRepository.save(food));
        } else {
            throw new RuntimeException("Food not found");
        }
    }

    //DELETE
    public void delete(Long id) {
        Optional<Food> optionalFood = foodRepository.findById(id);

        if (optionalFood.isPresent()) {
            foodRepository.delete(optionalFood.get());
        } else {
            throw new RuntimeException("Food not found");
        }
    }

    private Double calculateCalories(Double protein, Double carbs, Double fats) {
        Double calories = (protein * 4) + (carbs * 4)  + (fats * 9);
        return calories;
    }
}
