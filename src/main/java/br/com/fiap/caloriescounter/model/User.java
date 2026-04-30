package br.com.fiap.caloriescounter.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table (name="tbl_users")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USERS"
    )
    @SequenceGenerator(
            name = "SEQ_USERS",
            sequenceName = "SEQ_USERS",
            allocationSize = 1
    )
    @Column(name="user_id")
    private Long userId;
    private String name;
    private String email;
    private String password;
}
