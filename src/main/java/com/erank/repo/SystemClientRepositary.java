package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.model.SystemClients;


@Repository
public interface SystemClientRepositary extends JpaRepository<SystemClients, Long>{

}
