package com.erank.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSurveyDto { 
	private Long id;
	private Long userid;
	private Long servicesquestion_id;
	private String user_rating;
	private String user_answer;
	private String patient_name;
	private String uhid_no;
	private String phNum;
	private String email;
}
