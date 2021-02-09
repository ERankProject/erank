package com.erank.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="options_table", uniqueConstraints = {
		@UniqueConstraint(columnNames ="question_type_id")
})
public class Options {
	
	@Id
	@Column(name = "question_type_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long question_type;

	@Column(name = "is_option_enabled", nullable = true)
	private Boolean is_option_enabled = true;
	
	@Column(name = "is_description_enabled", nullable = true)
	private Boolean is_description_enabled = false;
	
	@Column(name = "is_rating_enabled", nullable = true)
	private Boolean is_rating_enabled = false;
	
	@Column(name = "is_default_enabled", nullable = true)
	private Boolean is_default_enabled = true;
	
	@Column(name = "option_1")
	private String option_1;
	
	@Column(name = "option_2")
	private String option_2;
	
	@Column(name = "option_3")
	private String option_3; 
	
	@Column(name = "option_4")
	private String option_4;
	
	@Column(name = "option_5")
	private String option_5;
	
	@Column(name = "option_6")
	private String option_6;
	
	
	@JsonIgnore
	@OneToMany(targetEntity=ServicesQuestions.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<ServicesQuestions> questions = new HashSet<ServicesQuestions>(0);
	
}
