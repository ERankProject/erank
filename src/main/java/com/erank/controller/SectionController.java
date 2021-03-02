package com.erank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erank.dto.SectionTableDto;
import com.erank.model.SectionTable;
import com.erank.service.SectionTableService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/section")
public class SectionController {

	@Autowired
	private SectionTableService sectionService;
	
	@GetMapping("/all")
	public List<SectionTable>  findAll(){
		return sectionService.getSections();
	}
	
	@GetMapping("/{id}")
	public Optional<SectionTable> findById(Long id) {
		return sectionService.getTableById(id);
	}
	
	@PostMapping("/add")
	public SectionTable saveSection(SectionTableDto sectionDto) {
		return sectionService.addSection(sectionDto);
	}
	
	@PutMapping("/update")
	public SectionTable update(Long id,SectionTableDto sectionDto) {
		return sectionService.updateSection(id, sectionDto);
	}
}
