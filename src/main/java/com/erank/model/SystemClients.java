package com.erank.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="system_client", uniqueConstraints = {
		@UniqueConstraint(columnNames ="system_client_id")
})
public class SystemClients implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "system_client_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long system_client_id;
	
	@Column(name = "company_name")
	private String company_name; 
	
	@Column(name="registered_id")
	private Long registered_id;
	
	@Column(name="client_name")
	private @NonNull String client_name;
	
	@Column(name="category")
	private String category;
	
	@Column(name = "phNum")
	private @NonNull String phNum;
	
	@Email
	@Column(name = "email")
    private @NonNull String email;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_date")
	private LocalDateTime created_date;
	
	@Column(name="modified_date")
	private LocalDateTime modified_date;
	
	@ManyToOne(targetEntity=SystemDomain.class,fetch = FetchType.LAZY)
    @JoinColumn(name="system_domain_id ",nullable=false, referencedColumnName="system_domain_id")
    @JsonIgnoreProperties(value = {"systemDomain", "hibernateLazyInitializer"})       
    private SystemDomain systemDomain;
	
}
