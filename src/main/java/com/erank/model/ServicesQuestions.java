package com.erank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="service_questions", uniqueConstraints = {
		@UniqueConstraint(columnNames ="servicesquestion_id")
})
public class ServicesQuestions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "servicesquestion_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long servicesquestion_id;
	
	@Column(name = "question")
	private String question; 
	
	@Column(name = "is_option_enabled", nullable = true)
	private Boolean is_option_enabled = false;
	
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
	
	@ManyToOne(targetEntity=ServicesTable.class,fetch = FetchType.LAZY)
    @JoinColumn(name="services_id ",nullable=false, referencedColumnName="services_id")
    @JsonIgnoreProperties(value = {"serviceTable", "hibernateLazyInitializer"})       
    private ServicesTable serviceTable;
	
	@JsonIgnore
	@OneToMany(targetEntity=UserSurvey.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<UserSurvey> userSurvey = new HashSet<UserSurvey>(0);
	
}
