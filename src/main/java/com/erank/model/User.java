package com.erank.model;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user", uniqueConstraints = {
		@UniqueConstraint(columnNames ="email")
})
public class User {
 
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private @NonNull String name;
	
	@Email
	@Column(name = "email")
    private @NonNull String email;
	
	private String imageUrl;
	
	@Column(nullable = false)
	private Boolean emailVerified = false; 
	
	@Column(name = "phNum")
	private @NonNull String phNum;

	@JsonIgnore
	private String password;
	
	@Enumerated
	private AuthProvider provider;
	
	private @NonNull String providerId;
	
}
