package br.com.fiap.caloriescounter.repository;

import br.com.fiap.caloriescounter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
