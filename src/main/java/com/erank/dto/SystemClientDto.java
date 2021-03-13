package com.erank.dto;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemClientDto {

	private Long system_client_id;
	private Long system_domain_id;
	private String company_name; 
	private Long registered_id;
	private @NonNull String client_name;
	private String category;
	private @NonNull String phNum;
	private @NonNull String email;
	private String street;
	private String city;
	private String state;
	private String pincode;
	private String password;
	private LocalDateTime created_date;
	private LocalDateTime modified_date;
}
