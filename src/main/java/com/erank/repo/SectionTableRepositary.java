package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erank.dto.SectionTableDto;
import com.erank.model.SectionTable;


public interface SectionTableRepositary extends JpaRepository<SectionTable, Long>{

	SectionTable save(SectionTableDto secTab); 

}
