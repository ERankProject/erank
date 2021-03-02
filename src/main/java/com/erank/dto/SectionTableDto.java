package com.erank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionTableDto {
	
	private Long section_id;
	private Long services_id;
	private String section_name;
	private Boolean is_enabled = true;
	private LocalDate created_date;
	private String created_by;
	private LocalDate modified_date;
	private String modified_by;

}
