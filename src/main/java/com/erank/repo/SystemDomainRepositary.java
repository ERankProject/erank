package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.model.SystemDomain;


@Repository
public interface SystemDomainRepositary extends JpaRepository<SystemDomain, Long>{
  
   
}
