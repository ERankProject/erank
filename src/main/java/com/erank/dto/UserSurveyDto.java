package com.erank.dto;



import java.time.LocalDate;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSurveyDto { 
	private Long id;
    private Long services_id;
	private Long servicesquestion_id;
	private Long response;
	private String response_label;
	private String patient_name;
	private String uhid_no;
	private String phNum;
	private String email;
	private Long score;
	private LocalDate recieved_date;
	private String service_name;
	private LocalDate endDate;
	private LocalDate startDate;
	private LocalDate patient_discharge_date;
	
}
