package com.erank.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSurveyDto { 
	private Long id;
	private Long userid;
	private Long servicesquestion_id;
	private Long response;
	private String response_label;
	private String patient_name;
	private String uhid_no;
	private String phNum;
	private String email;
	private Long score;
}
