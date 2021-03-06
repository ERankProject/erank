package com.erank.repo;

import java.util.Optional;

import com.erank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User>findByEmail(String email);
	
	Boolean existsByEmail(String email);
}
