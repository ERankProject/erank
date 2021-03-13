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
@Table(name ="system_domain", uniqueConstraints = {
		@UniqueConstraint(columnNames ="system_domain_id")
})
public class SystemDomain {

	@Id
	@Column(name = "system_domain_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long system_domain_id;
	
	@Column(name = "domain_name")
	private String domain_name; 
	
	@JsonIgnore
	@OneToMany(targetEntity=SystemClients.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<SystemClients> systemClients = new HashSet<SystemClients>(0);
}
	
