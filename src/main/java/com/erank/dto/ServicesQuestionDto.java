package com.erank.dto;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesQuestionDto {
	
	private Long servicesquestion_id;
	private String question;
    private Long services_id;
	private Long question_type;
	private LocalDate modified_date;

}
