package it.domenico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.domenico.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.nome LIKE %:name%")
	List<User> findByNameSimilarities(String name);

	@Query("SELECT u FROM User u WHERE u.cognome LIKE %:lastname%")
	List<User> findByLastNameSimilarities(String lastname);

}
