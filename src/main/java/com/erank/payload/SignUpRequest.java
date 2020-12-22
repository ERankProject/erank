package com.erank.payload;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest { 
	
	private @NonNull String name;
	@Email
	private @NonNull String email;
	private @NonNull String password;
	private @NonNull String phNum;

}
