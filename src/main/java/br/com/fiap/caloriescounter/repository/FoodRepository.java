package br.com.fiap.caloriescounter.repository;

import br.com.fiap.caloriescounter.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
