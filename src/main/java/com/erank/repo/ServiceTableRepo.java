package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.model.ServicesTable;

@Repository
public interface ServiceTableRepo extends JpaRepository<ServicesTable, Long>{

}
