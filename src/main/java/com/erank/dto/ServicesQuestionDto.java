package com.erank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesQuestionDto {
	
	private Long servicesquestion_id;
	private String question;
	private Boolean is_option_enabled = true;
	private Boolean is_rating_enabled = true;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String option_5;
	private String option_6;
	private Long services_id;
	
	

}
