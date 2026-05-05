package br.com.fiap.caloriescounter.repository;

import br.com.fiap.caloriescounter.dto.ShowFoodDTO;
import br.com.fiap.caloriescounter.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("SELECT a FROM Food a WHERE a.name = :name")
    Optional<Food> findByName(@Param("name") String name);

    @Query("SELECT a FROM Food a WHERE a.totalCalories BETWEEN :minimum AND :maximum ORDER BY a.totalCalories DESC")
    List<Food> listFoodByCalorieRange(
            @Param("minimum") Double minimum,
            @Param("maximum") Double maximum
    );

    List<ShowFoodDTO> findByTotalCaloriesLessThan(Double calories);
}
