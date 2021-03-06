package br.com.mai05.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mai05.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
     Optional<User> findByLogin(String login);

}
