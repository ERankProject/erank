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
	

	@ManyToOne(targetEntity=ServicesTable.class,fetch = FetchType.LAZY)
    @JoinColumn(name="services_id ",nullable=false, referencedColumnName="services_id")
    @JsonIgnoreProperties(value = {"serviceTable", "hibernateLazyInitializer"})       
    private ServicesTable serviceTable;
	
	@ManyToOne(targetEntity=Options.class,fetch = FetchType.LAZY)
    @JoinColumn(name="question_type_id ",nullable=false, referencedColumnName="question_type_id")
    @JsonIgnoreProperties(value = {"optionsTable", "hibernateLazyInitializer"})       
    private Options optionsTable;
	
	@JsonIgnore
	@OneToMany(targetEntity=UserSurvey.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<UserSurvey> userSurvey = new HashSet<UserSurvey>(0);
	
}
