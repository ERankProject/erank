package com.erank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erank.model.Options;


@Repository
public interface OptionsRepositary extends JpaRepository<Options, Long>{

}
