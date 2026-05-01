package br.com.fiap.caloriescounter.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TBL_FOOD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Food {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_FOODS"
    )
    @SequenceGenerator(
            name = "SEQ_FOODS",
            sequenceName = "SEQ_FOODS",
            allocationSize = 1
    )
    private Long foodId;

    private String name;

    @Column(name = "portion_weight")
    private String portionWeight;

    private Double protein;
    private Double carbs;
    private Double fats;

    @Column(name = "total_calories")
    private Double totalCalories;
}
