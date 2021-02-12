package com.erank.model;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user", uniqueConstraints = {
		@UniqueConstraint(columnNames ="userid")
})
public class User implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private @NonNull String name;
	
	@Email
	@Column(name = "email")
    private @NonNull String email;
	
	private String imageUrl;
	
	@Column(nullable = true)
	private Boolean emailVerified = true; 
	
	@Column(name = "phNum")
	private @NonNull String phNum;

	@JsonIgnore
	private String password;
	
	@Enumerated
	private AuthProvider provider;
	
	private @NonNull String providerId;
	
	@Column(name = "created_date")
	private LocalDate created_date = LocalDate.now();
	
	@Column(name = "modified_date")
	private LocalDate modified_date;
//	@JsonIgnore
//	@OneToMany(targetEntity=UserSurvey.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
//	private Set<UserSurvey> userSurvey = new HashSet<UserSurvey>(0);
    
//	@JsonIgnore
// 	@OneToMany(targetEntity=UserSurvey.class,fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private UserSurvey userSurvey;
	
}
