package br.com.fiap.caloriescounter.dto;

import br.com.fiap.caloriescounter.model.Food;

public record RegisterFoodDTO(
        Long foodId,
        String name,
        String portionWeight,
        Double protein,
        Double carbs,
        Double fats
) {
//    public RegisterFoodDTO(Food food) {
//        this (
//                food.getFoodId(),
//                food.getName(),
//                food.getPortionWeight(),
//                food.getProtein(),
//                food.getCarbs(),
//                food.getFats()
//        );
//    }
}