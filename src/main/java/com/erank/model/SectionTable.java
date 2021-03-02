package com.erank.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="section_table", uniqueConstraints = {
		@UniqueConstraint(columnNames ="section_id")
})
public class SectionTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  
	
	
	@Id
	@Column(name = "section_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long section_id;
	
	@Column(name = "section_name")
	private String section_name; 
	
	@Column(name = "is_enabled", nullable = true)
	private Boolean is_enabled = true;
	
	@Column(name= "created_date")
	private LocalDate created_date;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name= "modified_date")
	private LocalDate modified_date;
	
	
	@Column(name="modified_by")
	private String modified_by;
	
//	@ManyToOne(targetEntity=ServicesTable.class,fetch = FetchType.LAZY)
//    @JoinColumn(name="services_id ",nullable=false, referencedColumnName="services_id")
//    @JsonIgnoreProperties(value = {"serviceTable", "hibernateLazyInitializer"})       
//    private ServicesTable serviceTable;
	
	
	@JsonIgnore
	@OneToMany(targetEntity=ServicesQuestions.class,cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<ServicesQuestions> serviceQuestions = new HashSet<ServicesQuestions>(0);
	
	
	
}
