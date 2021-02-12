package com.erank.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="service_table", uniqueConstraints = {
		@UniqueConstraint(columnNames ="services_id")
})
public class ServicesTable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "services_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long services_id;
	
	@Column(name = "service_name")
	private String service_name; 
	
	@Column(name = "is_enabled", nullable = true)
	private Boolean is_enabled = true;
	
	
	@JsonIgnore
	@OneToMany(targetEntity=ServicesQuestions.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<ServicesQuestions> serviceQuestions = new HashSet<ServicesQuestions>(0);
	
	@JsonIgnore
	@OneToMany(targetEntity=UserSurvey.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<UserSurvey> userSurvey = new HashSet<UserSurvey>(0);
}
