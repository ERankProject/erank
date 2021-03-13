package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erank.model.SystemClients;

import lombok.NonNull;


@Repository
public interface SystemClientRepositary extends JpaRepository<SystemClients, Long>{
  
	  
	boolean existsByEmail(@NonNull String email);
	
	@Query(nativeQuery = true, value="select * from system_client where email = :emailId And password = :passcode")
	SystemClients findByEmailId(@Param("emailId") String email, @Param("passcode") String password);
}
