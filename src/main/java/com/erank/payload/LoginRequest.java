package com.erank.payload;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
 
	@Email
	private @NonNull String email;
	
	private @NonNull String password;
	
	
}
