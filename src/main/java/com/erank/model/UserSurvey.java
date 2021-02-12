package com.erank.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user_survey", uniqueConstraints = {
		@UniqueConstraint(columnNames ="user_survey_id")
})
public class UserSurvey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_survey_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "response")
	private Long response; 
	
	@Column(name = "response_label")
	private String response_label; 
	
	@Column (name = "patient_name")
	private String patient_name;
	
	@Column (name = "uhid_no")
	private String uhid_no;
	
	@Column(name = "phNum")
	private String phNum;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="score")
	private Long score;
	
	@Column(name="created_date")
	private LocalDate created_date;
	
	@Column(name="service_name")
    private String service_name;
	
	@ManyToOne(targetEntity=ServicesQuestions.class,fetch = FetchType.LAZY)
    @JoinColumn(name="servicesquestion_id ",nullable=false, referencedColumnName="servicesquestion_id")
    @JsonIgnoreProperties(value = {"servicesQuestions", "hibernateLazyInitializer"})       
    private ServicesQuestions servicesQuestions;
	
	@ManyToOne(targetEntity=ServicesTable.class,fetch = FetchType.LAZY)
    @JoinColumn(name="services_id ",nullable=false, referencedColumnName="services_id")
    @JsonIgnoreProperties(value = {"serviceTable", "hibernateLazyInitializer"})       
    private ServicesTable serviceTable; 
	
//	@ManyToOne(targetEntity=User.class,fetch = FetchType.LAZY)
//    @JoinColumn(name="userid ",nullable=false, referencedColumnName="userid")
//    @JsonIgnoreProperties(value = {"user", "hibernateLazyInitializer"})       
//    private User user;
	
	
}
